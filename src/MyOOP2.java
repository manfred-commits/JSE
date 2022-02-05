
public class MyOOP2 {
	
	/*POLIMORFISMO (+/OVERLOADING OF METHODS/OVERRIDING)
	 * POLIMORFISMO DELLE CLASSI
	 * POLIMORFISMO LEGATO AI TIPI GENERICI
	 * */
	public static void main(String[] args) {
		
		

	}

}
/*CLASSE ASTRATTA
 * servono a dichiarare caratteristiche comuni a tutte le classi derivate
 * caratteristice:
 * non possono essere instanziate
 * servono a dichiarare dei metodo delle classi astratte*/
abstract class MyAbstractClass{
	/*attributi*/
	public String myAttribute="myAbstractClassAttribute";
	
	/*metodo astratto*/
	public abstract void myAbstractClassMethod();
	
	/*metodo non astratto*/
	public void myAbstractClassMethodConcrete() {
		System.out.println("myAbstractClassMethodConcrete()");
	}
}
class MyExtendedClass extends MyAbstractClass{

	@Override
	public void myAbstractClassMethod() {
		System.out.println("myAbstractClassMethod() implementato");
		myAttribute="";
	}
	
}


/*INTERFACCE*/

interface MyInterface {
	
	abstract void myInterfaceClassMethod();
	
	default void myInterfaceClassMethodDefault() {
		System.out.println("myInterfaceClassMethodDefault()");
	}
}