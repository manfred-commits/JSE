
public class MyConditional {
	
	public static final String MY_SEPARATOR="---------------------------------------";

	public static void main(String[] args) {
		
		boolean myCondition=true;
		
		/*Se(si verifica questa condizione){
		 * esegui questo codiece...
		 * }
		 * se myCondition è uguale a true
		 */
		
		/*if(myCondition) {
			System.out.println("If: myCondition verificata");
		}*/
		
		/*Sintassi più prolissa*/
		if(myCondition==true) {
			System.out.println("If: myCondition verificata è uguale a " +myCondition);
		}
		
		int myNum = 18;
		/*if(myNum >= 18) {
			System.out.println("Maggiorenne");
		}*/
		
		
		//costrutto if/else 
		if(myNum<18) {
			System.out.println("Minorenne");
			
		}else {
			System.out.println("Maggiorenne");
		}
		
		
		//costrutto if/else if/else 
		
		/*
		 * 1. Verifica se è mminorenne
		 * 2. Se lo è allora verifica se ha più di 6anni
		 * Se lo è allora stampa studente 
		 * altrimenti se non ha più di 6 anni stampa asilo
		 * */
		
		if(myNum<=18) {
			if(myNum<6) {
				System.out.println("Studente");
			}else {
				System.out.println("Va all'asilo");
			}
			
			
		}else if(myNum>18 && myNum<65){
			System.out.println("Impiegato");
		}else {
			System.out.println("Non lavora");
		}

		//SWITCH
		
		String myString="C";
		
		switch(myString) {
			case "A":
				System.out.println("Switch: case A");
			break;
			case "B":
				System.out.println("Switch: case B");
			break;
			case "C":
				System.out.println("Switch: case C");
			break;
			case "D":
				System.out.println("Switch: case D");
			break;
			default:
				System.out.println("Switch: case non trovato");
		}
		
		System.out.println(MY_SEPARATOR);
		/*Vogliamo verificare se la posizione raggiunta in una ipotetica competizione
		 * sportivo da diritto a una medaglia o meno, 
		 * se sì stampare a quale. Altrimenti stampare "Solo gloria" */
		
		
		int myPosition=4;
		
		if(myPosition==1 || myPosition==2 ||myPosition==3) {
			System.out.println("Hai diritto ad una medagglia da: "+myPosition+"° classificato");
		}else {
			System.out.println("Solo gloria");
		}
		
		System.out.println(MY_SEPARATOR);
		
		switch(myPosition) {
		case 1:
			System.out.println("Hai diritto ad una medagglia da: "+myPosition+"° classificato");
			break;
		case 2:
			System.out.println("Hai diritto ad una medagglia da: "+myPosition+"° classificato");
			break;
		case 3:
			System.out.println("Hai diritto ad una medagglia da: "+myPosition+"° classificato");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("Non hai vinto una medaglia");
		default:
			System.out.println("Valore inserito non valido");
		}
		System.out.println(MY_SEPARATOR);
	}

}
