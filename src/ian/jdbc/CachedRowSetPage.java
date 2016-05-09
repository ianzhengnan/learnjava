package ian.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.util.Properties;
import java.io.FileInputStream;


public class CachedRowSetPage{

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;

	public void initParam(String paramFile) throws Exception{

		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("password");
	}

	public CachedRowSet query(String sql, int pageSize, int page) throws Exception{

		Class.forName(driver);
		try(
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			){
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet cachedRs = factory.createCachedRowSet();

				cachedRs.setPageSize(pageSize);
				cachedRs.populate(rs, (page -1) * pageSize + 1);
				return cachedRs;
		}
	}

	public static void main(String[] args) throws Exception {
		
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.initParam("mysql.ini");
		System.out.println("--------------第一页------------------");
		CachedRowSet rs = cp.query("select * from student_table", 3, 1);
		while(rs.next()){
			System.out.println(rs.getString(1)
				+ "\t" + rs.getString(2)
				+ "\t" + rs.getString(3));
		}
		System.out.println("--------------第二页------------------");
		rs = cp.query("select * from student_table", 3, 2);
		while(rs.next()){
			System.out.println(rs.getString(1)
				+ "\t" + rs.getString(2)
				+ "\t" + rs.getString(3));
		}
	}

}