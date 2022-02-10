package com.manfredipiraino.chain.exercise;

public class Capitano extends Ufficiale{

	public Capitano (int level){
        this.myLevel = level;
        mySalary= 1000.0d;
     } 
	/*methods*/
	@Override
	protected void mySendMessage() {
		System.out.print("Capitano -> ");
	    System.out.println(mySalary); 
	}

}
