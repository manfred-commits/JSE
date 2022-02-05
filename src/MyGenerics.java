
public class MyGenerics {
	public static String MY_SEPARATOR="----------------------------";
	public static void main(String[] args) {
		
// I tipi dei Generics non possono essere primitivi (int, double, char, ecc.);
		Integer[] myArrayInteger = { 1, 2, 3 };
		Integer[] myArrayInteger2 = { 4, 5, 6 };
		String[] myArrayString = { "Aldo", "Giovanni", "Giacomo" };
		Double[] myArrayDouble = { 11.1, 22.2, 33.3 };

		System.out.println("-------------------------");
		// Chiama i metodi non generici myPrintArray()
		myPrintArrayInteger(myArrayInteger);
		myPrintArrayInteger(myArrayInteger2);
		myPrintArrayString(myArrayString);
		myPrintArrayDouble(myArrayDouble);
		System.out.println("-------------------------");

		
		// Chiama il metodo generico myPrintArrayGeneric() 
		myPrintArrayGeneric(myArrayInteger);
		myPrintArrayGeneric(myArrayString);
		myPrintArrayGeneric(myArrayDouble);
		System.out.println("-------------------------");

		/*
		Integer [] arr1= {1,2,3};
		String [] arr2= {"Asf","dfs","dsfa"};
		
		myPrintGeneric(arr1);
		System.out.println(MY_SEPARATOR);
		myPrintGeneric(arr2);
		metodi generics, non accettano variabili primitive
		*/
		System.out.println(MY_SEPARATOR);
		
		// Istanza di classe che usa un'interfaccia generica
		
		MyImplementingClass1 myImplementingClass1 = new MyImplementingClass1();
		System.out.println(myImplementingClass1.myMethod1(33));		
		System.out.println(myImplementingClass1.myMethod2("Ciao"));	
		
		MyImplementingClass2 myImplementingClass2 = new MyImplementingClass2();		
		System.out.println(myImplementingClass2.myMethod1(true));
		System.out.println(myImplementingClass2.myMethod2(12.50));

	}
	// Metodi non generici: svolgono un compito analogo mediante overloading
	public static void myPrintArrayInteger(Integer[] myArray) {
		for (int element : myArray) {
			System.out.print(element + " ");
		}
		System.out.println("");
	}

	public static void myPrintArrayDouble(Double[] myArray) {
		for (double element : myArray) {
			System.out.print(element + " ");
		}
		System.out.println("");
	}
	public static void myPrintArrayString(String[] myArray) {
		for (String element : myArray) {
			System.out.print(element + " ");
		}
		System.out.println("");
	}

	/*generic method*/
	public static <T> void myPrintArrayGeneric(T myArray[]){
		System.out.println((Object)myArray.getClass().getTypeName());
		for (T element: myArray) {
			System.out.print(element+" ");
		}
		System.out.println();
	}
}
/*Interfaccia generica*/
interface MyGenericInterface<T1,T2>{
	T1 myMethod1(T1 t);
	T2 myMethod2(T2 t);
}

class MyImplementingClass1 implements MyGenericInterface<Integer, String>{
	MyImplementingClass1(){
	}
	public Integer myMethod1(Integer myInteger) {
		return myInteger * 2;
	}
	public String myMethod2(String myString) {
		return myString + " a tutti";
	}
	public static <T> void myPrintArrayGeneric(T myArray[]){
		System.out.println((Object)myArray.getClass().getTypeName());
		for (T element: myArray) {
			System.out.print(element+" ");
		}
		System.out.println();
	}
}
class MyImplementingClass2 implements MyGenericInterface<Boolean, Double> {
	public Boolean myMethod1(Boolean myBoolean) {
		return myBoolean;
	}
	public Double myMethod2(Double myDouble) {
		return myDouble * 2;
	}
}
