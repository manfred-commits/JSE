package com.manfredipiraino.lambda;

import java.util.ArrayList;
import java.util.List;

public class MyEXE_Lambda1 {

	public static void main(String[] args) {
		
		List<Integer> myArrayList= new ArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		myArrayList.add(4);
		
		myArrayList.forEach((listElement)->System.out.println("numero della lista di partenza ("+listElement+") risultato moltiplicazione per 10: "+(10*listElement)));
		
		System.out.println("______________________________________");
		
		myArrayList.replaceAll((listElement)->listElement*10);
		myArrayList.forEach((listElement)->System.out.println("numero della lista di partenza ("+listElement/10+") "+listElement));
	}

}
