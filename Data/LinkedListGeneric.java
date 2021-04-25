package Data;

public class LinkedListGeneric<T extends Comparable<T>> {
	
	private NodeGeneric<T> head;
  int counter = 0;
	
	public LinkedListGeneric() {
		
		this.head = null;
		
	}
	public NodeGeneric<T> getFirst(){
		return this.head
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
			
			if(prev == null)
				head = newp;
			else 
				prev.setNext(newp);
      counter += 1;
			
		}
		return inserted;
			
	}
    public void insertarfirst (T item){
		NodeGeneric<T> newn = new NodeGeneric();
		newn.setData(item);
		newn.setNext(head);
		head = newn;
		counter++;
	}
  private void erase (T elem){
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
