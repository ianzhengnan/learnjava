package com.ian.dp.chapter1;

public class OperationFactory{

	public static Operation createOperation(String operation){

		Operation op = null;
		switch(operation){

			case "+":
				op = new OperationAdd();
				break;
			case "-":
				op = new OperationSub();
				break;
			case "/":
				op = new OperationDiv();
				break;
			case "*":
				op = new OperationMutiple();
				break;
		}

		return op;
	}
}