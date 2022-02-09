import java.text.DecimalFormat;
import java.util.Scanner;

/* Scanner
Rappresenta un scanner di testo capace di riconoscere i tipi primitivi e le stringhe.
La stringa viene divisa in token utilizzando un separatore che, solitamente, è lo spazio.
I metodi principali:
- hasNext(): verifica la presenza di ulteriori token e ritorna un booleano
- hasNextInt(), hasNextDouble(), ecc.: verificano la presenza di ulteriori token del tipo indicato
- hasNextLine(): verifica la presenza di stringhe

- nextLine(): legge una riga intera, fino alla prossima riga, e ritorna la riga come String
- nextInt(), nextDouble(), nextBoolean, ecc. convertono il token nel tipo indicato
 */
public class MyScanner {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
				
		/*
		System.out.print("Digita una stringa: ");
		// nextLine(): Ottiene l'input della riga
		String myString = myScanner.nextLine();
		System.out.println("Hai digitato: " + myString);
					
		System.out.print("Digita un intero: ");
		int myInt = myScanner.nextInt();
		System.out.println("Int digitato: " + myInt * 3);
				
		System.out.print("Digita un double: ");
		double myDouble = myScanner.nextDouble();
		DecimalFormat myDf = new DecimalFormat("0.0000");
		System.out.println("Double digitato: " + myDf.format(myDouble/3));
		*/
				
		System.out.print("Digita una stringa con token: ");
		// hasNext(): verifica l'esistenza di altri token nella riga	
		int myTokenCounter = 1;
		while(myScanner.hasNext()) {
			// Imposta un delimitatore custom 
			// myScanner.useDelimiter("#");
			String myStringToken = myScanner.next();
			System.out.println("Token N. " + myTokenCounter + ": "  + myStringToken);
			myTokenCounter ++;
		}		
		
		/*
		System.out.print("Digita qualche riga con a capo: ");
		int myLineCounter = 1;
		while(myScanner.hasNextLine()) {
			String myStringLine = myScanner.nextLine();
			System.out.println("Linea N. " + myLineCounter + ": "  + myStringLine);
			myLineCounter ++;
		}
		*/
		myScanner.close();
	}

}
