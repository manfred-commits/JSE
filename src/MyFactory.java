/* FACTORY METHOD
Pattern di creazione
Definisce un'intermediatore (rappresentato da un'interfaccia o da una classe astratta) 
che lascia alle sottoclassi decider quale oggetto istanziare
*/
public class MyFactory {
	public static void main(String[] args) {
		
		// Istanza Factory
		MyFactoryClass myFactory = new MyFactoryClass();
		// L'istanza Factory crea istanze di Classi in base al fattore discriminante usando il metodo di fattorizzazione
		MyInterfaceFactory myFactorizedClassA = myFactory.myCreateObject("Politica");
		myFactorizedClassA.myAbstractMethod();
		MyInterfaceFactory myFactorizedClassB = myFactory.myCreateObject("Sport");
		myFactorizedClassB.myAbstractMethod();
		MyInterfaceFactory myFactorizedClassC = myFactory.myCreateObject("Cronaca");
		myFactorizedClassC.myAbstractMethod();
	}
}

//Interfaccia o Classe astratta
interface MyInterfaceFactory {
	public void myAbstractMethod();
}

//Classi concrete 
class MyConcreteClass1 implements MyInterfaceFactory {
	// Implementa il metodo astratto
	public void myAbstractMethod() {
		System.out.println("Classe concreta MyClassF1: gestisce la notizia di Politica");
	}
}
class MyConcreteClass2 implements MyInterfaceFactory {
	// Implementa il metodo astratto
	public void myAbstractMethod() {
		System.out.println("Classe concreta MyClassF2: gestisce la notizia di Sport");
	}
}
class MyConcreteClass3 implements MyInterfaceFactory {
	// Implementa il metodo astratto
	public void myAbstractMethod() {
		System.out.println("Classe concreta MyClassF3: gestisce la notizia di Cronaca");
	}
}


// Classe Creator
class MyFactoryClass {	
	// Metodo factory: crea le istanze in base alla condizione (in questo caso l'argomento)
	public MyInterfaceFactory myCreateObject(String myCondition) {
		if (myCondition == null) {
			return null;
		}		
		if (myCondition.equals("Politica")) {
			return new MyConcreteClass1();
		} else if (myCondition.equals("Sport")) {
			return new MyConcreteClass2();
		} else if (myCondition.equals("Cronaca")) {
			return new MyConcreteClass3();
		}
		return null;
	}
}