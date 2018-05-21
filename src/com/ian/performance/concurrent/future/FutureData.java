package com.ian.performance.concurrent.future;

public class FutureData implements Data{

	protected RealData realData = null;
	
	protected boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		if(isReady)
			return;
		this.realData = realData;
		isReady = true;
		notifyAll();
	}
	
	@Override
	// if there is no synchronized, wait() will raise IllegalMonitorStateException exception
	public synchronized String getResult() {
		while(!isReady) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

	
}
