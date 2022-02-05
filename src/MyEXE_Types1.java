
public class MyEXE_Types1 {
	
	final static float MY_SOUNDSPEED=331.2f;
	
	public static void main(String[] args) {
		
		int days=2;
		
		System.out.println("Distanza percorsa dal suono in "+days+" giorni: "+myCalculateSoundSpeed(daysToSeconds(days) ));

	}
	//method to calculate the distance traveled by sound in x number of days
	static double myCalculateSoundSpeed(double numberOfDays) {
		
		return MY_SOUNDSPEED*numberOfDays;
	}
	
	static int daysToSeconds(int days) {
		/*conversione 2 giorni in secondi
		1 giorno = 24h, 1 ora = 60 minuti, 1 minut0 = 60 secondi*/
		
		int daysInSeconds=days*24*60*60;
		
		return daysInSeconds;
	}

}
