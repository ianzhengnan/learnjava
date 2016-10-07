package com.ian.dp.visitor;

public class Man implements Person{

	private String name = "男人";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void accept(Action visitor) {
		visitor.getManConclusion(this);
	}

	
}
