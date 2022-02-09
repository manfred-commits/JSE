
public class MyString {

	public static void main(String[] args) {
		
		/** Inizializzazione con string literal */
		String myLiteralString = "Stringa letterale ";
		System.out.println(myLiteralString);

		/* Poichè String è un oggetto, le variabili di tipo String possono essere
		 * inizializzate anche utilizzando la keyword new e relativo costruttore
		 */
		String myObjString = new String("Stringa ogeto ");
		System.out.println(myObjString);
		
		/* Si può pensare a una stringa come a un array di caratteri e considerare
		 * i singoli caratteri come elementi di array sfruttando il metodo  charAt() */
		char myChars[] = { 'A', 'L', 'D', 'O' };
		String myCharsString = new String(myChars);
		System.out.println("Chars string: " + myCharsString);
		System.out.println("charAt(): " + myCharsString.charAt(0));
		System.out.println("--------------------------------");
		
		/* Alcuni metodi per la gestione e manipolazione delle stringhe */
		// length()
		System.out.println(myObjString.length());
		// concat()
		String myConcatString = myLiteralString.concat(myObjString);
		System.out.println("concat(): " + myConcatString);
		// subString()
		String mySubString = myObjString.substring(8, 14);
		System.out.println("substring(): " + mySubString);
		
		// startsWith()
		boolean myBooleanStart = myObjString.startsWith("Stringa o");
		System.out.println("startsWith(): " + myBooleanStart);
		// regionMatches(): confronta substring di due stringhe
		// Argomenti: ignoreCase, inizio substring, l'altra stringa, inizio substring altra, numero di caratteri
		boolean myBooleanRegionMatches = myObjString.regionMatches(false, 0, myLiteralString, 0, 8);
		System.out.println("regionMatches(): " + myBooleanRegionMatches);
		// contains()
		boolean myBooleanContains = myObjString.contains("Stringa");
		System.out.println("contains(): " + myBooleanContains);
			
		// split()
		String myFriendsString = "Aldo/Giovanni Mario/Giacomo";
		String[] myFriendsArray = myFriendsString.split("/");
		for(String myFriend : myFriendsArray) {
			System.out.println("split(): " + myFriend);
		}
		
		myObjString.replace("ogeto", "oggetto");
		System.out.println("replace()1: " + myObjString);
		System.out.println("--------------------------------");
		
		/* StringBuilder */
		StringBuilder myStringBuilder = new StringBuilder("String builder ");
		System.out.println("StringBuilder: " + myStringBuilder);
		//System.out.println("StringBuilder: " + getStringInfo(myStringBuilder));
		// append() aggiunge una sequenza di caratteri
		myStringBuilder.append("Sed ut perspiciatis");
		System.out.println("StringBuilder append(): " + myStringBuilder);
		// insert() aggiunge un'altra sequenza di caratteri
		myStringBuilder.insert(7, "accusamus et iusto odio dignissimos ducimus ");
		System.out.println("StringBuilder insert(): " + myStringBuilder);
		myStringBuilder.delete(0, 7);
		System.out.println("StringBuilder delete(): " + myStringBuilder);
		System.out.println("--------------------------------");

	}

}
