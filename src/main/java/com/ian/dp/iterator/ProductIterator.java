package com.ian.dp.iterator;

public class ProductIterator implements Iterator{

	private Products products;
	private int current;
	
	public ProductIterator(Products products) {
		this.products = products;
	}

	@Override
	public Object first() {
		return products.getItems().get(0);
	}

	@Override
	public Object next() {
		return products.getItems().get(current++);
	}

	@Override
	public boolean isDone() {
		return current >= products.getItems().size() ? true : false;
	}

	@Override
	public Object currentItem() {
		return products.getItems().get(current);
	}

}
