package com.ian.dp.composite;

public class CompositeTest {

	public static void main(String[] args) {
		DIVCom root = new DIVCom("root");
		
		PCom p1 = new PCom("p1");
		
		
		root.add(p1);
		
		root.display(0);
	}
}
