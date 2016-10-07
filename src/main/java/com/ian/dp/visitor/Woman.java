package com.ian.dp.visitor;

public class Woman implements Person{

	private String name = "女人";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void accept(Action visitor) {
		visitor.getWomanConclusion(this);
	}

}
