package com.manfredipiraino.chain.exercise;

abstract class Ufficiale {
	protected int myLevel;
	protected double mySalary;
	protected Ufficiale myNextChainElement;

	
	public void Ufficiale(Ufficiale myNextChainElement){
	  this.myNextChainElement = myNextChainElement;
	}
	public void mySetNextChainElement(Ufficiale myNextChainElement){
	     this.myNextChainElement = myNextChainElement;
	  }
	public void hasSalaryAtLeastAt(double salary){      
	  if(mySalary>=salary) {
	      mySendMessage();
	  }
	  if(myNextChainElement !=null){
		  myNextChainElement.hasSalaryAtLeastAt(salary);
	  }
	  if(myNextChainElement ==null && !(mySalary>=salary)) {
		  System.out.println("Nessuno guadagna questa cifra");
	  }
	}

	abstract protected void mySendMessage(); 

}
