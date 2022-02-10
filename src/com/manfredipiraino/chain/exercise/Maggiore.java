package com.manfredipiraino.chain.exercise;

public class Maggiore extends Ufficiale{

	public Maggiore (int level){
        this.myLevel = level;
        mySalary= 2000.0d;
     } 
	/*methods*/
	@Override
	protected void mySendMessage() {
		System.out.print("Maggiore -> ");
	    System.out.println(mySalary); 
	}

}
