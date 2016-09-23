package com.ian.dp.simple.factory;

public class OperationAdd extends Operation{

	@Override
	public double getResult(){
		double result = getNumberA() + getNumberB();
		return result;
	}
}