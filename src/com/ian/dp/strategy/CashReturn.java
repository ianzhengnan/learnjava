package com.ian.dp.strategy;

public class CashReturn implements Casher{

	private double moneyCondition = 0.0d;
	private double moneyReturn = 0.0d;
	
	public CashReturn(String moneyCondition, String moneyReturn) {
		this.moneyCondition = Double.valueOf(moneyCondition);
		this.moneyReturn = Double.valueOf(moneyReturn);
	}
	
	@Override
	public double getCash(double money) {
		double result = money;
		if (money >= this.moneyCondition) {
			result = money - Math.floor(money / moneyCondition) * moneyReturn; 
		}
		return result;
	}

}
