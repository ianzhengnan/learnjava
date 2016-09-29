package com.ian.dp.oberver;

public class StockObserver extends Observer{

	public StockObserver(String name, Subject subject) {
		super(name, subject);
	}

	@Override
	public void update() {
		System.out.println(subject.getState() + " " + name + " 关闭股票行情，继续工作！");
	}

	
}
