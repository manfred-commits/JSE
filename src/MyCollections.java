import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MyCollections {

	public static void main(String[] args) {
		/*Polymorphism*/
		/*volendo si può dare una capacità iniziale all'ArrayList<>(5)*/
		List<String> myList=new ArrayList<>();
		/*add*/
		myList.add("Aldo");
		myList.add("Giovanni");
		myList.add("Giacomo");
		myList.add("Ciro");
		
		/*remove*/
		myList.remove("Giovanni");
		
		/*get*/
		System.out.println("myList get(1): "+myList.get(1));
		
		/*indexOf*/
		System.out.println("myList indexOf('Aldo'): "+myList.indexOf("Aldo"));
		
		/*Iterator*/
		ListIterator<String> myIterator =myList.listIterator();
		
		while(myIterator.hasNext()) {
			/*nextIndex, prende l'indice*/
			int myIndex= myIterator.nextIndex();
			/*prende il prossimo elemento nuovo (mettondo Object come tipo di
			 * myValue per polimorfismo si può dare una variabile di tipo Stringa*/
			String myValue=myIterator.next();
			System.out.println("myList myIterator: "+ myIndex +"="+myValue);
		}
		System.out.println("-------------------------");
		
		/*Polymorphism*/
		List<Integer> myListInt=new ArrayList<>();
		/*add*/
		myListInt.add(1);
		myListInt.add(2);
		myListInt.add(3);
		
		/*se si rimuove il casting, prende il numero come indice della collezione*/
		myListInt.remove((Integer)3);
		
		ListIterator<Integer> myIteratorInt =myListInt.listIterator();
		
		
		while(myIteratorInt.hasNext()) {
			/*nextIndex, prende l'indice*/
			int myIndex= myIteratorInt.nextIndex();
			/*prende il prossimo elemento nuovo (mettondo Object come tipo di
			 * myValue per polimorfismo si può dare una variabile di tipo Stringa*/
			Integer myValue=myIteratorInt.next();
			System.out.println("myList myIterator: "+ myIndex +"="+myValue);
		}
		System.out.println("-------------------------");
		
		/*LinkedList*/
		LinkedList<String> myLinkedList= new LinkedList<>();
		myLinkedList.add("B");
		/*aggiunge in cima è in fondo*/
		myLinkedList.addFirst("A");
		myLinkedList.addLast("C");
		
		/*remove(),removeFirst(),removeLast()*/
		System.out.println("myLinkedList: "+ myLinkedList);
		System.out.println("-------------------------");
		
		/*QUEUE*/
		
		Queue<Integer> myQueue=new ArrayBlockingQueue<>(3);
		/*definizione della capacità massima della collezione*/
		myQueue.add(111);
		myQueue.add(222);
		myQueue.add(333);
		/*offer: if space is available adds, otherwise it doesn't add*/
		myQueue.offer(444);
		
		/*elment() e peek()*/
		/*remove() e poll()*/
		Iterator<Integer> myIterator2 =myQueue.iterator();
		
		while(myIterator2.hasNext()) {
			/*prende il prossimo elemento nuovo (mettondo Object come tipo di
			 * myValue per polimorfismo si può dare una variabile di tipo Stringa*/
			Integer myValue=myIterator2.next();
			System.out.println("myList myIterator: " +"="+myValue);
		}
		System.out.println("-------------------------");
		
		
		ArrayDeque<String> myArrayDeque=new ArrayDeque<>();
		myArrayDeque.add("C");
		myArrayDeque.addFirst("A");
		myArrayDeque.addLast("C");
		
		System.out.println("myArrayDequeue getFirst(): "+myArrayDeque.getFirst());
		System.out.println("-------------------------");
		
		PriorityQueue<Integer> myPriorityQueue = new PriorityQueue<>();
		/*ordina*/
		myPriorityQueue.add(3);
		myPriorityQueue.add(1);
		myPriorityQueue.add(2);
		myPriorityQueue.add(0);
		
		System.out.println("myPriorityQueue: "+myPriorityQueue);
		
		System.out.println("-------------------------");
		/*SET*/
		System.out.println("--SET");
		Set<Integer> mySet = new HashSet<Integer>();
		mySet.add(2);
		mySet.add(3);
		mySet.add(3);
		mySet.add(1);
		System.out.println("Set: "+mySet);
		System.out.println("-------------------------");
		
		TreeSet<String> myTreeSet= new TreeSet<>();
		myTreeSet.add("TSA");
		myTreeSet.add("TSB");
		myTreeSet.add("TSB");
		System.out.println("TREESet: "+myTreeSet);
		System.out.println("-------------------------");
		
		/*EnumSet*/
		
		
		/*MAP*/
		
		/*HashMap
		 * ordina secondo l'HashCode di tutte le chiavi*/
		HashMap<String,String> myHashMap=new HashMap<>();
		myHashMap.put("Portiere", "Donnarumma");
		myHashMap.put("TerzinoDx","Bastoni");
		myHashMap.put("TerzinoSx","Pinotto");
		System.out.println("myHashMap: "+myHashMap);
		
		for(String myKey: myHashMap.keySet()) {
			System.out.println("myHashMap for in(): "+myHashMap.get(myKey));
		}
		System.out.println("-------------------------");
		
		/*IdentityHashMap*/
		IdentityHashMap<Integer,String> myIdentityHashMap=new IdentityHashMap<>();
		myIdentityHashMap.put(3, "C");
		myIdentityHashMap.put(2, "A");
		myIdentityHashMap.put(1, "B");
		System.out.println("myIdentityHashMap: "+myIdentityHashMap);
		System.out.println("-------------------------");
	}

}
