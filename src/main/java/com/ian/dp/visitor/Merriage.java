package com.ian.dp.visitor;

public class Merriage implements Action{

	private String name = "结婚";
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void getManConclusion(Man man) {
		System.out.println(man.getName() + " " + this.getName() + "时， 感慨道：恋爱游戏终结，‘有妻徒刑’遥遥无期。。。");
	}

	@Override
	public void getWomanConclusion(Woman woman) {
		System.out.println(woman.getName() + " " + this.getName() + "时，欣慰曰：爱情长跑路漫漫，婚姻保险保平安！ ");
	}
	
	
}
