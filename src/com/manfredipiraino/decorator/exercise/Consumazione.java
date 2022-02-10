package com.manfredipiraino.decorator.exercise;

public abstract class Consumazione {
	protected String productName;
	
	public String getProductName() {
		return productName;
	}
	public abstract double getPrice();
}
