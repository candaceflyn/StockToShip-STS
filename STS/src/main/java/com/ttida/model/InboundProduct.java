package com.ttida.model;

import jakarta.persistence.*;

@Entity
@Table(name="inbound_product")
public class InboundProduct {
	@Id
	private Long product_code;
	private String name;
	private int current_stock;
	private int length;
	private int width;
	private int height;
	private double weight;

	public InboundProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InboundProduct(Long product_code, String name, int current_stock, int length, int width, int height,
			double weight) {
		super();
		this.product_code = product_code;
		this.name = name;
		this.current_stock = current_stock;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public Long getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Long product_code) {
		this.product_code = product_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrent_stock() {
		return current_stock;
	}

	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "InboundProduct [product_code=" + product_code + ", name=" + name + ", current_stock=" + current_stock
				+ ", length=" + length + ", width=" + width + ", height=" + height + ", weight=" + weight + "]";
	}

}
