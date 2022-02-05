/*
 * 0. La Class_Exe_2 
- contiene il metodo main() in cui creare istanze di Tavolo e stamparne i dati per verifica.


1. Una classe Prenotazione contenente 
- il nome del cliente
- l'ora della sua prenotazione


2. Una classe Tavolo con le seguenti proprietà e i seguenti metodi: 
- Un array di Prenotazioni
 - public boolean aggiungiPrenotazione(int ora, String nomeCliente) { 
V.1 = salva la prenotazione e restituisce true a indicare che il tavolo è stato prenotato 
}
- public boolean rimuoviPrenotazione(int ora,  String nomeCliente) {
	controlla se il tavolo è stato prenotato dal cliente che vuole cancellare la prenotazione 
	dopodiché la cancella e restituisce true se la prenotazione è stata cancellata
}
- public String situazioneTavolo() {
 	mostra la situazione del tavolo: libero oppure prenotato dal cliente X all'ora X
 }
------ VERSIONE 2 ------
2. Una classe Tavolo con le seguenti proprietà e i seguenti metodi: 
- int APERTURA = 9;
- int CHIUSURA = 21;
- Un array di Prenotazioni
(effettuare controlli per orario di inizio e di fine.)
 - public boolean aggiungiPrenotazione(int oraInizio, int oraFine, String nomeCliente) { 
	controlla se i dati inseriti sono giusti (entro l'orario previsto e oraInizio < oraFine)
	controlla se il tavolo è disponibile 
	dopodiché 	salva la prenotazione e restituisce true a indicare che il tavolo è stato prenotato o false se il tavolo è già stato prenotato
}

- public boolean rimuoviPrenotazione(int ora,  int oraFine, String nomeCliente) {
	controlla se il tavolo è stato prenotato dal cliente che vuole cancellare la prenotazione 
	dopodiché la cancella e restituisce true se la prenotazione è stata cancellata
}
- public String situazioneTavolo() {
 	ritorna la situazione del tavolo: libero oppure prenotato dal cliente X all'ora X
 }
}
- public double utilizzoTavolo() {
	ritorna la percentuale di prenotazione del tavolo nell'arco della giornata
}

- public void stampaUtilizzo() {
	stampare l'utilizzo
}
- public void stampaSituazione() {
	stampa la situazione 
}

 * */
public class Class_Exe_2 {
	public static final String MY_SEPARATOR = "---------------------------------------";
	public static void main(String[] args) {
		/*t1*/
		Prenotazione p1=new Prenotazione("Mario Rossi",11,12,10.0);	
		Prenotazione p2=new Prenotazione("Viola Verdi",12,13,20.2);
		Prenotazione p3=new Prenotazione("Giacomo Bianchi",13,14,30.5);
		/*t2*/
		Prenotazione p4=new Prenotazione("Giuseppe Neri",11,12,15.1);	
		Prenotazione p5=new Prenotazione("David Blane",12,13,20.3);
		Prenotazione p6=new Prenotazione("Tomas Di belli",13,14,25.7);
		/*t3*/
		Prenotazione p7=new Prenotazione("Iris Elba",11,12,500.1);	
		Prenotazione p8=new Prenotazione("Giovanna D'arco",12,13,20.2);
		Prenotazione p9=new Prenotazione("Claudio Biondi",13,14,34.0);
		Prenotazione p10=new Prenotazione("Giovanni Ciaccia",14,15,36.0);
		/*Array di clienti che devono prenotare*/
		Prenotazione [] clientiT1 = {p1,p2,p3};
		Prenotazione [] clientiT2 = {p4,p5,p6};
		Prenotazione [] clientiT3 = {p7,p8,p9,p10};
		
		Tavolo tavolo1=new Tavolo();
		Tavolo tavolo2=new Tavolo();
		Tavolo tavolo3=new Tavolo();
		/*t1*/
		System.out.println("Tavolo 1:");
		for(Prenotazione cliente: clientiT1) {
			if(tavolo1.aggiungiPrenotazione(cliente.getOraInizio(),cliente.getOraFine(),cliente.getNome(),cliente.getConto())) {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" effettuata");
			}else {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" NON effettuata");
			}
		}
		/*t2*/
		System.out.println("Tavolo 2:");
		for(Prenotazione cliente: clientiT2) {
			if(tavolo2.aggiungiPrenotazione(cliente.getOraInizio(),cliente.getOraFine(),cliente.getNome(),cliente.getConto())) {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" effettuata");
			}else {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" NON effettuata");
			}
		}
		/*t3*/
		System.out.println("Tavolo 3:");
		for(Prenotazione cliente: clientiT3) {
			if(tavolo3.aggiungiPrenotazione(cliente.getOraInizio(),cliente.getOraFine(),cliente.getNome(),cliente.getConto())) {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" effettuata");
			}else {
				System.out.println("Prenotazione dalle ore: "+cliente.getOraInizio()+" fino a: "+cliente.getOraFine()+" cliente: "+cliente.getNome()+" NON effettuata");
			}
		}
		
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 1:");
		tavolo1.stampaSituazione();
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 2:");
		tavolo2.stampaSituazione();
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 3:");
		tavolo3.stampaSituazione();
		/*System.out.println(MY_SEPARATOR);		
		if(tavolo1.rimuoviPrenotazione(p1.getOraInizio(),p1.getOraFine(),p1.getNome())) {
			System.out.println("Rimozione effettuata prenotazione dalle ore: "+p1.getOraInizio()+" fino a: "+p1.getOraFine()+" cliente: "+p1.getNome());
		}else {
			System.out.println("Rimozione NON effettuata");
		}
		System.out.println(MY_SEPARATOR);
		tavolo1.stampaSituazione();
		System.out.println(MY_SEPARATOR);*/
		System.out.println(MY_SEPARATOR);
		System.out.println("Totale entrate tavolo 1: "+tavolo1.totaleConto()+" euro");
		System.out.println(MY_SEPARATOR);
		System.out.println("Totale entrate tavolo 2: "+tavolo2.totaleConto()+" euro");
		System.out.println(MY_SEPARATOR);
		System.out.println("Totale entrate tavolo 3: "+tavolo3.totaleConto()+" euro");
		System.out.println(MY_SEPARATOR);
		System.out.println("Totale entrate giornata: "+twoDecimalPlaces(tavolo1.totaleConto()+tavolo2.totaleConto()+tavolo3.totaleConto())+" euro");
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 1");
		tavolo1.stampaGraficaTavolo();
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 2");
		tavolo2.stampaGraficaTavolo();
		System.out.println(MY_SEPARATOR);
		System.out.println("Tavolo 3");
		tavolo3.stampaGraficaTavolo();
		System.out.println(MY_SEPARATOR);
		String [][] arrayGraficaPrenotazione= {
				tavolo1.graficaTavolo(),
				tavolo2.graficaTavolo(),
				tavolo3.graficaTavolo(),
		};
		System.out.println("Prenotazioni Globali");
		globalGraphic(arrayGraficaPrenotazione);
		System.out.println(MY_SEPARATOR);
	}
	public static double twoDecimalPlaces(double numberToTruncate) {
		return Math.floor(numberToTruncate * 100) / 100;
	}
	public static void globalGraphic(String [][] prenotazioniTavoli) {
		
		String [] prenotazione=new String[prenotazioniTavoli[0].length];
		
		for(int i=0; i<prenotazioniTavoli.length;i++) {
			
			for(int j=0; j<prenotazioniTavoli[i].length;j++) {
				if(prenotazioniTavoli[i][j]!=null) {
					if(prenotazione[j]==null) {
						prenotazione[j]="";
					}
					prenotazione[j]+="#";				
				}
			}
		}
		for(int i=0; i<prenotazione.length;i++) {
			if(prenotazione[i]!=null) {
				System.out.println(i+": "+prenotazione[i]);
			}
		}
		
	}
}


class Prenotazione {
	// attributi
	private String nome;
	private int oraInizio;
	private int oraFine;
	private double conto;

	Prenotazione() {

	}

	Prenotazione(String nome, int oraInizio,int oraFine,double conto) {
		this.nome = nome;
		this.oraInizio = oraInizio;
		this.oraFine=oraFine;
		this.conto=conto;
	}
	
	/*Getter*/
	public String getNome() {
		return this.nome;
	}
	public int getOraInizio() {
		return this.oraInizio;
	}
	public int getOraFine() {
		return this.oraFine;
	}
	public double getConto() {
		return this.conto;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setOraInizio(int oraInizio) {
		this.oraInizio=oraInizio;
	}
	public void setOra(int oraFine) {
		this.oraFine=oraFine;
	}
	public void getImporto(double conto) {
		this.conto=conto;
	}
}

class Tavolo {
	// attributi
	private Prenotazione [] arrayPrenotazioni=new Prenotazione[12];
	private int APERTURA = 9;
	private int CHIUSURA = 21;
	
	//metodi
	public boolean aggiungiPrenotazione(int oraInizio,int oraFine, String nomeCliente, double conto) {
		boolean prenotato=false;
		boolean impossibilePrenotare=false;
		
		if(oraInizio>=oraFine ||(oraInizio<APERTURA || oraInizio>CHIUSURA) || oraFine!=oraInizio+1) {
			return impossibilePrenotare;
		}
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null) {
				if(oraInizio==arrayPrenotazioni[i].getOraInizio() ) {
					return impossibilePrenotare;
				}
				
			}
		}
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]==null) {
				arrayPrenotazioni[i]= new Prenotazione(nomeCliente,oraInizio,oraFine,conto);
				prenotato=true;
				break;
			}
		}
		return prenotato;
	}

	public boolean rimuoviPrenotazione(int oraInizio,int oraFine, String nomeCliente) {
		
		//System.out.println("Prenotazione "+nomeCliente+" ore: "+ora+" rimossa");
		boolean rimozione=false;
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null && arrayPrenotazioni[i].getOraInizio()==oraInizio && arrayPrenotazioni[i].getOraFine()==oraFine && arrayPrenotazioni[i].getNome()==nomeCliente) {
				arrayPrenotazioni[i]=null;
				rimozione=true;
			}
		}
		
		if(rimozione) {
			return true;
		}else {
			return false;
		}
		 
		
	}
	public String situazioneTavolo() {
		
		String prenotazioni="Tavolo prenotato:\n";
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null ) {
				prenotazioni+=" {dalle ore: "+arrayPrenotazioni[i].getOraInizio()+" alle ore: "+arrayPrenotazioni[i].getOraFine()+" cliente "+arrayPrenotazioni[i].getNome()+" conto: "+arrayPrenotazioni[i].getConto()+" euro}\n";
				//System.out.println("Ora: "+arrayPrenotazioni[i].getOra()+" prenotato da: "+arrayPrenotazioni[i].getNome()+" ");
			}
		}
		return prenotazioni;
	}
	public double utilizzoTavolo() {
		//ritorna la percentuale di prenotazione del tavolo nell'arco della giornata
		double prenotazioni=0.0d;
		for(int i=0; i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null) {
				prenotazioni++;
			}
		}
		double percentuale=(prenotazioni/arrayPrenotazioni.length)*100;
		
		return  twoDecimalPlaces(percentuale);
	}

	public void stampaUtilizzo() {
		//stampare l'utilizzo
		System.out.println("Utilizzo tavolo: "+utilizzoTavolo()+"%");
	}
	public void stampaSituazione() {
		//stampa la situazione 
		System.out.println("Situazione tavolo:");
		System.out.println(situazioneTavolo());
	}
	public double totaleConto() {
		double totale=0.0d;
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null) {
				totale+=arrayPrenotazioni[i].getConto();
			}
		}
		return twoDecimalPlaces(totale);
	}
	public String[] graficaTavolo() {
		String [] prenotazioni=new String[CHIUSURA];
		
		for(int i=0;i<arrayPrenotazioni.length;i++) {
			if(arrayPrenotazioni[i]!=null) {
				for(int j=APERTURA;j<CHIUSURA;j++) {
					if(arrayPrenotazioni[i].getOraInizio()==j) {
						prenotazioni[j]="#";
					}
				}
				
			}
		}
		return prenotazioni;
	}
	public void stampaGraficaTavolo() {
		String [] prenotazioni=graficaTavolo();
		System.out.println("Prenotazioni: ");
		for (int i=0;i<prenotazioni.length;i++) {
			if(prenotazioni[i]!=null) {
				System.out.println(i+": #");
			}
		}
	}
	public double twoDecimalPlaces(double numberToTruncate) {
		return Math.floor(numberToTruncate * 100) / 100;
	}
}