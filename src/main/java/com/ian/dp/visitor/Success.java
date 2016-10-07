package com.ian.dp.visitor;

public class Success implements Action{

	private String name = "成功";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void getManConclusion(Man man) {
		System.out.println(man.getName() + " " + this.getName() + "时， 背后多半有个伟大的女人");
	}

	@Override
	public void getWomanConclusion(Woman woman) {
		System.out.println(woman.getName() + " " + this.getName() + "时， 背后多半有个不成功的男人");
	}
	
	
}
