import java.util.Scanner;

public class MyEXE_Scanner1 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);	
		System.out.println("Digita il capitale investito: ");
		int capitale=scanner.nextInt();
		System.out.println("Digita il tasso di interesse: ");
		double tassoInteresse=scanner.nextDouble();
		System.out.println("Risultato: "+investimentoPerTassoInteresse(capitale,tassoInteresse));
		scanner.close();
	}
	public static double investimentoPerTassoInteresse(double capitale, double interesse) {
		double risultato=(capitale*((int)interesse));		
		return risultato;
	}
}
