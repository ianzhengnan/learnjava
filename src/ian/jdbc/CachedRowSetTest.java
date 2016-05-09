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


public class CachedRowSetTest{

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

	public CachedRowSet query(String sql) throws Exception{

		Class.forName(driver);
		try(
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			){
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet cachedRs = factory.createCachedRowSet();
				cachedRs.populate(rs);
				return cachedRs;
		}
		
	}

	public static void main(String[] args) throws Exception{
		
		CachedRowSetTest ct = new CachedRowSetTest();
		ct.initParam("mysql.ini");
		CachedRowSet rs = ct.query("select * from student_table");
		rs.afterLast();

		while(rs.previous()){
			System.out.println(rs.getString(1)
				+ "\t" + rs.getString(2)
				+ "\t" + rs.getString(3));
			if (rs.getInt("student_id") == 3) {
				rs.updateString("student_name", "猪八戒");
				rs.updateRow();
			}
		}

		// get connection again
		Connection conn = DriverManager.getConnection(url, user, pass);
		conn.setAutoCommit(false);
		rs.acceptChanges(conn);
	}
}