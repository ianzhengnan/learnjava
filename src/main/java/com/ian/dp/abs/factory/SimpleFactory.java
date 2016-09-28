package com.ian.dp.abs.factory;

//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpleFactory {

	public static IUser createUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
//		IUser userMgr = null;
//		String type = "sqlserver";
		
//		switch (type) {
//		case "sqlserver":
//			userMgr = new SqlserverUser();
//			break;
//		case "access":
//			userMgr = new AccessUser();
//			break;
//		default:
//			break;
//		}
		
		Class<?> userMgr = null;
		
//		File file = new File("user.properties");
		
		try (
			// user.properties文件要放在learnjava的根目录， 而不是classes里面
			FileInputStream fileInputStream = new FileInputStream("user.properties");
				){
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String type = properties.getProperty("package") + "." + properties.getProperty("classname");
			userMgr = Class.forName(type);
		} catch (IOException e) {
			System.out.println("Cannot open file!");
			e.printStackTrace();
		}
		
		return (IUser)userMgr.newInstance();
	}
}
