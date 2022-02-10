package com.manfredipiraino.decorator.exercise;

public class Client {

	public static void main(String[] args) {
		
		Consumazione myHamburger=new Hamburger();
		Consumazione myCheeseburger=new Cheeseburger();
		
		System.out.printf("Prezzo Hamburger: %.2f euro\n",+myHamburger.getPrice());
		System.out.printf("Prezzo Cheeseburger: %.2f euro\n",myCheeseburger.getPrice());
		
		Consumazione meal1=new DecoratorMaionese(myHamburger,2);
		System.out.printf("Hamburger + mayonnaise (0.50 x 2): %.2f euro\n",meal1.getPrice());
		
		Consumazione meal2=new DecoratorKetchup(myCheeseburger,3);
		System.out.printf("Cheeseburger + ketchup (0.80 x 3): %.2f euro\n",meal2.getPrice());
		
		Consumazione meal3=new DecoratorKetchup(meal1,2);
		System.out.printf("Cheeseburger + mayonnaise (0.50 x 2) + ketchup (0.80 x 3): %.2f euro\n",meal3.getPrice());
	}

}
