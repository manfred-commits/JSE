import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyEXE_String1 {
	final public static String SEPARATOR="____________________________________________________________________________";
	public static void main(String[] args) {
		
		System.out.println(SEPARATOR);
		String phrase=new String("Ciao a tutti");
		System.out.println("La mia frase è: "+phrase);
		System.out.println("Frase al contrario: "+myReverseWords(phrase));
		System.out.println("Frase con prima lettera (per parola) perupperCase: "+myFirstUpper(myReverseWords(phrase)));
		System.out.println(SEPARATOR);
		
		String phraseWithLettersAndNumbers="aba7s 9sfd8s 6a9d sf9";
		System.out.println("Frase con lettere e numeri: "+phraseWithLettersAndNumbers);
		List <String> myList=splitString(phraseWithLettersAndNumbers);
		ListIterator<String> myIterator =myList.listIterator();
		
		while(myIterator.hasNext()) {
			/*prende il prossimo elemento nuovo (mettondo Object come tipo di
			 * myValue per polimorfismo si può dare una variabile di tipo Stringa*/
			String myValue=myIterator.next();
			if(Character.isAlphabetic(myValue.charAt(0))) {
				System.out.print("Lettere della frase {" +myValue+"} ");
			}else {
				System.out.print("Numeri della frase: {" +myValue+"} ");
			}
		}
		
	}
	/*metodo per invertire la posizione di parole in una frase*/
	public static String myReverseWords(String phrase) {
		
		String arrayPhrase[] = phrase.split(" ");
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=arrayPhrase.length; i>0;i--) {
			stringBuilder.append(arrayPhrase[i-1]+" ");
		}		
		
		return stringBuilder.toString().toLowerCase();
	}
	/*metodo per far diventare la prima lettere di ogni parola in una frase toUpperCase()*/
	public static String myFirstUpper(String phrase) {
		String arrayPhrase[] = phrase.split(" ");
		StringBuilder stringBuilder=new StringBuilder();
		char firstLetter;
		for(int i=0; i<arrayPhrase.length;i++) {
			String upper=String.valueOf(arrayPhrase[i].charAt(0)).toUpperCase();
			firstLetter=upper.charAt(0);
			String modifiedWord=firstLetter+ arrayPhrase[i].substring(1, arrayPhrase[i].length());
			stringBuilder.append(modifiedWord+" ");
			
		}
		
		return stringBuilder.toString();
	}
	
	public static List<String> splitString(String phrase) {
		List <String> division = new ArrayList<>();
		StringBuilder stringBuilderAlphabet=new StringBuilder();
		StringBuilder stringBuilderNumber=new StringBuilder();
		
		/*String whiteSpaceRemoval=phrase.replace(" ", "");
		char [] myConvertedPhraseCharacters= whiteSpaceRemoval.toCharArray();*/
		char [] myConvertedPhraseCharacters= phrase.toCharArray();
		for(int i=0;i<myConvertedPhraseCharacters.length;i++) {
			Character character=myConvertedPhraseCharacters[i];
			if(Character.isAlphabetic(character)) {
				/*if the character is alphabetic*/
				stringBuilderAlphabet.append(character);
			}else if(Character.isDigit(character)) {
				/*if the character is numeric*/
				stringBuilderNumber.append(character);
			}else {
				/*if the character is not alphabetic nor numeric, 
				 * it must be a whitespace, or a character not allowed
				 * in the ex*/
				continue;
			}
		}
		division.add(stringBuilderNumber.toString());
		division.add(stringBuilderAlphabet.toString());
		return division;
	}
}
