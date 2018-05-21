package com.ian.performance.concurrent;

import com.ian.performance.concurrent.future.FutureData;
import com.ian.performance.concurrent.future.RealData;

public class ServerThread extends Thread{

	private RequestQueue requestQueue;

	public ServerThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}
	
	public void run() {
		while (true) {
			final Request request = requestQueue.getRequest();
			final FutureData futureData = (FutureData)request.getResponse();
			// slow to get real data 
			RealData realData = new RealData(request.getName());
			// inform client when it ready
			futureData.setRealData(realData);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}
	
	
	
	
}
