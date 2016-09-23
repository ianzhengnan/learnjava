package com.ian.dp.decorator;

public class TShirts extends Decorator{

	@Override
	public void show(){
		System.out.println("大T恤");
		super.show();
	}
}
