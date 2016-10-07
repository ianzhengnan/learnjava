package com.ian.dp.mediator;

public abstract class Colleague {

	protected Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
	
	public abstract void notice(String message);
}
