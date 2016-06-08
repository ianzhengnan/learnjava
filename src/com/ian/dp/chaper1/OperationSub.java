package com.ian.dp.chapter1;

public class OperationSub extends Operation{

	@Override
	public double getResult(){
		double result = getNumberA() - getNumberB();
		return result;
	}
}