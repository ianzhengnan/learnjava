package com.ian.dp.chapter1;

public class OperationDiv extends Operation{

	@Override
	public double getResult(){

		if (getNumberB() == 0) {
			System.out.println("除数不可以为零");
			return 0;
		}
		double result = getNumberA() / getNumberB();
		return result;
	}
}