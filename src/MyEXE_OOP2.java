
public class MyEXE_OOP2 {
	public static final String MY_SEPARATOR = "---------------------------------------";

	public static void main(String[] args) {

		Rettangolo ret = new Rettangolo(10, 10, new Punto2D(2, 2));
		Quadrato quad = new Quadrato(20, 20, new Punto2D(5, 8));
		Cubo cub = new Cubo(10);
		System.out.println(MY_SEPARATOR);
		System.out.println("Area Rettangolo di altezza " + ret.getAltezza() + " e larghezza " + ret.getLarghezza()
				+ " è: " + ret.calcolaArea());
		System.out.println("Coordinate: {" + ret.getCoordinate().getX() + "," + ret.getCoordinate().getY() + "}");
		System.out.println(MY_SEPARATOR);
		System.out.println("Area quadrato di altezza " + quad.getAltezza() + " e larghezza " + quad.getLarghezza()
				+ " è: " + quad.calcolaArea());
		System.out.println("Coordinate: {" + quad.getCoordinate().getX() + "," + quad.getCoordinate().getY() + "}");
		System.out.println(MY_SEPARATOR);
		System.out.println("Conoscendo lo spigolo del cubo: " + cub.getSpigolo() + " sappiamo che la superficie sarà: "
				+ cub.calcolaSuperficie() + " e il suo volume è: " + cub.calcolaVolume());
		System.out.println(MY_SEPARATOR);
		System.out.println("Rettangolo: ");
		ret.disegna();
		System.out.println(MY_SEPARATOR);
		System.out.println("Quadrato: ");
		quad.disegna();
		System.out.println(MY_SEPARATOR);
	}

}

interface Forma {
	void disegna();
}

interface Forma2D extends Forma {
	int calcolaArea();
	int calcolaPerimetro();
}

interface Forma3D extends Forma {
	int calcolaSuperficie();
	int calcolaVolume();
}

class Rettangolo implements Forma2D {
	/* attributes */
	private int larghezza;
	private int altezza;
	private Punto2D coordinate;
	
	/*costruttore*/
	Rettangolo(int larghezza, int altezza, Punto2D coordinate) {
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.coordinate = coordinate;
	}

	/* Getter */
	public int getLarghezza() {
		return this.larghezza;
	}
	public int getAltezza() {
		return this.altezza;
	}
	public Punto2D getCoordinate() {
		return coordinate;
	}
	/* Setter */
	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	public void setCoordinate(Punto2D coordinate) {
		this.coordinate = coordinate;
	}
	
	/* METHODS */
	@Override
	public void disegna() {
		String [][] coordinateCartesiane=new String[30][50];
		
		for(int y=0; y<coordinateCartesiane.length;y++) {
			for(int x=0;x<coordinateCartesiane[y].length;x++) {
				if(coordinate.getX()==x && coordinate.getY()==y) {
					coordinateCartesiane[y][x]="#";
				}
				coordinateCartesiane[y][x]=".";
			}
		}
		String graph="#";
		for(int y=coordinate.getY(); y<altezza+coordinate.getY();y++) {
			for(int x=coordinate.getX();x<larghezza+coordinate.getX();x++) {
				coordinateCartesiane[y][x]=graph;
			}
		}
		for(int y=0; y<coordinateCartesiane.length;y++) {
			for(int x=0;x<coordinateCartesiane[y].length;x++) {
				System.out.print(coordinateCartesiane[y][x]);
			}
			System.out.println();
		}
			
			
	}
	@Override
	public int calcolaArea() {
		int area = altezza * larghezza;
		return area;
	}
	@Override
	public int calcolaPerimetro() {
		int perimetro = (2 * altezza) + (2 * larghezza);
		return perimetro;
	}
}

class Quadrato extends Rettangolo {
	/*costruttore*/
	Quadrato(int larghezza, int altezza, Punto2D coordinate) {
		super(larghezza, altezza, coordinate);
	}
	
	/*Methods*/
	@Override
	public int calcolaArea() {
		int area = (int) Math.pow(getLarghezza(), 2);
		return area;
	}
}

class Cubo implements Forma3D {
	/*attributo*/
	private int spigolo;
	
	/*costructor*/
	Cubo(int spigolo) {
		this.spigolo = spigolo;
	}

	/* Getter */
	public int getSpigolo() {
		return spigolo;
	}

	/* Setter */
	public void setSpigolo(int spigolo) {
		this.spigolo = spigolo;
	}

	/* Methods */
	@Override
	public void disegna() {

	}
	@Override
	public int calcolaSuperficie() {
		int superficie = 6 * (int) Math.pow(spigolo, 2);
		return superficie;
	}
	@Override
	public int calcolaVolume() {
		int volume = (int) Math.pow(spigolo, 3);
		return volume;
	}
}

class Punto2D {
	/*Attributi*/
	private int x;
	private int y;

	Punto2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* Getter */
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	/* Setter */
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}