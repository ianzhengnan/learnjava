package com.ian.dp.factorymethod;

public class Volunteer implements Leifeng{

	@Override
	public void buyRice() {
		System.out.println("Volunteer is buying rice.");
	}

	@Override
	public void sweep() {
		System.out.println("Volunteer is sweeping.");
	}

	@Override
	public void wash() {
		System.out.println("Volunteer is washing.");
	}

}
