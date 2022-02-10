package com.manfredipiraino.observer.exe;

class GR extends Giornalista{
	
	public GR(Ansa subject) {
		mySubject = subject;
		mySubject.myAddObserver(this);
	}
	/*methods*/
	@Override
	public void myUpdate() {
		System.out.println("News: "+mySubject.getNotizia()+" 'news poco credibile' \nCampioni del Mondo!'");		
	}
	
}