
public class MyEXE_Exception {

	public static void main(String[] args) {
		
		String myStringArray="3";
		String [] stringArray={"a","2","3"};
		Integer myDivisor=3;
		int [] myConvertedValue=myConvertToInteger(stringArray);
		int counter=0;
		for(int singleConversion:myConvertedValue) {
			System.out.println("Il valore convertito per '"+stringArray[counter]+"' è pari a: "+singleConversion+" il dividendo è: "+myDivisor);
			System.out.println("Divisione: "+myDivision(singleConversion,myDivisor));
			counter++;
		}
		
		
	}

	public static int[] myConvertToInteger(String [] myString) {
		int[] myConvertedString =new int[myString.length];
		int counter=0;
		for(String singleConversion:myString) {
			try {
				myConvertedString[counter] = Integer.parseInt(singleConversion);
			} catch (NumberFormatException e) {
				System.out.println("Impossibile convertire in un numero intero - " + e.getMessage());
				myConvertedString[counter] =0;
			}
			counter++;
		}
		return myConvertedString;		
		
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