package com.ian.dp.iterator;

import java.util.ArrayList;
import java.util.List;

public class Products implements Aggregate{

	private List<Product> items = new ArrayList<>();
	
	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	@Override
	public Iterator createIterator() {
		return new ProductIterator(this);
	}

}
