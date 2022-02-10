package com.manfredipiraino.observer.exe;

abstract class Giornalista implements Observer{
	protected Ansa mySubject;
	
	public abstract void myUpdate();
}