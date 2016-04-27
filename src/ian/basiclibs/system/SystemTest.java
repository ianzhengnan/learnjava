package ian.basiclibs.system;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Map;

public class SystemTest {

	public static void main(String[] args) throws Exception{

		Map<String, String> env = System.getenv();
		for (String name : env.keySet() ) {
			System.out.println(name + "--->" + env.get(name));
		}

		System.out.println(System.getenv("JAVA_HOME"));

		Properties props = System.getProperties();

		props.store(new FileOutputStream("props.txt"), "System Properties");

		System.out.println(System.getProperty("os.name"));

	}

}