
public class MyClass2 {

	//static, altrimenti non si può accedere a questa proprietà all'interno della classe
	public static String myString ="caio, Tizio";
	
	public static void main(String[] args) {
		
		MyClassDec2 myClassDec2=new MyClassDec2();
		
		//System.out.println("myClassBoolean: " + MyClassDec2.myClassBoolean);
		System.out.println("myClassBoolean: " + MyClassDec2.myStaticProperty);
		
		/*non puoi dichiarare direttamente nella classe, un metodo, nella classe
		in cui l'hai dichiarato*/
		//stampa();
		
		stampa();
		
		System.out.println(myString);
	}
	public static void stampa() {
		System.out.println("Hello, I'm printing here!");
	}

}
class MyClassDec2{
	/*CLASS ATTRIBUTES*/
	private String myClassString;
	protected Integer myClassInteger;
	public Boolean myClassBoolean;
	
	public static String myStaticProperty="Static";
	
	public static char MY_CLASS_STATIC_CHAR;
	
	/*COSTRUTTORE*/
	MyClassDec2(){
		myClassBoolean=true;
	}
}
