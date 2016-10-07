package com.ian.dp.mediator;

public class ConcreteMediator implements Mediator{

	private ConcreteColleague colleague1;
	private ConcreteColleague2 colleague2;
	
	@Override
	public void send(String message, Colleague colleague) {
		if (colleague == colleague1) {
			colleague2.notice(message);;
		}else{
			colleague1.notice(message);
		}
	}

	public void setColleague1(ConcreteColleague colleague1) {
		this.colleague1 = colleague1;
	}

	public void setColleague2(ConcreteColleague2 colleague2) {
		this.colleague2 = colleague2;
	}

}
