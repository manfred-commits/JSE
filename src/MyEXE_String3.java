import java.util.Scanner;
import java.util.StringTokenizer;

public class MyEXE_String3 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String []parole= {"Mario","a","b"};
		System.out.println("Parole proibite");
		for(String parola:parole) {
			System.out.print(parola+" ");
		}
		System.out.println();
		System.out.println("Inserisci le tue parole: ");
		
		boolean trovato=false;
		String myString=scanner.nextLine();
		scanner.close();
		
		StringTokenizer stringToToken=new StringTokenizer(myString);
		while(stringToToken.hasMoreTokens()){
			String token=stringToToken.nextToken();
			for(String parola:parole) {
				if(parola.equalsIgnoreCase(token)) {				
					trovato=true;
				}
			}
		}
		if(trovato) {
			System.out.println("Frase: '"+myString+"' non ok");
		}else {
			System.out.println("Frase: '"+myString+"' ok");
		}
	}

}
