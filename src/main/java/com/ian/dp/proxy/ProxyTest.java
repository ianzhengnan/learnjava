package com.ian.dp.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Girl jiaojiao = new Girl("Jiao Jiao");
		Proxy zhengnan = new Proxy(jiaojiao.getName());
		
		zhengnan.sendFlower();
		zhengnan.sendChocolate();
		zhengnan.sendPen();
		
	}
}
