package com.manfredipiraino.decorator.exercise;

public abstract class DecoratorConsumazione extends Consumazione {
	protected Consumazione prodotto;
	protected int quantity=1;
	
	DecoratorConsumazione(Consumazione prodotto, int quantity){
		this.prodotto=prodotto;
		this.quantity=quantity;
	}
	@Override
	public String getProductName() {
		return productName;
	}
}
