
public class MyMethods {
	
	public static final String MY_SEPARATOR="---------------------------------------";
	
	public static void main(String[] args) {


		//richiamo metodo mySum
		mySum(23,58);
		
		System.out.println("La mia somma è: "+ mySum(50,20));
		byte myByte=125;
		
		/*autopromozione di variabile id tipo byte nel tipo int
		 * richiesto dalla firma del metodo (questo è possibile 
		 * poichè lo short e più piccolo del int quindi viene
		 * autopromosso*/
		mySum(123,myByte);
		
		System.out.println(MY_SEPARATOR);
		
		int num1=20;
		int num2=30;
		
		//division
		System.out.println("La divisione tra "+num1+" e "+num2+" è: "+ myDivision(num1,num2));
		
		//multiplication
		System.out.println("La moltiplicazione tra "+num1+" e "+num2+" è: "+ myMultiplication(num1,num2));
		
		//subtraction
		System.out.println("La sottrazione tra "+num1+" e "+num2+" è: "+ mySubtraction(num1,num2));
		
		//sum
		System.out.println("La somma tra "+num1+" e "+num2+" è: "+ mySum(num1,num2));
		
		
		System.out.println(MY_SEPARATOR);
		
		
		myMethodOverloaded(1);
		myMethodOverloaded(1,"ciao");
		myMethodOverloaded(1,"ciao",true);
		myMethodOverloaded(true,1,"ciao");
		
		System.out.println(MY_SEPARATOR);
		
	}
	
	/*metodo*/
	/*tipo di dato ritornato dal metodo : void
	  (poichè non return nessun valore*/
	//nome metodo : mySum
	//nome argomento : int myNum1,int myNum2
	//istruzioni: contenute all'interno delle parentesi graffe
	//firma del metodo "void mySum(int myNum1, int myNum2) "
	 
	static void mySumVoid(int myNum1, int myNum2) {
		
		/*bisogna racchiudere la somma all'interno di parentesi tonde così da rendere
		comprensibile all'operatore l'operazione*/
		
		System.out.println("La somma di: "+ myNum1 + " + " + myNum2+" è "+(myNum1+myNum2));

	}
	//combinazione di parametri di ingresso di un metodo + il tipo di ritorno
	
	
	/*tipo di dato ritornato dal metodo : int*/
	//nome metodo : mySum
	//nome argomento : int myNum1,int myNum2
	//return : myNum1+myNum2
	static int mySum(int myNum1, int myNum2) {
		
		/*bisogna racchiudere la somma all'interno di parentesi tonde così da rendere
		comprensibile all'operatore l'operazione*/
		
		//System.out.println("La somma di: "+ myNum1 + " + " + myNum2+" è "+(myNum1+myNum2));
		return myNum1+myNum2;
	}
	
	
	//division
	static double myDivision(double myNum1, double myNum2) {
		return myNum1/myNum2;
	}
	
	//multiplication
	static int myMultiplication(int myNum1, int myNum2) {
		return myNum1*myNum2;
	}
	//multiplication
	static int mySubtraction(int myNum1, int myNum2) {
		return myNum1-myNum2;
	}
	
	
	//argomenti vanno ad essere una lista non definita di valore dello stesso tipo
	static void myVariableArgs(int... myInt) {
		
		/*bisogna racchiudere la somma all'interno di parentesi tonde così da rendere
		comprensibile all'operatore l'operazione*/
		
		System.out.println();
	}
	
	private static void myMethodOverloaded(int myPar1) {
		System.out.println("myMothodOverloade: "+myPar1);
	}
	
	private static void myMethodOverloaded(int myPar1, String myPar2) {
		System.out.println("myMothodOverloade: "+myPar1+", "+myPar2);
	}
	private static void myMethodOverloaded(int myPar1, String myPar2,boolean myPar3) {
		System.out.println("myMothodOverloade: "+myPar1+", "+myPar2+", "+myPar3);
	}
	private static void myMethodOverloaded(boolean myPar3,int myPar1, String myPar2) {
		System.out.println("myMothodOverloade: "+myPar3+", "+myPar2+", "+myPar1);
	}

}
