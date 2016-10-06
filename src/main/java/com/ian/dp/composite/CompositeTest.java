package com.ian.dp.composite;

public class CompositeTest {

	public static void main(String[] args) {
		DIVCom root = new DIVCom("root");
		
		PCom p1 = new PCom("p1");
		PCom p2 = new PCom("p2");
		PCom p3 = new PCom("p3");
		
		DIVCom d1 = new DIVCom("d1");
		DIVCom d2 = new DIVCom("d2");
		
		d2.add(p3);
		d1.add(d2);
		d1.add(p2);
		
		root.add(d1);
		root.add(p1);
		
		root.display(0);
	}
}
