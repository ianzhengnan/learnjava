package com.ian.dp.state;

public class Context {

	private State state;
	public Context(State state){
		this.state = state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
		System.out.println("Set state " + state.getName());
	}
	
	public void request(){
		state.handle(this);
	}
}
