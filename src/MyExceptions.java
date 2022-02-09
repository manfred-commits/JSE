/** ECCEZIONI ED ERRORI
 * Tipi di errori
 * Distinguiamo tra i seguenti tipi di errori:
 * 1. Errori di sintassi, dovuti al fatto che la sintassi Java non viene rispettata:
 * int a = 5 // manca il punto e virgola
 * 2. Errori semantici, dovuti ad un uso improprio delle istruzioni del programma:
 * int i;
 * i++; // La variabile i non è stata inizializzata
 * 3. Errori logici, dovuti al mancato rispetto della specifica. 
 * Il programma viene compilato ed eseguito senza errori, ma non genera il risultato richiesto:
 * public static int sum(int a, int b) {
 * return a - b ;
 * } // Il metodo restituisce il valore errato rispetto alla specifica richiesta (somma)
 * 
 * Dal punto di vista del rilevamento degli errori, distinguiamo:
 * 1. Errori in fase di compilazione: errori di sintassi e errori semantici statici indicati dal compilatore
 * 2. Errori di runtime: errori semantici dinamici ed errori logici che non possono essere rilevati dal compilatore(debug)
 * e quindi vengono rilevati solo quando il programma viene eseguito:
 * FileReader f = new FileReader("pippo.txt"); // L'errore si verifica se il file pippo.txt non esiste
 * gli errori che si verificano in fase di esecuzione sono rappresentati per mezzo di Eccezioni.
 * 
 * Java fornisce un meccanismo generale per gestire le anomalie di esecuzione. 
 * Una classe "Throwable" con due sottoclassi:
 * - Error: raggruppa le anomalie irrimediabili che tipicamente devono risolversi con la terminazione immediata del programma
 * Si vertificano in fase di runtime e solitamente l'applicazione non può rilevare questi tipi di problemi. 
 * Alcuni esempi di errore: OutOfMemoryError, VirtualMachineError, AssertionError.
 * - Exception: le anomalie che possono essere gestite e, almeno in linea di principio, rimediate
 * Si verificano principalmente nel codice scritto dagli sviluppatori. Sono divise in due categorie: 
 * -- checked: si verificano a compile time
 * -- unchecked: si verificano a runtime
 * Il meccanismo della gestione delle eccezioni ruota intorno alle keyword try, catch, finally 
 * Consentono di specificare delle istruzioni che potrebbero generare un'eccezione e, nel caso, 
 * intercettarla in un apposito blocco di codice dove provare a gestirla. 
 * Inoltre, un eventuale blocco finally può contenere istruzioni che saranno sempre eseguite a prescindere
 * dal fatto che il blocco try abbia o meno generato un'eccezione.
 */
/* Gerarchia delle eccezioni:
 * Throwable -> Exception -> RuntimeException -> Eccezione specifica -> Eccezione personalizzata * 
 */

import java.io.*;

public class MyExceptions {
	
	public static void main(String[] args) {
		/** Tipi comuni di eccezioni */
		
		/*
		NullPointerException: generata quando si prova ad accedere a un riferimento nullo */
		Object myObject = null;
		myMethodThrow(myObject);
		
		/*
		ArrayIndexOutOfBoundsException: generata quando si tenta di accedere a un
		elemento di un array con un indice minore di zero o maggiore della lunghezza
		dell'array 
		
		String[] myArray = { "Aldo", "Giovanni", "Giacomo" }; 
		for(int i = 0; i<myArray.length+1; i++) { 
			System.out.println("myArray: " + myArray[i]); 
		}
		*/

		/*
		NumberFormatException: generata da metodi che eseguono conversioni da  stringhe a numeri 
		Integer.parseInt("Aldo");
		*/
		
		/*
		FileNotFoundException: generata quando si tenta di aprire un file inesistente 
		File myFile = new File("\\Users\\Admin\\Desktop\\myFile.txt"); 
		FileReader myFR = new FileReader(myFile);
		*/

		/* ArithmeticException */
		// La divisione di interi per 0 genera un'eccezione
		int myNum = 33;
		int myDivisor = 0;
		int myQuotient;
		// 
		// System.out.println("Quoziente: " + myQuotient);
		/*
		// La gestione delle eccezioni avviene tramite il costrutto 
		try { 
			// Operazione che può causare l'eccezione			
			myQuotient = myNum/myDivisor;
		} 
		
		catch(Exception istanzaEccezione) { 
			// Gestione dell'eccezione 
			System.out.println("Ora te l'ho corretto io, la prossima volta NON USARE lo 0");
		} 
		*/
		/*
		// Prova a eseguire l'istruzione 
		try { 
			myQuotient = myNum/myDivisor;
		 	System.out.println("Quoziente: " + myQuotient); 
		 } 
		// Cattura l'eccezione specificata 
		catch (ArithmeticException myException) { 
			System.out.println("Eccezione catturata: " + myException.getMessage()); 
			/*
			// StackTrace: la pila di metodi utilizzati
			StackTraceElement mySTE[] = myException.getStackTrace(); 
			for (StackTraceElement myEl : mySTE){
				System.out.printf("StackTrace - Classe: %s%nMetodo: %s%nFile: %s%nNumero di linea: %d%n",
				myEl.getClassName(), 
				myEl.getMethodName(), 
				myEl.getFileName(),
				myEl.getLineNumber()); 
			}	
							
		}
		
		// Se occorre è possibile aggiungere un blocco finally, che verrà sempre eseguito (eccezione o meno) 
		// Utile per liberare le risorse eventualmente utilizzate (es. un file in lettura o scrittura)
		finally { 
			System.out.println("Esegue Finally");
		}
		*/
		
		/* 2. Gestione dell'eccezione personalizzata 
		// Prova a eseguire l'istruzione
		try {
			if (myDivisor == 0) {
				
				// 1. In alternativa, quando possibile, si può provare a correggere l'errore
				myDivisor = 1;
				myQuotient = myNum / myDivisor;
				System.out.println("Risultato con divisore corretto: " + myQuotient + "Occhio non usare lo 0");
				
				// 2. L'istruzione throw, può lanciare qualsiasi oggetto di tipo Throwable oppure un tipo da esso derivato
				// Qui lancia l'istanza dell'eccezione personalizzata
				throw new MyArithmeticException();				
			}
		}
		// Cattura l'eccezione
		catch (MyArithmeticException myException) {
			System.out.println(myException.getMessage());
		}		
		 */
	}
	
	private static void myMethod(Object myObject) {			
		System.out.println("Ok: " + myObject.toString());		
	}

	
	// I metodi possono lanciare esplicitamente il tipo di eccezione previsto
	private static void myMethodThrow(Object myObject) throws NullPointerException {
		try {
			System.out.println("Ok: " + myObject.toString());
		} catch(NullPointerException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}

/* Classe eccezione personalizzata */
class MyArithmeticException extends ArithmeticException {
	// Definisce il messaggio
	private static String myMsg = "MyArithmeticException: attenzione non si può dividere per 0!";
	// Personalizza i due metodi costruttori della classe ArithmeticException
	public MyArithmeticException() {
		super(myMsg);
	}
	public MyArithmeticException(String myMsg) {
		super(myMsg);
	}
}