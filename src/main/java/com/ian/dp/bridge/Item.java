package com.ian.dp.bridge;

public class Item {

	private String id;
	private String material;
	private int quantity;
	private String unit;
	private double price;
	
	public void show(){
		System.out.println("发票明细： " + " 商品名： " + material + " 数量：" + quantity + unit + " 单价：" + price);
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
