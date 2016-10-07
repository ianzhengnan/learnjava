package com.ian.dp.mediator;

public class MediatorTest {

	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		
		ConcreteColleague colleague1 = new ConcreteColleague(mediator);
		ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
		
		mediator.setColleague1(colleague1);
		mediator.setColleague2(colleague2);
		
		colleague1.send("你吃了吗？");
		colleague2.send("吃了，你呢？");
	}
}
