package com.manfredipiraino.chain.exercise;

public class Colonnello extends Ufficiale{

	public Colonnello (int level){
        this.myLevel = level;
        mySalary= 4000.0d;
     } 
	/*methods*/
	@Override
	protected void mySendMessage() {
		System.out.print("Colonnello -> ");
	    System.out.println(mySalary); 
	}

}
