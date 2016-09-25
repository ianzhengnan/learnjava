package com.ian.dp.factorymethod;

public class FactoryMethodTest {

	public static void main(String[] args) {
		
		Factory factory = new UndergraduateFactory();
		Leifeng leifeng = factory.createLeifeng();
		
		leifeng.buyRice();
		leifeng.sweep();
		leifeng.wash();
		
		Factory factory2 = new VolunteerFactory();
		Leifeng leifeng2 = factory2.createLeifeng();
		
		leifeng2.buyRice();
		leifeng2.sweep();
		leifeng2.wash();
	}
}
  