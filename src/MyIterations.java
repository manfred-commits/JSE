
/*Creare un ciclo For che utilizzi un suo contatore
 * per produrre una serie di numeri, compresi tra 1 e 20
 * Quindi stampare i succesivi valori del contatore*/

public class MyIterations {

	public static final String MY_SEPARATOR="---------------------------------------";
	
	public static void main(String[] args) {
		
		//WHILE cycle: iterates until the condition between the () is true
		int myCondition = 0;
		while(myCondition <= 5) {
			System.out.println("While: " + myCondition);
			myCondition++;
		}
		
		System.out.println(MY_SEPARATOR);
		
		//DO-WHILE
		int myCondition2=6;
		{
			System.out.println("Do-While: " + myCondition2);
		}while(myCondition2 <= 5);
		
		System.out.println(MY_SEPARATOR);
		
		for(int i=0; i<=5;i++) {
			System.out.println("For: " + i);
		}
		
		System.out.println(MY_SEPARATOR);
		
		
		
		for(int i=1;i<=20;i++) {
			if(i%2==0) {
				System.out.println("Il valore del contatore è pari: " + i);
			}else {
				System.out.println("Il valore del contatore è dispari: " + i);
			}
			
		}
		
		System.out.println(MY_SEPARATOR);
		
		
		String [] words= {"Hey","Ciao","come","va"};
		String fullword="";
		
		/* solution with for each
		 for(String word:words) {
			
			fullword+=word+" ";
		}*/
		
		
		/*Standard for cycle*/
		for(int i=0;i<words.length;i++) {
			if(words[i].equals("Ciao")) {
				fullword+=words[i].toLowerCase()+", ";
			}else if(words[i].equals("va")){
				fullword+=words[i].toLowerCase();
			}else {
			
				fullword+=words[i]+" ";
			}
			
		}
		
		fullword+="?";
		System.out.println(fullword);
		
		System.out.println(MY_SEPARATOR);
		
		
	}

}
