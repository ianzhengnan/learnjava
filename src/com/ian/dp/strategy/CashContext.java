package com.ian.dp.strategy;

/**
 * 策略模式和简单工厂模式整合
 * @author I076453
 *
 */
public class CashContext {

	private Casher casher;
	public CashContext(String type) {
		switch (type) {
		case "正常收费":
			casher = new CashNormal();
			break;
		case "满300返100":
			casher = new CashReturn("300", "100");
			break;
		case "打8折":
			casher = new CashDiscount("0.8");
			break;
		default:
			break;
		}
	}
	
	public double getResult(double money){
		return casher.getCash(money);
	}
}
