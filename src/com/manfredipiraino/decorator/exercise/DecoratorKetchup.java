package com.manfredipiraino.decorator.exercise;

public class DecoratorKetchup extends DecoratorConsumazione{
	final protected double ketchupPrice=0.80d;
	
	DecoratorKetchup(Consumazione prodotto, int quantity){
		super(prodotto,quantity);
	}
	/*getter*/
	public double getKetchupPrice() {
		return ketchupPrice;
	}
	@Override
	public double getPrice() {
		return prodotto.getPrice()+(ketchupPrice*quantity);
	}
}
