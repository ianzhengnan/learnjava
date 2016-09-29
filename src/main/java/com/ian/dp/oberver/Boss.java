package com.ian.dp.oberver;

import java.util.ArrayList;
import java.util.List;


public class Boss implements Subject{

	private List<Observer> observers = new ArrayList<>();
	private String state;
	
	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notification() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
