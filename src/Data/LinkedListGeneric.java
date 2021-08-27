package Data;

// implementacion de las listas enlazadas de manera generica 

public class LinkedListGeneric<T extends Comparable<T>> {
	
	private NodeGeneric<T> head;// la lista esta simplemete enlazada y sin cola
	static private  int counter = 0;// tamano
	
	public LinkedListGeneric() {// constructor
		
		head = null;
		
	}
	
	// metodos basicos para un buen funcionamiento
	
	public static int getCounter() {
		return counter;
	}



	public static void setCounter(int counter) {
		LinkedListGeneric.counter = counter;
	}



	public NodeGeneric<T> getFirst(){// acceso a la lista
		return this.head;
		}
	
	public void insertfirst (T item){// insertar al inicio pushfront
		NodeGeneric<T> newn = new NodeGeneric();
		newn.setData(item);
		newn.setNext(head);
		head = newn;
		counter++;
	}
	
	public boolean search(T item) {// recorre la lista en busqueda de un dato
		
		boolean inserted = false;
		NodeGeneric<T> ptr;
		ptr = head;
		
		while(ptr.getNext()!=null && !inserted ) {
			 if(ptr.getData().equals(item)) inserted = true;
			 
			 ptr = ptr.getNext();
			
			
		}
		
		return inserted;
	}
	

	
	public boolean insert(T item) { // insertar de manera ordenada
		
		boolean inserted;
		NodeGeneric<T> ptr,prev;
		inserted = false;
		ptr = head;
		prev = null;
		
		while(ptr != null && ptr.getData().compareTo(item) < 0) {
			
			
			prev = ptr;
			ptr = ptr.getNext();
			
		}
		
		if(ptr == null || !(ptr.getData().equals(item))) {
			
			inserted = true;
			NodeGeneric<T> newp = new NodeGeneric();
			newp.setData(item);
			newp.setNext(ptr);
			
			if(prev == null) {
				
				counter ++;
				head = newp;
			}
				
			else 
				prev.setNext(newp);

			
		}
		return inserted;
			
	}
	
	public void erase (T elem){// borrar o eliminar
		
		
	    if (head == null){ 
	      System.out.println("lista vacía");
	    }else{
	      if (head.getData()== elem){
	        head = head.getNext();
	        counter--;
	      }else {
	        NodeGeneric<T> ptr;
	        ptr = head;
	        while (ptr.getNext()!=null && ptr.getNext().getData() != elem){
	          ptr = ptr.getNext();
	        }  
	        if (ptr.getNext()== null){
	          System.out.println ("elemento "+elem+" no esta en la lista");
	        }else{
	          ptr.setNext(ptr.getNext().getNext());
	          counter--;
	        }    
	      }
	    }
	  } 
	
	private void printR(NodeGeneric<T> p) {// muestra la lista
		
		if(p != null) {
			
			System.out.println(p.getData() );
			printR(p.getNext());
			
		}
		
	}
	
	public void printRecursive() {
		
		printR(head);
		System.out.println();
		
	}

}
