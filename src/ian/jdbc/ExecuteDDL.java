package ian.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;

public class ExecuteDDL{

	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile) throws Exception{

		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("password");
	}

	public void createTable(String sql) throws Exception{

		Class.forName(driver);
		try(
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
			){
			stmt.executeUpdate(sql);
		}
	}

	public static void main(String[] args) throws Exception {
		
		ExecuteDDL ed = new ExecuteDDL();
		ed.initParam("mysql.ini");
		ed.createTable("create table jdbc_test " 
			+ "( jdbc_id int auto_increment primary key, "
			+ "jdbc_name varchar(255), "
			+ "jdbc_desc text);"
			);
		System.out.println("------建表成功-------");
	}

}