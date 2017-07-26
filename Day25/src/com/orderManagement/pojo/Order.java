package com.orderManagement.pojo;

public class Order {
	private int id;
	private int status;
	private int number;
	private int goods_id;
	private int order_cart_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrder_cart_id() {
		return order_cart_id;
	}
	public void setOrder_cart_id(int order_cart_id) {
		this.order_cart_id = order_cart_id;
	}
}
