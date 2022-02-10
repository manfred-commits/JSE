package com.manfredipiraino.observer.exe;

class G1 extends Giornalista{

	public G1(Ansa subject) {
		mySubject = subject;
		mySubject.myAddObserver(this);
	}
	/*methods*/
	@Override
	public void myUpdate() {
		System.out.println("Notizia: "+mySubject.getNotizia()+" 'Poco credibile'");	
	}
	
}
