
public class MySingleton {

	public static void main(String[] args) {
		
		/*Singleton*/
		MySingletonClass mySingleton1 = MySingletonClass.getInstance();
		mySingleton1.myMethod();
		MySingletonClass mySingleton2 = MySingletonClass.getInstance();
		mySingleton2.myMethod();
	}

}
class MySingletonClass{
	static MySingletonClass myInstance;
	private MySingletonClass() {}
	
	static MySingletonClass getInstance() {
		if(myInstance==null) {
			System.out.println(" - Nuova istanza Singleton");
			myInstance= new MySingletonClass();
		}else {
			System.out.println(" - Esiste già un'istanza Singleton");
		}
		return myInstance;
	}
	void myMethod() {
		System.out.println("Posizione Singleton" +myInstance);
	}
	
}
