package com.ian.dp.abs.factory;

public class AccessFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new AccessUser();
	}
}
