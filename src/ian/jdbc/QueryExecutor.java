package ian.jdbc;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;

import java.util.Vector;
import java.util.Properties;

import java.io.FileInputStream;


public class QueryExecutor{

	private JFrame jf = new JFrame("查询执行器");
	private JScrollPane scrollPane;
	private JButton execBtn = new JButton("查询");

	private JTextField sqlField = new JTextField(45);
	private static Connection conn;
	private static Statement stmt;

	static{

		try{
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("password");

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// initial the screen
	public void init(){
		JPanel top = new JPanel();
		top.add(new JLabel("输入查询语句："));
		top.add(sqlField);
		top.add(execBtn);
		// press button to execute sql;
		execBtn.addActionListener(new ExecListener());
		// press 'enter' to execute sql;
		sqlField.addActionListener(new ExecListener());

		jf.add(top, BorderLayout.NORTH);
		jf.setSize(880,480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	// add listener
	class ExecListener implements ActionListener{

		public void actionPerformed(ActionEvent evt){

			if (scrollPane != null) {
				jf.remove(scrollPane);
			}

			try(
					ResultSet rs = stmt.executeQuery(sqlField.getText());
				){
					// get metadata from resultset
					ResultSetMetaData rsmd = rs.getMetaData();
					Vector<String> columnNames = new Vector<>();
					Vector<Vector<String>> data = new Vector<>();

					// add all column names to vector
					for (int i = 0;i < rsmd.getColumnCount() ; i++ ) {
						columnNames.add(rsmd.getColumnName(i + 1));
					}

					while (rs.next()) {
						Vector<String> v = new Vector<>();
						for (int i = 0; i < rsmd.getColumnCount() ; i++) {
							v.add(rs.getString(i + 1));
						}
						data.add(v);
					}

					// create jtable
					JTable table = new JTable(data, columnNames);
					scrollPane = new JScrollPane(table);
					jf.add(scrollPane);
					// update main screen
					jf.validate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		new QueryExecutor().init();
	}

}