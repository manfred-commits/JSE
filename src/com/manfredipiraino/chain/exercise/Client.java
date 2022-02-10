package com.manfredipiraino.chain.exercise;

public class Client {

	public static void main(String[] args) {

		Ufficiale myGeneral=new Generale(0);
		Ufficiale myColonel=new Colonnello(1);
		Ufficiale myLieutenant=new Tenente(2);
		Ufficiale myMajor=new Maggiore(3);
		Ufficiale myCaptain=new Capitano(4);
		
		myCaptain.mySetNextChainElement(myMajor);
		myMajor.mySetNextChainElement(myLieutenant);
		myLieutenant.mySetNextChainElement(myColonel);
		myColonel.mySetNextChainElement(myGeneral);
		
		myCaptain.hasSalaryAtLeastAt(5000.1);
	}

}