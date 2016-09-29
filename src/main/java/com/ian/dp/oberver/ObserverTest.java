package com.ian.dp.oberver;

public class ObserverTest {

	public static void main(String[] args) {
		Boss huhansan = new Boss();
//		Secretary lady = new Secretary();
		
		StockObserver ian = new StockObserver("郑楠", huhansan);
		StockObserver kaka = new StockObserver("卡卡", huhansan);
		NBAObserver flks = new NBAObserver("菲力克斯", huhansan);
		
		huhansan.attach(ian);
		huhansan.attach(kaka);
		huhansan.attach(flks);
		
		huhansan.setState("我胡汉三回来了");
		huhansan.notification();

		/*lady.attach(ian);
		lady.attach(kaka);
		lady.attach(flks);
		
		lady.setState("老板回来了");
		lady.notification();*/
	}
}
