package ian.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.FileInputStream;

public class ExecuteSQL{

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

	public void executeSql(String sql) throws Exception{

		Class.forName(driver);
		try(
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
			){
			boolean hasResultSet = stmt.execute(sql);
			if (hasResultSet) {
				try(
						ResultSet rs = stmt.getResultSet();
					){

					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();

					while(rs.next()){
						for (int i = 0; i < columnCount ; i++) {
							System.out.println(rs.getString(i + 1) + "\t");
						}
						System.out.println("\n");
					}
				}
			}else{
				System.out.println("该sql语句影响的记录有" + stmt.getUpdateCount() + "条");
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		ExecuteSQL es = new ExecuteSQL();
		es.initParam("mysql.ini");
		System.out.println("------------执行删除表的DDL语句------------");
		es.executeSql("drop table if exists my_test");
		
		System.out.println("------------执行建表的DML语句------------");
		es.executeSql("create table my_test" 
			+ "(test_id int auto_increment primary key, "
			+ "test_name varchar(255))");

		System.out.println("------------执行插入数据的DML语句------------");
		es.executeSql("insert into my_test(test_name) " + "select student_name from student_table");

		System.out.println("------------执行查询数据的查询语句------------");
	 	es.executeSql("select * from student_table");
	}

}