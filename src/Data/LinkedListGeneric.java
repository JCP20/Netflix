package Data;

public class LinkedListGeneric<T extends Comparable<T>> {
	
	private NodeGeneric<T> head;
	static private  int counter = 0;
	
	public LinkedListGeneric() {
		
		head = null;
		
	}
		
	public static int getCounter() {
		return counter;
	}



	public static void setCounter(int counter) {
		LinkedListGeneric.counter = counter;
	}



	public NodeGeneric<T> getFirst(){
		return this.head;
		}
	
	public void insertfirst (T item){
		NodeGeneric<T> newn = new NodeGeneric();
		newn.setData(item);
		newn.setNext(head);
		head = newn;
		counter++;
	}
	
	public boolean search(T item) {
		
		boolean inserted = false;
		NodeGeneric<T> ptr;
		ptr = head;
		
		while(ptr.getNext()!=null && !inserted ) {
			 if(ptr.getData().equals(item)) inserted = true;
			 
			 ptr = ptr.getNext();
			
			
		}
		
		return inserted;
	}
	

	
	public boolean insert(T item) {
		
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
	
	public void erase (T elem){
		
		
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
	
	private void printR(NodeGeneric<T> p) {
		
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
