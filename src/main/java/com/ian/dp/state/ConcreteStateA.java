package com.ian.dp.state;


public class ConcreteStateA extends State{

	public ConcreteStateA(){
		this.name = "StateA";
	}
	
	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateB());
	}

}
