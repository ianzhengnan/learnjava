package com.ian.dp.visitor;

public class Love implements Action{

	private String name = "恋爱";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void getManConclusion(Man man) {
		System.out.println(man.getName() + " " + this.getName() + "时， 凡事不懂也要装懂");
	}

	@Override
	public void getWomanConclusion(Woman woman) {
		System.out.println(woman.getName() + " " + this.getName() + "时，遇事懂也装不懂");
	}
	
	
}
