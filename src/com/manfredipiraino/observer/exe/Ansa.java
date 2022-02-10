package com.manfredipiraino.observer.exe;

import java.util.ArrayList;
import java.util.List;

class Ansa implements Subject{
	private String notizia;
	final private List<Observer> myObservers = new ArrayList<Observer>();
	/*Getter*/
	public String getNotizia() {
		return notizia;
	}
	/*Setter*/
	public void setNotizia(String notizia) {
		this.notizia = notizia;
		System.out.println("Notizia dell'Ansa: "+notizia);
		notifyAllObservers();
	}
	public void myAddObserver(Observer observer) {
		myObservers.add(observer);
	}
	public void notifyAllObservers() {
		for (Observer myObserverClass : myObservers) {
			myObserverClass.myUpdate();
		}
	}
}
