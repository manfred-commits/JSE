package com.manfredipiraino.observer.exe;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		Ansa myNews=new Ansa();
		
		new G1(myNews);
		new G2(myNews);
		new GR(myNews);
		
		myNews.setNotizia("Zero calorie al giorno, conducono ad una riduzione del grasso corporeo significativo");;

	}

}