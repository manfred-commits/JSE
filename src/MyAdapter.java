/* ADAPTER 
 * Pattern di struttura
 * Consente ad una classe di supportare un'interfaccia anche quando la classe non la implementa direttamente
*/

public class MyAdapter {
	public static void main(String[] args) {
		// Istanza della classe concreta 
		MyConcreteClassAdapter myConcreteClassAdapter = new MyConcreteClassAdapter();
		// Usa il metodo 
		myConcreteClassAdapter.myAbstractMethod("A2");
	}
}


// Interfacce differenti
interface MyAdapterInterface1 {
	public void myAbstractMethod(String myString);
}

interface MyAdapterInterface2 {
	public void myAbstractMethod1(String myString1);
	public void myAbstractMethod2(String myString2);
}



// Classi concrete che implementano l'interfaccia 2 in maniere differenti
class MyConcreteClassA1 implements MyAdapterInterface2 {
	public void myAbstractMethod1(String myString1) {
		System.out.println("MyConcreteClassA1.myAbstractMethod1() " + myString1);
	}
	public void myAbstractMethod2(String myString2) {
		// Non fa nulla
	}
}
class MyConcreteClassA2 implements MyAdapterInterface2 {
	public void myAbstractMethod1(String myString1) {
		// Non fa nulla
	}
	public void myAbstractMethod2(String myString2) {
		System.out.println("MyConcreteClassA2.myAbstractMethod2() " + myString2);
	}
}


// Adapter
class MyAdapterClass implements MyAdapterInterface1 {
	// Istanza dell'interfaccia 2
	MyAdapterInterface2 myAdapterInterface2;
	// Costruttore
	public MyAdapterClass(String myClass) {
		// Definisce quale classe concreta istanziare
		if (myClass.equalsIgnoreCase("A1")) {
			// Istanza della classe 1
			myAdapterInterface2 = new MyConcreteClassA1();
		} else if (myClass.equalsIgnoreCase("A2")) {
			// Istanza della classe 2
			myAdapterInterface2 = new MyConcreteClassA2();
		}
	}
	// Implementa il metodo dell'interfaccia 1 in modo che si adatti ai metodi dell'interfaccia 2
	public void myAbstractMethod(String myClass) {
		if (myClass.equalsIgnoreCase("A1")) {
			// Chiama il metodo della classe 1
			myAdapterInterface2.myAbstractMethod1("method1()");
		} else if (myClass.equalsIgnoreCase("A2")) {
			// Chiama il metodo della classe 2
			myAdapterInterface2.myAbstractMethod2("method2()");
		}
	}
}

// Classe concreta che implementa l'interfaccia 1 usando l'Adapter
class MyConcreteClassAdapter implements MyAdapterInterface1 {
	// Istanza dell'interfaccia 1
	MyAdapterClass myAdapterClass;
	// Implementa il metodo dell'interfaccia 1
	public void myAbstractMethod(String myClass) {
		if (myClass.equalsIgnoreCase("A")) {
			System.out.println("Classe A");
		} else if (myClass.equalsIgnoreCase("A1") || myClass.equalsIgnoreCase("A2")) {
			myAdapterClass = new MyAdapterClass(myClass);
			myAdapterClass.myAbstractMethod(myClass);
		} else {
			System.out.println("Classe non valida: " + myClass + "!!!");
		}
	}
}