package ian.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class ConnMySql{

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");

		try(
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/awesome", "root", "1234567");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from users");

			){
				while(rs.next()){
					System.out.println(rs.getString("name") + "\t" + rs.getString("email"));
				}
		}
	}
}