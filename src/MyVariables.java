
//Commento su una sola linea
/*
 * Commento su più linee
 */

public class MyVariables {

	public static String myStaticVariable="Variabile di classe";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//diciarazione
		int myInt1;
		
		int myInt2,myInt3,myInt4;
	
		//inizializzazione
		int myNum0;
		myNum0=33;
		
		int myNum1=100;
		int myNum2=22;
		
		//Inizializazione dinamica
		
		//+ somma
		int mySum= myNum1+myNum2;
		//+ concatenazione
		System.out.println("my Sum: "+mySum);
		
		System.out.println("mySum *3: "+ mySum*3);
		
		System.out.println("-------------------------");
		
		
		
		if(mySum>121) {
			
			String myCheckSum = mySum+" maggiore di 121";
			System.out.println("myCheckSum: "+myCheckSum);
			System.out.println("myStaticVariable: "+myStaticVariable);
			
		}else {
			
			String myCheckSum=mySum+"minore o guale a 121";
			System.out.println("myCheckSum: "+myCheckSum);
		}
		
		//errore
		//System.out.println(myCheckSum);
		myStaticVariable+=" modificata";
		System.out.println("myStaticVariable: "+myStaticVariable);
		
		myMethod();
		System.out.println("-------------------------");
		
		final boolean MY_BOOLEAN= true;
		System.out.println("MY_BOOLEAN: "+MY_BOOLEAN);
		
		//errore poichè non si può variare il valore di una costante
		//MY_BOOLEAN=false;
		
	}
	
	//metodo
	public static void myMethod() {
		myStaticVariable+=" dal metodo";
		System.out.println("myStaticVariable: "+myStaticVariable);
	}

}
