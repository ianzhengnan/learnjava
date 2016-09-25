package com.ian.dp.factorymethod;

public class UndergraduateFactory implements Factory{

	@Override
	public Leifeng createLeifeng() {
		return new Undergraduate();
	}

}
