
public class MyArray {
	public static final String MY_SEPARATOR="---------------------------------------";
	
	public static void main(String[] args) {
		
		
		//String[] miaLista= new String[3];
		//inizializzazione differita
		String[] myArray1=new String[3];
		
		
		myArray1[0]="Aldo";
		myArray1[1]="Giovanni";
		myArray1[2]="Giacomo";
		
		/*exception array out of bounds for index 3, 
		 * because the length of the array is 3
		 * myArray1[3]="Ciruzzo";*/ 
		
		/*printing the name of the array without [] print the 
		 * allocation of the array in the memory*/
		
		System.out.println("Il valore all'indice 2 in myArray1:  "+ myArray1[2]);
		
		//inizializzazione diretta
		String [] myArray2= {"Alda","Giovanna","Giacomina"};
		
		System.out.println("Il valore all'indice 2 in myArray1:  "+ myArray2[2]);
		
		String [] cibi= {"mela","pera","banana"};
		
		System.out.println(MY_SEPARATOR);
		int counter=0;
		for(String cibo:cibi) {
			System.out.println("Il cibo in posizione "+(counter+1)+" è: "+cibo);
			counter++;
		}
		System.out.println(MY_SEPARATOR);
		
		
		int [][]array2D= {{1,2},{2},{3,4,5}};
		for(int i=0;i<array2D.length;i++) {
			for(int j=0;j<array2D[i].length;j++) {
				System.out.println("Il numero in posizione "+i+" "+j+" è: "+array2D[i][j]);
			}		
			
		}
		System.out.println(MY_SEPARATOR);
		
		int[][] myOtherArray2D=new int[3][2];
		
		
		
		myOtherArray2D[0][0]= 1;
		myOtherArray2D[1][0]=2;
		myOtherArray2D[2][0]=3;
		
		for(int i=0;i<myOtherArray2D.length;i++) {
			for(int j=0;j<myOtherArray2D[i].length;j++) {
				System.out.println("Il numero in posizione "+i+" "+j+" è: "+myOtherArray2D[i][j]);
			}		
			
		}
		System.out.println(MY_SEPARATOR);
	}

}
