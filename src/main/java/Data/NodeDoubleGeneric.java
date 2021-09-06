package Data;

public class NodeDoubleGeneric<T,E> {
    
    private T datak;
    private E datav;
	private NodeDoubleGeneric<T,E> next;
	
	public NodeDoubleGeneric() {
		
		this(null, null);
		
	}
	
	public NodeDoubleGeneric(T datak, E datav) {
		
		this.datak = datak;
        this.datav = datav;
		next = null;
		
		
	}
	
	public T getDataK() {
		
		return datak;
		
	}
	
	public void setDataK(T datak) {
		
		this.datak = datak;
	}

    public E getDataV() {
		
		return datav;
		
	}
	
	public void setDataV(E datav) {
		
		this.datav = datav;
	}
	
	public NodeDoubleGeneric<T,E> getNext() {
		
		return next;
	}
	
	public void setNext(NodeDoubleGeneric<T,E> next) {
		
		
		this.next = next;
	}
	
	public static void printRecursive(NodeDoubleGeneric < String, String > ref) {
		if(ref != null) {
		System.out.println(ref.getDataK()+ " " + ref.getDataV());
		printRecursive(ref.getNext());
		}
	}
}
