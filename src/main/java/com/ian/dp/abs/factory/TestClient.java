package com.ian.dp.abs.factory;

public class TestClient {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		User user = new User();
		
		//抽象工厂模式
//		IFactory factory = new AccessFactory();
//		
//		IUser userMgr = factory.createUser();
		
		//简单工厂模式
		IUser userMgr = SimpleFactory.createUser();
		
		userMgr.insert(user);
		userMgr.getUser(1);
		
	}
}
