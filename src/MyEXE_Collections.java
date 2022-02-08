import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyEXE_Collections {

	public static void main(String[] args) {

		MiaRubrica rubrica=new MiaRubrica();
		Contatto cont1=new Contatto("Mario","Rossi",50,"3344323434");
		Contatto cont2=new Contatto("Lucia","Verdi",20,"3352323434");
		Contatto cont3=new Contatto("Mirco","Gialli",40,"3425623423");
		rubrica.addContatto(cont1.getNumTelefono(),cont1.getInformazioniDiContatto());
		rubrica.addContatto(cont2.getNumTelefono(),cont2.getInformazioniDiContatto());
		rubrica.addContatto(cont3.getNumTelefono(),cont3.getInformazioniDiContatto());
		
		rubrica.removeContatto(cont1.getNumTelefono());
		Map <String,String> contatti=rubrica.getContatti();
		
		//System.out.println(contatti);
		System.out.println("Contatti in rubrica: ");
		for(String myKey: contatti.keySet()) {
			System.out.println(contatti.get(myKey)+" numero: "+myKey);
		}
		System.out.println("-------------------------------------------");
		System.out.println("Ricerca per numero: "+rubrica.cercaPerNumTel("3425623423"));
		System.out.println("Ricerca per nome Lucia: "+rubrica.cercaPerNom("Lucia"));
		System.out.println("Ricerca per nome Ciao: "+rubrica.cercaPerNom("Ciao"));
	}

}
class Contatto{
	
	private String nome;
	private String cognome;
	private int eta;
	private String numTelefono;
	
	Contatto(){
		
	}
	Contatto(String nome,String cognome,int eta,String numTelefono){
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.numTelefono=numTelefono;
	}
	/*Getter*/
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public int getEta() {
		return eta;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public String getInformazioniDiContatto() {
		return nome+" "+cognome+" eta: "+eta;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
}
abstract class Rubrica<T>{
	Map <String,String> contatti=new HashMap<>();
	public Rubrica() {
		
	}
	public Rubrica(Map <String,String> contatti) {
		this.contatti=contatti;
	}
	abstract void addContatto(String key,String value);
	abstract void removeContatto(String key);
	abstract String cercaPerNumTel(String key);
	abstract String cercaPerNom(String value);
	abstract Map <String,String> getContatti();
}
class MiaRubrica extends Rubrica{
	
	MiaRubrica(){}
	
	MiaRubrica(Map <String,String> contatti){
		super(contatti);
	}
	@Override
	void addContatto(String key,String value) {
		contatti.put(key,value);
	}

	@Override
	void removeContatto(String key) {
		contatti.remove(key);
	}

	@Override
	Map<String, String> getContatti() {
		return contatti;
	}

	@Override
	String cercaPerNumTel(String key) {
		return contatti.get(key).toString();
	}

	@Override
	String cercaPerNom(String value) {
		for(Object myKey: contatti.keySet()) {
			if(contatti.get(myKey).toString().toLowerCase().contains(value.toLowerCase())) {
				return contatti.get(myKey).toString();
			}
		}
		return "contatto non presente";
		
	}

	
}