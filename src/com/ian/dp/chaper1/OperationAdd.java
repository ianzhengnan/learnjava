package com.ian.dp.chaper1;

public class OperationAdd extends Operation{

	@Override
	public double getResult(){
		double result = getNumberA() + getNumberB();
		return result;
	}
}