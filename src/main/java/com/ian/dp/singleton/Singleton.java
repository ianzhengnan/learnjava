package com.ian.dp.singleton;

public class Singleton {

	//懒汉模式
	private static Singleton instance;
	
	private Singleton() {

	}
	
	//保证多线程的情况下运行正常
	public static synchronized Singleton getInstance(){
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//饿汉模式 --常用--无需为多线程写控制代码
	/*private static Singleton instance = new Singleton();
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return instance;
	}*/
}
