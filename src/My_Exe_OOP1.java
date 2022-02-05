
public class My_Exe_OOP1 {
	public static final String MY_SEPARATOR="---------------------------------------";
	public static void main(String[] args) {
		
		Ingegnere ingegnere=new Ingegnere("Mario","Biondi");
		Architetto architetto=new Architetto(10,"Renzo","Piani");
		Programmatore programmatore=new Programmatore(5,"Bill","Gates");
		StagistaProgrammatore stagistaProgrammatore=new StagistaProgrammatore(22,24,"William","Gate");
		
		/*questo non si può instanziare poichè astratto
		Impiegato impiegato=new Impiegato();*/
		
		Impiegato impiegato;
		/*POLIMORFISMO: LA CLASSE CHE ESTENDE (IMPIEGATO) ASSUME IL TIPO DI DATO
		 * DELLE CLASSI CHE ESTENDE*/
		impiegato=ingegnere;
		mostraImpiegatoPolimorfico(impiegato);
		impiegato=architetto;
		mostraImpiegatoPolimorfico(impiegato);
		impiegato=programmatore;
		mostraImpiegatoPolimorfico(impiegato);
		impiegato=stagistaProgrammatore;
		mostraImpiegatoPolimorfico(impiegato);
		
		/*dichiarazione e inizializzazione POLIMORFICA*/
		Impiegato impiegato2=new Ingegnere("Marco","Biddeci");
		mostraImpiegatoPolimorfico(impiegato2);
		
		/*System.out.println(MY_SEPARATOR);
		System.out.println("Ingegnere:");
		System.out.println(ingegnere.getNome()+" "+ingegnere.getCognome()+" stipendio senza incremento di "+ingegnere.getPercentuale()+"% e: "+ingegnere.getFisso()+" euro");
		System.out.println(ingegnere.getNome()+" "+ingegnere.getCognome()+" stipendio con incremento: "+ingegnere.calcolaStipendio()+" euro");
		System.out.println(MY_SEPARATOR);
	
		
		System.out.println("Architetto:");
		System.out.println(architetto.getNome()+" "+architetto.getCognome()+" stipendio senza incremento per numeri progetti: "+architetto.getProgetti()+" è: "+architetto.getFisso()+" euro");
		System.out.println(architetto.getNome()+" "+architetto.getCognome()+" stipendio con incremento "+architetto.getPagaProgetti()+" per numero progetti "+architetto.getProgetti()+" è : " +architetto.calcolaStipendio()+" euro");
		System.out.println(MY_SEPARATOR);
		
		
		System.out.println("Programmatore:");
		System.out.println(programmatore.getNome()+" "+programmatore.getCognome()+" guadagna: "+programmatore.getPagaOraria()+" per "+programmatore.getOreLavorate()+" ore di lavoro");
		System.out.println("Quindi, lo stipendio totale di "+programmatore.getNome()+" "+programmatore.getCognome()+" è : "+programmatore.calcolaStipendio()+" euro");
		System.out.println(MY_SEPARATOR);
		
		
		System.out.println("Stagista Programmatore:");
		System.out.println(stagistaProgrammatore.getNome()+" "+stagistaProgrammatore.getCognome()+" di età "+stagistaProgrammatore.getEta()+", guadagna: "+stagistaProgrammatore.getPagaOraria()+" per "+stagistaProgrammatore.getOreLavorate()+" ore di lavoro");
		System.out.println("Quindi, lo stipendio totale di "+stagistaProgrammatore.getNome()+" "+stagistaProgrammatore.getCognome()+" (per un guadagno di "+stagistaProgrammatore.getPagaOraria()+" ad ora) è : "+stagistaProgrammatore.calcolaStipendio()+" euro");
		System.out.println(MY_SEPARATOR);
		
		System.out.println("Stagista Programmatore:");
		stagistaProgrammatore.setEta(19);
		System.out.println(stagistaProgrammatore.getNome()+" "+stagistaProgrammatore.getCognome()+" di età "+stagistaProgrammatore.getEta()+", guadagna: "+stagistaProgrammatore.getPagaOraria()+" per "+stagistaProgrammatore.getOreLavorate()+" ore di lavoro");
		System.out.println("Quindi, lo stipendio totale di "+stagistaProgrammatore.getNome()+" "+stagistaProgrammatore.getCognome()+" (per un guadagno di "+stagistaProgrammatore.getPagaOraria()+" ad ora) è : "+stagistaProgrammatore.calcolaStipendio()+" euro");
		System.out.println(MY_SEPARATOR);*/
		
		
	}
	private static void mostraImpiegatoPolimorfico(Impiegato impiegato) {
		/*
		%d – for signed decimal integer
		%f – for the floating point
		%c – for a character
		%s – a string
		%i – use for integer base 10
		%n – for new line = \n
		*/
		System.out.printf("L'impiegato ora è %s %s %d %n ------------------- %n", ((Object)impiegato).getClass().getName(), impiegato,impiegato.calcolaStipendio());
	}

}
abstract class Impiegato{
	/*Attributi*/
	private String nome;
	private String cognome;
	
	/*Costruttore*/
	Impiegato(){
		
	}
	Impiegato(String nome, String cognome){
		this.nome=nome;
		this.cognome=cognome;
	}
	
	/*Getter*/
	public String getNome() {
		return this.nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	/*Metodi*/
	public abstract int calcolaStipendio();
}
class Ingegnere extends Impiegato{
	private int fisso=3300;
	private double percentuale=10.0d;
	
	/**
	 * classe che crea un ingegnere
	 * 
	 * @param nome Parametro String
	 * @param cognome Parametro String
	 */
	Ingegnere(String nome, String cognome){
		super(nome,cognome);
	}
	
	/*Getter*/
	public int getFisso() {
		return this.fisso;
	}
	public double getPercentuale() {
		return this.percentuale;
	}
	/*Setter*/
	public void setFisso(int fisso) {
		this.fisso=fisso;
	}
	public void setPercentuale(int percentuale) {
		this.percentuale=percentuale;
	}
	/*Metodi*/
	@Override
	public int calcolaStipendio() {
		double incremento=(this.fisso*(int)this.percentuale)/100;
		this.fisso+=incremento;
		return this.fisso;
	}
}
class Architetto extends Impiegato{
	private int fisso=3000;
	private int progetti;
	/*in base al numero di progetti guadagna un tot*/
	private int pagaProgetto;
	
	
	Architetto( int progetti,String nome, String cognome){
		super(nome,cognome);
		this.progetti=progetti;
		this.pagaProgetto=100;
	}
	/*Getter*/
	public int getFisso() {
		return this.fisso;
	}
	public int getProgetti() {
		return this.progetti;
	}
	public int getPagaProgetti() {
		return this.pagaProgetto;
	}
	/*Setter*/
	public void setFisso(int fisso) {
		this.fisso=fisso;
	}
	public void setProgetti(int progetti) {
		this.progetti=progetti;
	}
	/*Metodi*/
	@Override
	public int calcolaStipendio() {
		int totalePagaPerProgetto=progetti*pagaProgetto;
		return fisso+totalePagaPerProgetto;
	}
	
}
class Programmatore extends Impiegato{
	public int pagaOraria=12;
	private int oreLavorate;
	Programmatore(){
		
	}
	Programmatore( int oreLavorate,String nome, String cognome){
		super(nome,cognome);
		this.oreLavorate=oreLavorate;
	}
	
	/*Getter*/
	public int getPagaOraria() {
		return this.pagaOraria;
	}
	public int getOreLavorate() {
		return this.oreLavorate;
	}
	/*Setter*/
	public void setPagaOraria(int pagaOraria) {
		this.pagaOraria=pagaOraria;
	}
	public void setOreLavorate(int oreLavorate) {
		this.oreLavorate=oreLavorate;
	}
	/*Metodi*/
	@Override
	public int calcolaStipendio() {
		int totale=pagaOraria*oreLavorate;
		return totale;
	}
}
class StagistaProgrammatore extends Programmatore{
	private int eta;
	
	StagistaProgrammatore(int eta,int oreLavorate,String nome, String cognome){
		super(oreLavorate, nome,cognome);
		this.eta=eta;
		if(eta<20) {
			this.pagaOraria=5;
		}else {
			this.pagaOraria=6;
		}
	}
	/*la pagaOraria dipende dall'età
	 * (se ha meno di 20 anni la pagaOraria = 5 altrimenti = 6)*/
	/*Getter*/
	public int getEta() {
		return this.eta;
	}
	/*setter*/
	public void setEta(int eta) {
		this.eta=eta;
		if(eta<20) {
			this.pagaOraria=5;
		}else {
			this.pagaOraria=6;
		}
	}
}