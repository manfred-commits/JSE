package com.manfredipiraino.chain.exercise;

public class Generale extends Ufficiale{
	
	public Generale (int level){
        this.myLevel = level;
        mySalary= 5000.0d;
     } 
	/*methods*/
	@Override
	protected void mySendMessage() {
		System.out.print("Generale -> ");
	    System.out.println(mySalary); 
	}

}
