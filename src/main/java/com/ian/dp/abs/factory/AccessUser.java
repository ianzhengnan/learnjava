package com.ian.dp.abs.factory;

public class AccessUser implements IUser{

	@Override
	public void insert(User user) {
		System.out.println("在Access中插入一个用户");
	}

	@Override
	public User getUser(int id) {
		System.out.println("在Access中获取一个用户");
		return null;
	}

}
