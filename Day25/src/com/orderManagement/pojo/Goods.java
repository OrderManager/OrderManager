package com.orderManagement.pojo;

public class Goods {
	private int is_delete;
	private double price;
	private String name;
	private String content;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private int inventry;
	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	public int getInventry() {
		return inventry;
	}
	public void setInventry(int inventry) {
		this.inventry = inventry;
	}
	
}
