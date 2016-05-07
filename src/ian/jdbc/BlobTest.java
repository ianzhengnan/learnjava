package ian.jdbc;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Blob;

import java.util.Properties;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class BlobTest{

	JFrame jf = new JFrame("图片管理器");
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;

	private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();

	private JList<ImageHolder> imageList = new JList<>(imageModel);
	private JTextField filePath = new JTextField(26);
	private JButton browserBn = new JButton("...");
	private JButton uploadBn = new JButton("上传");
	private JLabel imageLabel = new JLabel();

	JFileChooser chooser = new JFileChooser(".");

	ExtensionFileFilter filter = new ExtensionFileFilter();
	static
	{
		try{
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("password");

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, pass);

			insert = conn.prepareStatement("insert into img_table"
				+ " values(null,?,?)", Statement.RETURN_GENERATED_KEYS);

			query = conn.prepareStatement("select img_data from img_table" 
				+ " where img_id = ?");

			queryAll = conn.prepareStatement("select img_id, "
				+ " img_name from img_table");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void init() throws SQLException{

		// 初始化文件选择器
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);

		chooser.setAcceptAllFileFilterUsed(false);

		// 初始化程序界面
		fillListModel();
		filePath.setEditable(false);

		imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp = new JPanel();
		jp.add(filePath);
		jp.add(browserBn);
		browserBn.addActionListener(event -> {
			int result = chooser.showDialog(jf, "浏览图片文件上传");

			if (result == JFileChooser.APPROVE_OPTION) {
				filePath.setText(chooser.getSelectedFile().getPath());
			}
		});
		jp.add(uploadBn);
		uploadBn.addActionListener(event -> {
			if (filePath.getText().trim().length() > 0) {
				// 将指定文件保存到数据库
				upload(filePath.getText());
				// 清空文本框内容
				filePath.setText("");
			}
		});

		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
		left.add(jp, BorderLayout.SOUTH);
		
		jf.add(left);
		imageList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imageList), BorderLayout.EAST);

		imageList.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){
				// 如果鼠标双击
				if (e.getClickCount() >= 2) {
					// 取出选中的List项
					ImageHolder cur = (ImageHolder)imageList.getSelectedValue();
					try{
						// 显示选中项对应的image
						 showImage(cur.getId());
					} catch(SQLException sqle){
						sqle.printStackTrace();
					}
				}
			}
		});
		jf.setSize(1000, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	// 查找 img_table填充ListModel
	public void fillListModel() throws SQLException{

		try(
				ResultSet rs = queryAll.executeQuery();
			){
				// 先清除所有元素
				imageModel.clear();
				//
				while(rs.next()){
					imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
				}
		}
	}

	// 将指定图片放入数据库
	public void upload(String fileName){

		// get file name
		String imageName = fileName.substring(fileName.lastIndexOf("\\")
			+ 1, fileName.lastIndexOf('.'));
		File f = new File(fileName);
		try(
				InputStream is = new FileInputStream(f);
			){

				insert.setString(1, imageName);
				// set binary stream
				insert.setBinaryStream(2, is, (int)f.length());
				int affect = insert.executeUpdate();
				if (affect == 1) {
					// re_update listModel it will refresh the image in image list
					fillListModel();
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//  根据图片id来显示图片
	public void showImage(int id) throws SQLException{

		query.setInt(1, id);
		try(
				ResultSet rs = query.executeQuery();
			){
				if (rs.next()) {
					// get blob column
					Blob imgBlob = rs.getBlob(1);
					// get data from blob 
					ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int)imgBlob.length()));
					imageLabel.setIcon(icon);
				}
		}
	}

	public static void main(String[] args) throws SQLException{
		
		new BlobTest().init();
	}

}

// 创建filefilter的子类， 用以实现文件过滤功能
class ExtensionFileFilter extends FileFilter{

	private String desciption = "";
	private ArrayList<String> extensions = new ArrayList<>();

	// add extension file name
	public void addExtension(String extension){
		if (!extension.startsWith(".")) {
			extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}
	}

	// 设置该文件过滤器的描述文本
	public void setDescription(String aDescription){
		desciption = aDescription;
	}

	public String getDescription(){
		return desciption;
	}

	public boolean accept(File f){

		if (f.isDirectory()) {
			return true;
		}
		String name = f.getName().toLowerCase();
		for (String extension : extensions) {
			if (name.endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}

// 创建一个ImageHolder类，用于封装图片名，图片id
class ImageHolder{

	private int id;
	private String name;

	public ImageHolder(){}

	public ImageHolder(int id, String name){
		this.id = id;
		this.name = name;
	}

	int getId(){
		return this.id;
	}
	void setId(int id){
		this.id = id;
	}

	String getName(){
		return this.name;
	}
	void setName(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}

}




