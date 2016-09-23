package com.ian.dp.decorator;

public class SneakerShoes extends Decorator{

	@Override
	public void show(){
		System.out.println("破球鞋");
		super.show();
	}
}
