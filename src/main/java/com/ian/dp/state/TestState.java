package com.ian.dp.state;

public class TestState {

	public static void main(String[] args) {
		Context c = new Context(new ConcreteStateA());
		c.request();
		c.request();
		c.request();
		c.request();
	}
}
