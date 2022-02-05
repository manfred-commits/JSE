
public class MyEXE_Types2 {
	
	final static double PI=Math.PI;
	
	public static void main(String[] args) {		
		
		//int raggio = 6;
		final int raggio = 8;
		
		//int diametro= raggio*2;
		final int diametro= 16;
		
		//double circonferenza=raggio *2*PI;
		final double circonferenza=32;
		
		//diameter from circumference divided by piGreco
		//System.out.println(circonferenza/PI);
		
		System.out.println("Area del cerchio conoscendo il valore del raggio: "+myCalculateAreaCerchioR(raggio));
		
		System.out.println("Area del cerchio conoscendo il valore del diametro: "+myCalculateAreaCerchioD(diametro));
		
		System.out.println("Area del cerchio conoscendo il valore della circonferenza: "+myCalculateAreaCerchioC(circonferenza));
	}
	static double myCalculateAreaCerchioR( double raggio) {
		
		return PI*(Math.pow(raggio, 2));
	}
	static double  myCalculateAreaCerchioD( double diametro) {
		return PI*((Math.pow(diametro, 2))/4);
	}
	static double  myCalculateAreaCerchioC( double circonferenza) {
		return (Math.pow(circonferenza, 2))/(PI*4);
	}
}
