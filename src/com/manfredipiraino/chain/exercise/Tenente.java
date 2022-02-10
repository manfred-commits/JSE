package com.manfredipiraino.chain.exercise;

public class Tenente extends Ufficiale{

	public Tenente (int level){
        this.myLevel = level;
        mySalary= 3000.0d;
     } 
	/*methods*/
	@Override
	protected void mySendMessage() {
		System.out.print("Tenente -> ");
	    System.out.println(mySalary); 
	}

}
