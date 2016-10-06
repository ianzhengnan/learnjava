package com.ian.dp.iterator;


public class Product {

	private String name;
	
	public Product(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public String toString(){
		return "#" + this.name;
	}

}
