package ian.reflect;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Driver;

import java.util.Properties;

import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderTest{

	private static Connection conn;

	public static Connection getConn(String url, String user, String pass) throws Exception{
		if (conn == null) {
			URL[] urls = {new URL("file:mysql-connector-java-5.1.38-bin.jar")};
			URLClassLoader myClassLoader = new URLClassLoader(urls);
			Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();

			Properties props = new Properties();
			props.setProperty("user", user);
			props.setProperty("password", pass);

			conn = driver.connect(url, props);
		}
		return conn;
	}

	public static void main(String[] args) throws Exception {
		try(
			Connection conne = getConn("jdbc:mysql://localhost:3306/awesome", "root", "1234567");
			//System.out.println(conne);
			Statement stmt = conne.createStatement();

			ResultSet rst = stmt.executeQuery("select * from users");
		){
			while(rst.next()){
				System.out.println(rst.getString("name") + "\t" + rst.getString("email"));
			}
		}
	}
}