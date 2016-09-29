package com.ian.dp.state;

public abstract class State {

	protected String name;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void handle(Context context);
}
