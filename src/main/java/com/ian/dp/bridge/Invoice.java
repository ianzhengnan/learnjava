package com.ian.dp.bridge;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

	private Header header;
	private List<Item> items = new ArrayList<>();
	
	public Header getHeader() {
		return header;
	}



	public void setHeader(Header header) {
		this.header = header;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public void display(){
		header.show();
		for (Item item : items) {
			item.show();
		}
	}
}
