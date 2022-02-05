
public class MyClass {
	public static final String MY_SEPARATOR = "---------------------------------------";

	public static void main(String[] args) {

		// int myInt=23;

		String[] myArray1 = new String[3];

		/*
		 * Variabile di tipo prodotto/nuova istanza della classe prodotto con la parola
		 * chiave new TipoClasse() si utilizza il costruttore della classe
		 */

		Prodotto p1 = new Prodotto("iPhone", "Apple", 995.00);
		Prodotto p2 = new Prodotto("Fragole", "La Contadina", 9.99);
		Prodotto p3 = new Prodotto("Manuale di spravvivenza", "Feltrinelli", 25.50);

		Prodotto p4 = new Prodotto("iPhone", "Apple", 1995.00);
		System.out.println("P4 " + p4.getPrezzo());

		/*
		 * Stampa della rappresentazione in memoria di questi oggetti
		 * 
		 * @1ee0005 questa sezione della stampa corrisponde a l'indirizzo di memoria
		 * l'inidirizzo di memoria viene asseggnato all'istanza di oggetto in maniera
		 * casuale tramite il garbage collector (questo si occupa principalmente della
		 * cancellazione di un indirizzo di memoria, anche se per far ciò deve prima
		 * attribuirgli tale indirizzo
		 */
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		System.out.println("P3: " + p3);

		System.out.println(MY_SEPARATOR);

		/* Sintassi dot notation o notazione di punto */

		/*
		 * System.out.println("P1 - Nome: "+p1.nome+" P1 - Marca: "+p1.
		 * marca+" P1 - Prezzo: "+p1.prezzo);
		 * System.out.println("P2 - Nome: "+p2.nome+" P2 - Marca: "+p2.
		 * marca+" P2 - Prezzo: "+p2.prezzo);
		 * System.out.println("P3 - Nome: "+p3.nome+" P3 - Marca: "+p3.
		 * marca+" P3 - Prezzo: "+p3.prezzo);
		 * 
		 * la sintassi notazione di punto/dot notation (quando si riferisce ad una
		 * proprietà publica di classe) vale/può essere utilizzata anche in scrittura
		 * p1.nome="Ciao";
		 */

		p1.setPrezzo(1000.0);

		System.out.println("P1 - Prezzo: " + p1.getPrezzo());

		System.out.println(MY_SEPARATOR);

		System.out.println(
				"P1 - Nome: " + p1.getNome() + " P1 - Marca: " + p1.getMarca() + " P1 - Prezzo: " + p1.getPrezzo());
		System.out.println(
				"P2 - Nome: " + p2.getNome() + " P2 - Marca: " + p2.getMarca() + " P2 - Prezzo: " + p2.getPrezzo());
		System.out.println(
				"P3 - Nome: " + p3.getNome() + " P3 - Marca: " + p3.getMarca() + " P3 - Prezzo: " + p3.getPrezzo());

		System.out.println(MY_SEPARATOR);
	}

}

/* Dichiarazione di Classe */
class MyClassDec {

	/* Prorpietà/attributi /campi incapsulati/field */
	private String myClassString;
	protected Integer myClassInteger;
	public Boolean myClassBoolean;

	/*
	 * Metodo costruttore, ha esattamente lo stesso nume della classe questo è il
	 * metodo con il quale possiamo creare più istanze di una classe
	 */
	public MyClassDec() {

	}
}

class Prodotto {
	// Proprietà/Attributi/Campi/Field
	private String nome;
	private String marca;
	private double prezzo;

	/* costruttore: permette la creazione di più istanze di classe */
	public Prodotto() {
		// corpo costruttore
	}

	public Prodotto(String nome, String marca, Double prezzo) {
		/*
		 * si utilizza la keyword this. poichè le prorpietà della classe hanno lo stesso
		 * nome degli argomenti del costruttore
		 */
		this.nome = nome;
		this.marca = marca;
		/* set a upword bound for the Double value */
		if (prezzo <= 999.00) {
			this.prezzo = prezzo;
		}else {
			System.out.println("Il prezzo, non può essere superiore a 999.00, è stato impostato a 0,0");
		}

		/*
		 * Se i nomi degli argomenti del costruttore, sono diversi da quelli degli
		 * attributi si può evitare di utilizzare this. nome=argomentoNome;
		 * marca=argomentoMarca; prezzo= argomentoPrezzo;
		 */
	}

	/* getter (ottieni) */
	public String getNome() {
		return this.nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public Double getPrezzo() {
		return this.prezzo;
	}

	/* setter (imposta) */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPrezzo(Double prezzo) {
		if (prezzo <= 999.00) {
			this.prezzo = prezzo;
		} else {
			System.out.println("Il prezzo, non può essere superiore a 999.00");
		}
	}
}
