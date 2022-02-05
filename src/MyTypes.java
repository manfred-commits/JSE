
public class MyTypes {

	
	public static final String MY_SEPARATOR="---------------------------------------";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*char*/
		char myChar1='X';
		
		/*interi*/
		byte myByte=127;
		
		byte eta=126;
		
		short myShort=32767;
		
		/*utiliziamo _ perchè sintassi anglosassone
		(per comprensibilità al posto del punto)*/
		int myInt =2_147_483_647;
		
		//bisogna consumere il numero con la letter L maiuscola
		long myLong=9_223_372_036854_775_807L;
		
		
		
		System.out.println("myByte. "+myByte+"/Valore minimo: "+Byte.MIN_VALUE+" / Valore massimo: "+Byte.MAX_VALUE);
		System.out.println("myShort. "+myShort+"/Valore minimo: "+Short.MIN_VALUE+" / Valore massimo: "+Short.MAX_VALUE);
		System.out.println("myInt. "+myInt+"/Valore minimo: "+Integer.MIN_VALUE+" / Valore massimo: "+Integer.MAX_VALUE);
		System.out.println("myLong. "+myLong+"/Valore minimo: "+Long.MIN_VALUE+" / Valore massimo: "+Long.MAX_VALUE);
	
	
		float myFloat=22.2222222f;
		double myDobule=2.2222222222222222d;
		System.out.println("myFloat: "+myFloat);
		System.out.println("myDobule: "+myDobule);
		
		System.out.println(MY_SEPARATOR);
		//casting
		
		byte myByte2;
		int myInt2=156;
		double myDouble2= 129.456;
		
		myByte2=(byte) myInt2;
		/*i valori superior a 127 vengono
		interpretati con segno negativo fino a 256*/
		System.out.println("Conversione myByte2: "+myByte2);
		
		
		myInt2=(int) myDouble2;
		System.out.println("Casting myInt2: "+myInt2);
		
		myByte2= (byte) myDouble2;
		System.out.println("Casting myByte2: "+myByte2);
		
		
		//promozione di tipo automatica
		byte myByte3=40;
		byte myByte4=100;
		int myInt3= myByte3* myByte4;
		System.out.println("Promozione myByte3 * myByte4: "+myInt3 +" Promosso al tipo: "+((Object)myInt3).getClass().getName());
		
		System.out.println(MY_SEPARATOR);
		/*
		 tipo /classe/ oggetto più complesso
		 class Persona{
		 
			 byte eta;
			 short altezza;
			 boolean vivo;
			 .....
			 float stipendio;
			 float rendita;
			 
			 float acquisti;
			 float acquisti;
			 float acquisti;
			 
			 float guadagna(){
			 	return stipendio +rendita;
			 }
			 float spende(){
			 	return acquisti+acquisti+speseCondiminiali;
			 }
		 }
		 */
		
		
		
		/*wrapper classes classi che promuovano ad un livello superiore
		i tipi primitivi/semplice in tipi complessi (con dei metodi)*/
		
		Integer myIntegerA=10;
		
		
		Double myDoubleA=5.5;
		System.out.println("Autoboxing variabile: "+ myIntegerA+" - "+myDoubleA);	
	
		
		myAutoboxing(22);
		myUnboxing(myIntegerA);
		System.out.println(MY_SEPARATOR);
		int myValue=10;
		System.out.println("myValue = " +myValue);
		myValue++;
		//myValue=myValue + 1;
		
		//myValue--;
		//myValue=myValue - 1;
		
		System.out.println("myValue = " +myValue);
		
		myValue+=22;		
		//myValue=myValue+22;
		System.out.println("myValue = " +myValue);
		
		System.out.println("myValue = " +myValue % 2);
		
		
		
		int myValue2=22;
		/* due numeri di cui si fa l'uguaglianza devono essere 
		racchiusi tra parentesi, poichè il compilatore altrimenti (senza 
		parentesi) non riesce a distinguere gli operatori su cui
		 veriificare l'uguaglianza*/
		
		//operatori
		System.out.println("myValue è uguale a myValue2 " +(myValue==myValue2));
		
		myValue2=33;
		System.out.println("myValue è uguale a myValue2 " +(myValue==myValue2));
		myValue2=22;
		System.out.println("myValue è maggiore a myValue2 " +(myValue>myValue2));
		
		System.out.println("myValue è myValue2 sono entrambi maggiore di 30  " +(myValue>30&& myValue2>30));
	
		System.out.println("myValue o myValue2 sono maggiori di 30  " +(myValue>30||myValue2>30));
	
	
		/*int myValue = 10;
		System.out.println("myValue = " + myValue);
		myValue ++;
		System.out.println("myValue = " + myValue);
		myValue += 8;
		// myValue = myValue + 22;
		System.out.println("myValue = " + myValue);		
		System.out.println("myValue % " + myValue % 2);
		int myValue2 = 17;
		System.out.println("myValue è uguale a myValue2? " + (myValue > myValue2));
		
		int etaMaggiore = 18;
		System.out.println("myValue e myValue2, sono entrambi maggiorenni? " + (myValue > etaMaggiore && myValue2 > etaMaggiore));
		System.out.println("Almeno uno tra myValue e myValue2 è maggiorenni? " + (myValue > etaMaggiore || myValue2 > etaMaggiore));
		
		System.out.println("Non è vero che myValue è maggiorenne" + !(myValue > etaMaggiore));*/

	}
	
	
	static void myAutoboxing(Integer myInteger) {
		System.out.println("Autoboxing parametro: "+myInteger);
	}
	static void myUnboxing(int myInt) {
		System.out.println("Unboxing parametro: "+myInt);
	}

}
