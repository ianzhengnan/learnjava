package com.ian.dp.strategy;

public class CashDiscount implements Casher{

	private double moneyRebate = 1d;
	
	public CashDiscount(String moneyRebate) {
		this.moneyRebate = Double.valueOf(moneyRebate);
	}
	
	@Override
	public double getCash(double money) {
		return money * moneyRebate;
	}
	
}
