package com.ian.dp.mediator;

public class ConcreteColleague2 extends Colleague{
	
	public ConcreteColleague2(Mediator mediator){
		super(mediator);
	}

	public void send(String msg){
		mediator.send(msg, this);
	}
	
	@Override
	public void notice(String message) {
		System.out.println("同事2接收到信息：" + message);
	}
	
	
}
