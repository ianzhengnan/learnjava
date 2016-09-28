package com.ian.dp.abs.factory;

public class SqlserverFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new SqlserverUser();
	}

}
