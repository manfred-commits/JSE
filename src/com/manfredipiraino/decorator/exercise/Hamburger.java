package com.manfredipiraino.decorator.exercise;

public class Hamburger extends Consumazione{
	protected double price=3.00d;
	
	Hamburger(){
		productName="Hamburger";	
	}
	/*methods*/
	@Override
	public double getPrice() {
		return price;
	}
	
}
