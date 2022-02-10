package com.manfredipiraino.decorator.exercise;

public class Cheeseburger extends Consumazione{

	protected double price=3.30d;
	
	Cheeseburger(){
		productName="Cheeseburger";	
	}
	/*methods*/
	@Override
	public double getPrice() {
		return price;
	}

}
