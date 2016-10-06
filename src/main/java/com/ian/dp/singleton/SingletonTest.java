package com.ian.dp.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		if (instance1 == instance2) {
			System.out.println("两个对象是相等的");
		}else{
			System.out.println("两个对象是不等的");
		}
	}
}
