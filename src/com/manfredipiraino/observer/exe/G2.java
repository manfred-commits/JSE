package com.manfredipiraino.observer.exe;

class G2 extends Giornalista{
	
	public G2(Ansa subject) {
		mySubject = subject;
		mySubject.myAddObserver(this);
	}
	/*methods*/
	@Override
	public void myUpdate() {
		System.out.println("News: "+mySubject.getNotizia()+" 'Sure'");	
	}
	
}
