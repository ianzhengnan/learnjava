package com.ian.dp.proxy;

public class Proxy implements SendGift{

	private Person person;
	
	public Proxy(String name) {
		this.person = new Person(name);
	}
	
	@Override
	public void sendFlower() {
		person.sendFlower();
	}

	@Override
	public void sendChocolate() {
		person.sendChocolate();
		// added functionality for person 
		System.out.println("Acutally, I love you.");
	}

	@Override
	public void sendPen() {
		person.sendPen();
	}

}
