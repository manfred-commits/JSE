/* DECORATOR 
Pattern strutturale
Consente di aggiungere nuove funzionalità a un oggetto esistente senza alterarne la struttura. 
Crea una classe decoratore che avvolge la classe originale e fornisce funzionalità aggiuntive 
mantenendo intatta la firma dei metodi di classe
*/

public class MyDecorator {
	public static void main(String[] args) {
		
		// Istanza di MyConcreteClassD non decorata/avvolta/wrapped
		MyInterfaceD myConcreteClass = new MyConcreteClassD();			
		// La classe concreta utilizza il metodo
		myConcreteClass.myInterfaceMethod();
		
		System.out.println(" ");
		
		// Istanza di MyConcreteClassD avvolta nella classe decoratrice
		// MyConcreteDecorator
		MyInterfaceD myConcreteClassDecorated = new MyConcreteDecorator(new MyConcreteClassD());
		// Utilizza lo stesso metodo ma decorato con il metodo aggiuntivo
		myConcreteClassDecorated.myInterfaceMethod();
	}
}


// Interfaccia o Classe Astratta
interface MyInterfaceD {
	void myInterfaceMethod();
}

// Classe concreta
class MyConcreteClassD implements MyInterfaceD {
	// Implementa il metodo ereditato
	public void myInterfaceMethod() {
		System.out.print("MyConcreteClassD");
	}
}


// Classe astratta Decorator che implementa l'Interfaccia
abstract class MyAbstractDecorator implements MyInterfaceD {
	// Istanza di tipo interfaccia
	protected MyInterfaceD myDecoratedInterface;

	// Costruttore
	protected MyAbstractDecorator(MyInterfaceD myDecoratedInterface) {
		this.myDecoratedInterface = myDecoratedInterface;
	}
	// Implementa il metodo ereditato
	public void myInterfaceMethod() {
		// Chiama il metodo dell'interfaccia
		myDecoratedInterface.myInterfaceMethod();
	}
}

// Classe concreta che implementa la classe Astratta Decorator
class MyConcreteDecorator extends MyAbstractDecorator {
	// Costruttore, chiama il costruttore super passando un'istanza del tipo
	// Interfaccia
	public MyConcreteDecorator(MyInterfaceD myDecoratedInterface) {
		super(myDecoratedInterface);
	}
	// Implementa il metodo dell'Interfaccia e aggiunge un metodo
	public void myInterfaceMethod() {
		myDecoratedInterface.myInterfaceMethod();
		myAddedMethod(myDecoratedInterface);
	}

	private void myAddedMethod(MyInterfaceD myDecoratedInterface) {
		System.out.println(" -> Added method");
	}
}
