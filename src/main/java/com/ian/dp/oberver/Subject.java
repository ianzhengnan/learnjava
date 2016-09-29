package com.ian.dp.oberver;

public interface Subject {

	void attach(Observer observer);
	
	void detach(Observer observer);
	
	void notification();
	
	String getState();
}
