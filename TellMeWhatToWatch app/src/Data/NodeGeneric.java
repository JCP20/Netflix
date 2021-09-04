package Data;

public class NodeGeneric<T> {
	
	private T data;
	private NodeGeneric<T> next;
	
	public NodeGeneric() {
		
		this(null);
		
	}
	
	public NodeGeneric(T data) {
		
		this.data = data;
		next = null;
		
		
	}
	
	public T getData() {
		
		return data;
		
	}
	
	public void setData(T data) {
		
		this.data = data;
	}
	
	public NodeGeneric<T> getNext() {
		
		return next;
	}
	
	public void setNext(NodeGeneric<T> next) {
		
		
		this.next = next;
	}
	
	public static void printRecursive(NodeGeneric < String > ref) {
		if(ref != null) {
		System.out.println(ref.getData());
		printRecursive(ref.getNext());
		}
		}

}
