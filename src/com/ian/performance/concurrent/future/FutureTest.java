package com.ian.performance.concurrent.future;

public class FutureTest {

	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("数据 = " + data.getResult());
	}
}
