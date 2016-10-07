package com.ian.dp.visitor;

public class Fail implements Action{

	private String name = "失败";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void getManConclusion(Man man) {
		System.out.println(man.getName() + " " + this.getName() + "时， 闷头喝酒，谁也不用劝");
	}

	@Override
	public void getWomanConclusion(Woman woman) {
		System.out.println(woman.getName() + " " + this.getName() + "时， 眼泪汪汪，谁也劝不了");
	}
	
	
}
