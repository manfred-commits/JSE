package com.manfredipiraino.decorator.exercise;

public class DecoratorMaionese extends DecoratorConsumazione{
	final protected double mayoPrice=0.50d;
	
	DecoratorMaionese(Consumazione prodotto, int quantity){
		super(prodotto,quantity);
	}
	/*getter*/
	public double getMayoPrice() {
		return mayoPrice;
	}
	@Override
	public double getPrice() {
		return prodotto.getPrice()+(mayoPrice*quantity);
	}

}
