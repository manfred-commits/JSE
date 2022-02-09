import java.util.Scanner;

public class MyScanner {

	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("inserisci una stringa: ");
		String myString= myScanner.nextLine();
		System.out.println("la stringa inserià è: "+myString);
		
		/*lo scanner va sempre chiuso, per evitare di occupare spazio in memoria*/
		myScanner.close();
	}

}
