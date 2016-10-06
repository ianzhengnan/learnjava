package com.ian.dp.bridge;

import java.util.Date;

public class Header {

	private String id;
	private Date creatAt;
	private String customer;
	private String customerAddress;
	
	public Header() {
		
	}
	
	
	public void show(){
		System.out.println("发票头：" + " 客户： " + customer + " 发票地址：" + customerAddress + " 开票日： " + creatAt);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
