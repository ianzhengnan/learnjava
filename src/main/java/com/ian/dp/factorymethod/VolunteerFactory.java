package com.ian.dp.factorymethod;

public class VolunteerFactory implements Factory{

	@Override
	public Leifeng createLeifeng() {
		return new Volunteer();
	}
	
}
