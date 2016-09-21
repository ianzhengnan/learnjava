package com.ian.dp.chaper1;


public class OperationTest{
	
	
	public static void main(String[] args) {
		
		Operation addOperation = OperationFactory.createOperation("+");
		addOperation.setNumberA(20);
		addOperation.setNumberB(30);
		System.out.println(addOperation.getResult());
		
	}

}