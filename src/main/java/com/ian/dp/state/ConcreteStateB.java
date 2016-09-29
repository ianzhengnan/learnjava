package com.ian.dp.state;

public class ConcreteStateB extends State{
	
	public ConcreteStateB(){
		this.name = "StateB";
	}
	
	@Override
	public void handle(Context context) {
		setName("StateB");
		context.setState(new ConcreteStateA());
	}
	
}
