package com.ian.dp.mediator;

public class ConcreteColleague extends Colleague{

	public ConcreteColleague(Mediator mediator) {
		super(mediator);
	}

	public void send(String msg){
		mediator.send(msg, this);
	}
	
	@Override
	public void notice(String message) {
		System.out.println("同事1接收到消息:" + message);
	}

	
}
