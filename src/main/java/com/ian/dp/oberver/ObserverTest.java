package com.ian.dp.oberver;

public class ObserverTest {

	public static void main(String[] args) {
		Boss huhansan = new Boss();
		
		StockObserver ian = new StockObserver("郑楠", huhansan);
		StockObserver kaka = new StockObserver("卡卡", huhansan);
		
		huhansan.attach(ian);
		huhansan.attach(kaka);
		
		huhansan.setState("我胡汉三回来了");
		huhansan.notification();
	}
}
