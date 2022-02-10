import java.util.ArrayList;
import java.util.List;

/* Observer/Subject
Pattern di comportamento
Definisce una relazione tra un oggetto (Subject) e un insieme di oggetti interessati 
a essere notificati (tramite Observer) quando il primo cambia di stato 
*/

public class MyObserver {
	public static void main(String[] args) {
		// Istanza del Subject
		MySubject mySubject = new MySubject();
		
		// Classi concrete
		new MyConcreteClassO1(mySubject);
		new MyConcreteClassO2(mySubject);

		// Il subject cambia stato
		mySubject.setState(15);
		// Il subject cambia stato
		//mySubject.setState(10);
	}
}

// Subject
class MySubject {
	private int myState;
	// ... altre Proprietà rappresentati altri stati della classe
	
	// Lista di Osservatori
	private List<MyObserverClass> myObservers = new ArrayList<MyObserverClass>();
	
	// Getter
	public int getState() {
		return myState;
	}
	
	// Setter: modifica il proprio stato
	public void setState(int myState) {
		this.myState = myState;
		System.out.println("mySubject.setState() - Il mio nuovo stato è: " + myState);
		// Chiama il metodo che notifica il cambiamento di stato
		myNotifyAllObservers();
	}
	
	// Aggiunge Observer alla lista degli Observer
	public void myAddObserver(MyObserverClass observer) {
		myObservers.add(observer);
	}
	
	// Notifica il cambiamento di stato a tutti gli Observer in lista
	public void myNotifyAllObservers() {
		for (MyObserverClass myObserverClass : myObservers) {
			myObserverClass.myUpdate();
		}
	}
}

// Observer
abstract class MyObserverClass {
	// Istanza del Subject
	protected MySubject mySubject;
	// Metodo che risponde alle notifiche del Subject
	public abstract void myUpdate();
}

// Classi concrete
class MyConcreteClassO1 extends MyObserverClass {
	// Costruttore  con istanza del Subject
	public MyConcreteClassO1(MySubject subject) {
		this.mySubject = subject;
		// Aggiunge la classe alla lista degli Observer del Subject
		this.mySubject.myAddObserver(this);
	}
	// Implementa il metodo di update
	public void myUpdate() {
		System.out.println("MyConcreteClassO1.update() - Ricevuto il nuovo stato: " + mySubject.getState() + " Il mio ricavo è "  + mySubject.getState()/5 );
	}
}

class MyConcreteClassO2 extends MyObserverClass {
	// Costruttore  con istanza del Subject
	public MyConcreteClassO2(MySubject subject) {
		this.mySubject = subject;
		// Aggiunge la classe alla lista degli Observer del Subject
		this.mySubject.myAddObserver(this);
	}
	// Implementa il metodo di update
	public void myUpdate() {
		System.out.println("MyConcreteClassO2.update() - Ricevuto il nuovo stato: " + mySubject.getState() + " Il mio ricavo è "  + mySubject.getState()/2);
	}
}