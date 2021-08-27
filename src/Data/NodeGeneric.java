package Data;

// Las referencias que se encargan de enlazar las listas enlazadas
// Fue necesario usar genericos pues  estas se pensaron para varios tipos de datos.

public class NodeGeneric<T> {
	
	private T data;
	private NodeGeneric<T> next;
	// constructor y metodos principales para el funcionamiento de los nodos.
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
	
	public NodeGeneric getNext() {
		
		return next;
	}
	
	public void setNext(NodeGeneric<T> next) {
		
		
		this.next = next;
	}
	// recorre y devuelve la lista completa
	public static void printRecursive(NodeGeneric < String > ref) {
		if(ref != null) {
		System.out.println(ref.getData());
		printRecursive(ref.getNext());
		}
		}

}
