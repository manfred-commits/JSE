package com.manfredipiraino.observer.exe;

public interface Subject {
	void myAddObserver(final Observer observer);
	void notifyAllObservers();
}
