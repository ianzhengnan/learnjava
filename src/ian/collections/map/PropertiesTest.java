package ian.collections.map;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class PropertiesTest{

	public static void main(String[] args) throws Exception{

		Properties props = new Properties();

		props.setProperty("username", "ian");
		props.setProperty("password", "1234567");
		props.store(new FileOutputStream("a.ini"), "commend line");

		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}
}