package com.ian.performance.concurrent.future;

//import java.util.concurrent.Callable;

public class RealData implements Data{

	private String result;
	
	public RealData(String para) {
		// slow task
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sBuffer.append(para + "^");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		result = sBuffer.toString();
	}

	@Override
	public String getResult() {
		return result;
	}
	
	
	
//	@Override
/*	public String call() throws Exception {
		// slow task
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sBuffer.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sBuffer.toString();
	}*/

	
}
