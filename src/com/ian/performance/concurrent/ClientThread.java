package com.ian.performance.concurrent;

import java.util.ArrayList;
import java.util.List;

import com.ian.performance.concurrent.future.FutureData;

public class ClientThread extends Thread{

	private RequestQueue requestQueue;
	private List<Request> requests = new ArrayList<>();

	public ClientThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			Request request = new Request("Request ID: " + i + " Thread name: " + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			request.setResponse(new FutureData());
			requestQueue.addRequest(request);
			// send request
			requests.add(request);
			// do other jobs wait for server ready
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.println("ClientThread name is " + Thread.currentThread().getName());
		}
//		System.out.println(Thread.currentThread().getName() + " request end");
		
		for (Request r: requests) {
			System.out.println("ClientThread name is: " + Thread.currentThread().getName() + " Response is " + 
					// will wait if 
					r.getResponse().getResult());
		}
	}
	
	
}
