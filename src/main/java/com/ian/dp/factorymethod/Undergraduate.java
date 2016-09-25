package com.ian.dp.factorymethod;

public class Undergraduate implements Leifeng{

	@Override
	public void buyRice() {
		System.out.println("Undergraduate is buying rice.");
	}

	@Override
	public void sweep() {
		System.out.println("Undergraduate is sweeping.");
	}

	@Override
	public void wash() {
		System.out.println("Undergraduate is washing.");
	}
	
	
}
