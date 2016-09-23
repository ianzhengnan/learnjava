package com.ian.dp.decorator;

public abstract class Decorator extends Person{

	private Person person;
	
	public void decorate(Person person){
		this.person = person;
	}
	
	@Override
	public void show(){
		if (person != null) {
			person.show();
		}
	}
}
