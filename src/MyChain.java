public class MyChain {

	public static void main(String[] args) {
		// istanze di elementi della Chain
		MyChainElement portiere = new MyFirstElement(2);
		MyChainElement responsabile = new MySecondElement(1);
		MyChainElement ad = new MyThirdElement(0);
		
		// Imposta la sequenza della Chain
		portiere.mySetNextChainElement(responsabile);
		responsabile.mySetNextChainElement(ad); 
		// Le istanze eseguono i task 
		//portiere.myTryToSendMessage(0, "Messaggio con priorità Alta, iniziato da portiere"); 
		//portiere.myTryToSendMessage(1, "Messaggio con priorità Media, iniziato da portiere");
		//portiere.myTryToSendMessage(2, "Messaggio con priorità Bassa, iniziato da portiere");
		
		//responsabile.myTryToSendMessage(0, "Messaggio con priorità Alta, iniziato da responsabile");
		//responsabile.myTryToSendMessage(1, "Messaggio con priorità Media, iniziato da responsabile");
		
		ad.myTryToSendMessage(0, "Messaggio con priorità Alta, iniziato da ad");
	}
}

// Classe astratta
abstract class MyChainElement { 
	
  // Livelli 0=Alto, 1=Medio, 2=Basso
  protected int myLevel;
  
  // Dichiara l'elemento successivo della Chain
  protected MyChainElement myNextChainElement;
  
  // Imposta il livello successivo
  public void mySetNextChainElement(MyChainElement myNextChainElement){
     this.myNextChainElement = myNextChainElement;
  }
  
  // Esegue un task, ad esempio invia un messaggio di un determinato livello/priorità
  public void myTryToSendMessage(int level, String message){      
  	// Se il livello dell'elemento è maggiore/uguale dell'elemento in ingresso, invia il messaggio
     if(this.myLevel >= level){
         mySendMessage(message);
     }      
     // Se c'è un elemento successivo nella chain gli passa il task
     if(myNextChainElement !=null){
         myNextChainElement.myTryToSendMessage(level, message);
     }
  }
  
  abstract protected void mySendMessage(String message); 
  
}

// Classi concrete
class MyFirstElement extends MyChainElement{	 
  public MyFirstElement (int level){
        this.myLevel = level;
     }   
  protected void mySendMessage(String message){
      System.out.print("MyFirstElement -> ");
      System.out.println(message);       
  }   
}

class MySecondElement extends MyChainElement{	 
  public MySecondElement (int level){
        this.myLevel = level;
     }   
  protected void mySendMessage(String message){
      System.out.print("MySecondElement -> ");
      System.out.println(message);  

  }   
}

class MyThirdElement extends MyChainElement{	 
  public MyThirdElement (int level){
        this.myLevel = level;
     }   
  protected void mySendMessage(String message){
      System.out.print("MyThirdElement -> ");
      System.out.println(message);       
  }   
}