package com.ian.inter.test;

public class TestImpl implements Test{

	public void test(){
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		Test test = new TestImpl();
		test.test();
	}
}
