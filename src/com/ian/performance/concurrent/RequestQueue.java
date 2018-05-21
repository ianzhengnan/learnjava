package com.ian.performance.concurrent;

import java.util.LinkedList;

public class RequestQueue {

	private LinkedList<Request> queue = new LinkedList<>();
	
	public synchronized Request getRequest() {
		while(queue.size() == 0) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return queue.remove();
	}
	
	public synchronized void addRequest(Request request) {
		queue.add(request);
		notifyAll();
	}
	
	
}
