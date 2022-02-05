
public class MyOOP {

	public static void main(String[] args) {

		/*
		 * Gerarchia di Classe Super Classe Classe Animale ->Classe Mammifer-> Classe
		 * RazzaUmana-> Donna-> Madre->-> Figlio ->Nipote
		 * 
		 * Ereditarietà : permette a una classe di ereditare membri di un'altra sola
		 * clasee( ereditarietà sincolga) Polimorfismo: permette a una classe base di
		 * assumere le forme delle sue diverse classe derivate
		 */

		/*
		 * the SuperClass class, eredita il metodo toString da Object MySuperClass
		 * mySuperClass=new MySuperClass(); System.out.println(mySuperClass.toString());
		 */
		
		MySuperClass mySuperClass=new MySuperClass();
		MyParentClass myParentClass=new MyParentClass();
		
		mySuperClass.mySuperClassMethod(" stringa ", 2);
		myParentClass.mySuperClassMethod();
	}

}

class MySuperClass {
	public String myAttribute = "mySuperClassAttribute";

	MySuperClass() {

	}
	MySuperClass(String myAttribute) {
		this.myAttribute = myAttribute;

	}
	public void mySuperClassMethod(String myString,int myInt){
		System.out.println("Sono in mySuperClass"+ myString+myInt);
	}
}

/*
 * extends: eredita dalla clase superiore, per poter partire da una classe con
 * determinate caratteristiche ed estendere le caratteristiche della classe con
 * le proprie proprietà o metodi
 */
class MyParentClass extends MySuperClass {

	MyParentClass() {
	}
	MyParentClass(String myAttribute) {
		super(myAttribute);
	}
	public void mySuperClassMethod(){
		System.out.println("Sono in myParentClass");
	}
}
