package com.ian.dp.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private List<String> list = new ArrayList<String>();
	
	public void add(String part){
		list.add(part);
	}
	
	public void show(){
		System.out.println("产品创建－－－－");
		for (String part : list) {
			System.out.println(part);
		}
	}
}
