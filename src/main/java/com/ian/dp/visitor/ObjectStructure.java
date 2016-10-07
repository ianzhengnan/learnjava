package com.ian.dp.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

	private List<Person> elements = new ArrayList<>();
	
	public void attach(Person person){
		elements.add(person);
	}
	
	public void remove(Person person){
		elements.remove(person);
	}
	
	public void display(Action visitor){
		for (Person person : elements) {
			person.accept(visitor);
		}
	}
}
