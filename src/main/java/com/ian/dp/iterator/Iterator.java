package com.ian.dp.iterator;

public interface Iterator {

	Object first();
	
	Object next();
	
	boolean isDone();
	
	Object currentItem();
}
