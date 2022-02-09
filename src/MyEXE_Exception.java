
public class MyEXE_Exception {

	public static void main(String[] args) {
		
		String myStringArray="a";
		Integer myDivisor=5;
		Integer myConvertedValue=myConvertToInteger(myStringArray);
		System.out.println("Il valore convertito è pari a: "+myConvertedValue+" il divisore è: "+myDivisor);
		System.out.println("Il risultato è: "+myDivision(myConvertedValue,myDivisor));
	}

	public static int myConvertToInteger(String myString) {
		int myConvertedString = 0;
		try {
			myConvertedString = Integer.parseInt(myString);
			return myConvertedString;
		} catch (NumberFormatException e) {
			System.out.println("Impossibile convertire in un numero intero - " + e.getMessage());
			return myConvertedString;
		}
		
	}

	public static int myDivision(int myInteger, int myDivisor) {
		int myDivision=0;
		try {
			if(myInteger==0||myDivisor==0) {
				throw new MyCustomException();
			}else {
				myDivision = myInteger / myDivisor;
			}
			
		} catch (MyCustomException e) {
			System.out.println(e.getMessage());	
		}
		return myDivision;
	}
}

class MyCustomException extends ArithmeticException {

	private static String myMsg = "MyCustomException: attenzione non si può dividere per 0!";

	public MyCustomException() {
		super(myMsg);
	}

	public MyCustomException(String myMsg) {
		super(myMsg);
	}
}