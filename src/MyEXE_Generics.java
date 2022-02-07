
public class MyEXE_Generics {
	
	public static void main(String[] args) {
		
		MyGenericClass <String> word = new MyGenericClass<>();
		word.setMyElement("Marco");
		
		MyGenericClass <Integer> number = new MyGenericClass<>();
		number.setMyElement(2);
		
		MyClassProduct prod=new MyClassProduct(11,"Lamp",22.22d);
		MyGenericClass <MyClassProduct> myClassProdGen = new MyGenericClass<>();
		myClassProdGen.setMyElement(prod);
		
		/*Il metodo toString viene chiamato automaticamente utilizzando System.out.println()*/
		System.out.println("MyString:"+word.getMyElement());
		System.out.println("MyInteger:"+number.getMyElement());
		System.out.println(myClassProdGen.getMyElement());
	}

}
class MyGenericClass <T>{
	/*Attributes*/
	T myElement;
	
	/*Constructor
	MyGenericClass(){
		
	}
	MyGenericClass(T myElement){
		this.myElement=myElement;
	}*/
	
	/*Getter*/
	public T getMyElement() {
		return myElement;
	}
	/*Setter*/
	public void setMyElement(T myElement) {
		this.myElement = myElement;
	}

}
class MyClassProduct{
	/*Attributes*/
	private int id;
	private String nome;
	private Double prezzo;
	
	/*Constructor*/
	MyClassProduct(int id,String nome, Double prezzo){
		this.id=id;
		this.nome=nome;
		this.prezzo=prezzo;
	}
	
	/*Getter*/
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	/*Setter*/
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	/*Methods*/
	public String toString(){
		
		return "MyClassProduct: {id='"+getId()+" nome='"+getNome()+"', prezzo='"+getPrezzo()+"'}";
	}
}
