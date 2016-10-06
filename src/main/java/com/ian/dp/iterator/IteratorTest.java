package com.ian.dp.iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Products products = new Products();
		
		products.getItems().add(new Product("张三"));
		products.getItems().add(new Product("李四"));
		products.getItems().add(new Product("王五"));
		products.getItems().add(new Product("赵钱"));
		
		//
		ProductIterator pi = new ProductIterator(products);
		
		while (!pi.isDone()) {
			System.out.println(pi.currentItem());
			pi.next();
		}
	}
}
