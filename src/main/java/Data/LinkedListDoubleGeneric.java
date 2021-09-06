package Data;

public class LinkedListDoubleGeneric<T,E> {
    private NodeDoubleGeneric<T,E> head;
	static private  int counter = 0;
	
	public LinkedListDoubleGeneric() {
		
		head = null;
		
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		LinkedListDoubleGeneric.counter = counter;
	}



	public NodeDoubleGeneric<T,E> getFirst(){
		return this.head;
	}
	
	public void insertFirst (T itemk, E itemv){
		NodeDoubleGeneric<T,E> newn = new NodeDoubleGeneric<T,E>();
		newn.setDataK(itemk);
        newn.setDataV(itemv);
		newn.setNext(head);
		head = newn;
		counter++;
	}
	
	public boolean search(T itemk, E itemv) {
		
		boolean inserted = false;
		NodeDoubleGeneric<T,E> ptr;
		ptr = head;
		if(ptr == null){
			return false;
		}
		
		while(ptr!=null && !inserted ) {
			 if(ptr.getDataK().equals(itemk) && ptr.getDataV().equals(itemv)) inserted = true;
			 
			 ptr = ptr.getNext();
			
			
		}
		
		return inserted;
	}

	public boolean search(T itemk) {
		
		boolean inserted = false;
		NodeDoubleGeneric<T,E> ptr;
		ptr = head;
		if(ptr == null){
			return false;
		}
		
		while(ptr!=null && !inserted ) {
			 if(ptr.getDataK().equals(itemk)) inserted = true;
			 
			 ptr = ptr.getNext();
			
			
		}
		
		return inserted;
	}
	 
	public NodeDoubleGeneric<T,E> get(T itemk){
		
		boolean inserted = false;
		NodeDoubleGeneric<T,E> ptr;
		ptr = head;
		if(ptr == null){
			return null;
		}
		
		while(ptr!=null && !inserted ) {
			 if(ptr.getDataK().equals(itemk)) {
				inserted = true;
				break;
			 }
			 	
			 ptr = ptr.getNext();	
		}
		if (inserted){
			return ptr;
		}
		return null;
		
	}

	
	public boolean insert(T itemk, E itemv) {
		
		boolean inserted;
		NodeDoubleGeneric<T,E> ptr,prev;
		inserted = false;
		ptr = head;
		prev = null;
		
		while(ptr != null) {
			prev = ptr;
			ptr = ptr.getNext();	
		}
		
		if(ptr == null || !(ptr.getDataK().equals(itemk))) {
			
			inserted = true;
			NodeDoubleGeneric<T,E> newp = new NodeDoubleGeneric<T,E>();
			newp.setDataK(itemk);
            newp.setDataV(itemv);
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
	
	public E erase (T elem){
		E val = null;
	    if (head == null){ 
	        System.out.println("lista vacÃ­a");
	    }else{
            if (head.getDataK()== elem ){
				val = head.getDataV();
                head = head.getNext();
                counter--;
            }else {
                NodeDoubleGeneric<T,E> ptr;
                ptr = head;
                while (ptr.getNext()!=null && ptr.getNext().getDataK() != elem ){
                	ptr = ptr.getNext();
                }  
                if (ptr.getNext()== null){
                	System.out.println ("elemento "+elem+" no esta en la lista");
                }else{
					val = ptr.getNext().getDataV();
					ptr.setNext(ptr.getNext().getNext());
					counter--;
                }    
            }
	    }
		return val;
	} 
	
	private void printR(NodeDoubleGeneric<T,E> p) {
		
		if(p != null) {
			
			System.out.println(p.getDataK() +" "+ p.getDataV() );
			printR(p.getNext());
			
		}
		
	}
	
	public void printRecursive() {
		
		printR(head);
		System.out.println();
		
	}
}
