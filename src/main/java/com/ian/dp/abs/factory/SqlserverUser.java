package com.ian.dp.abs.factory;

public class SqlserverUser implements IUser{

	@Override
	public void insert(User user) {
		System.out.println("在SqlServer中插入一个用户");
	}

	@Override
	public User getUser(int id) {
		System.out.println("在SqlServer中获取一个用户");
		return null;
	}

}
