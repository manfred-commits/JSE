
public class Class_EXE_1 {
	public static final String MY_SEPARATOR = "---------------------------------------";
	public static void main(String[] args) {
		
		Dipendente d1= new Dipendente("Mario","Rossi",40,500.0);
		Dipendente d2= new Dipendente("Marzio","Gialli",42,552.0);
		Dipendente d3= new Dipendente("Marzia","Verdi",42,452.0);
		Dipendente [] dipendenti= {d1,d2,d3};
		
		metodoStampa(d1,d2,d3);
		
		System.out.println(MY_SEPARATOR);

		int [] percentuali= {10,20,30};
		
		for(int i=0; i<dipendenti.length;i++) {
			/* genera un numero random di percentuale, per l'aumento dello stipendio
			dipendenti[i].aumentaStipendio(getRandomNumber(50, 10));*/
			
			dipendenti[i].aumentaStipendio(percentuali[i]);
			metodoStampa(dipendenti[i]);
			
		}
		
		System.out.println(MY_SEPARATOR);
		
	
	}
	/*genera un numero random compreso tra max e min*/
	public static double getRandomNumber(int max, int min) {
		double randomNumber=(Math.random() * max) + min;
		return randomNumber;
	}
	/*soluzione di stampa con parametri variadici*/
	public static void metodoStampa(Dipendente... dipendenti) {
		
		for(Dipendente dipendente:dipendenti) {
			System.out.println("Nome: "+dipendente.getNome()+" - Cognome: " + dipendente.getCognome() + " - età: " + dipendente.getEta()+ " - stipendio: " + dipendente.getStipendio());
		}
	}
	/*metodo stampa, che prende un'istanza della classe dipendenti, e ne stampa tutti gli attributi*/
	public static void metodoStampa(Dipendente dipendente) {
		
		/*soluzione di stampa singola*/
		  System.out.println("Nome: "+dipendente.getNome()+" - Cognome: " + dipendente.getCognome() + " - età: " + dipendente.getEta()+ " - stipendio: " + dipendente.getStipendio());
	}
}

class Dipendente{
	private String nome;
	private String cognome;
	private int eta;
	private double stipendio;
	
	
	Dipendente(){
		
	}
	Dipendente(String nome, String cognome, int eta, double stipendio){
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.stipendio=stipendio;
	}
	
	/*class methods*/
	public void aumentaStipendio(double percentuale) {
		//calculate percentage
		double increment=(this.stipendio*(int)percentuale)/100;
		System.out.println("Percentuale di aumento di stipendio: "+(int)percentuale+"%");
		this.stipendio+=increment;
	}
	
	
	
	/*Getter*/
	
	public String getNome(){
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public int getEta(){
		return this.eta;
	}
	public double getStipendio(){
		return this.stipendio;
	}
	/*Setter*/
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	public void setEta(int eta){
		this.eta=eta;
	}
	public void setStipendio(double stipendio){
		this.stipendio=stipendio;
	}
	
}
