package com.ian.dp.flyweight;

public class ConcreteWebsite implements Website{

	private String name;
	
	public ConcreteWebsite(String name) {
		this.name = name;
	}
	
	@Override
	public void use(User user) {
		System.out.println("网站分类： " + name + " 用户：" + user.getName());
	}
}
