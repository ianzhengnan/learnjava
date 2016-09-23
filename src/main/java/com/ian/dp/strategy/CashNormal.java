package com.ian.dp.strategy;

public class CashNormal implements Casher{

	@Override
	public double getCash(double money) {
		return money;
	}

}
