package com.ian.dp.proxy;

public class Person implements SendGift{

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void sendFlower() {
		System.out.println(name + ", please take the flower.");
	}

	@Override
	public void sendChocolate() {
		System.out.println(name + ", please take the chocolate.");
	}

	@Override
	public void sendPen() {
		System.out.println(name + ", please take the pen.");
	}

}
