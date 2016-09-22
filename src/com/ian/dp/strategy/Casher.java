package com.ian.dp.strategy;

public interface Casher {
	
	/**
	 * 获取促销后的金额
	 * @param money
	 * @return
	 */
	double getCash(double money);
}
