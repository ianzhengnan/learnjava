package com.ian.dp.bridge;

import java.util.Date;

public class BridgetTest {

	public static void main(String[] args) {
		
		Invoice invoice = new Invoice();
		
		Header header = new Header();
		header.setCreatAt(new Date());
		header.setCustomer("上海市良友股份有限公司");
		header.setCustomerAddress("上海市仙霞路1110号");
		header.setId("1");
		
		Item item1 = new Item();
		item1.setId(header.getId());
		item1.setMaterial("棉花");
		item1.setQuantity(200);
		item1.setUnit("斤");
		item1.setPrice(3.0);
		
		Item item2 = new Item();
		item2.setId(header.getId());
		item2.setMaterial("大豆");
		item2.setQuantity(300);
		item2.setUnit("斤");
		item2.setPrice(3.0);
		
		invoice.setHeader(header);
		invoice.getItems().add(item1);
		invoice.getItems().add(item2);
		
		invoice.display();
		
	}
}
