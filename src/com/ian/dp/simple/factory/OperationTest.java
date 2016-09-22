package com.ian.dp.simple.factory;


public class OperationTest{
	
	
	public static void main(String[] args) {
		
		Operation addOperation = OperationFactory.createOperation("+");
		addOperation.setNumberA(20);
		addOperation.setNumberB(30);
		System.out.println(addOperation.getResult());
		
	}

}