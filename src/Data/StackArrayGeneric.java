package Data;

// implementacion generica de  las pilas

public class StackArrayGeneric<T> {
	
	// se da un tamaño N superior para poder hacer las debidas pruebas en su momento
	private static final int N = 10*23;
	private int top;
	private T[] sarray;
	
	
	//Constructor
	
	public StackArrayGeneric() {
		this(N);
		
	}
	
	@SuppressWarnings("unchecked")
	public StackArrayGeneric(int n) {
		
		top = 0;
		sarray = (T[]) new Object[n];
			
	}
	
	// metodos basicos de las pílas
	
	public boolean empty() {//vacio
		
		return top<=0;
	}
	
	public boolean full() {// completo
		
		return top>=sarray.length;
	}
	
	public T pop() {// eliminar 
		
		if(empty()) throw new RuntimeException("Stack is empty");
		
		top--;
		return sarray[top];
	}
	
	public void push(T t) { // insertar
		
		if(full()) throw new RuntimeException("Stack is full");
		
		sarray[top] = t;
		top++;
	}
	
	public void printStack(){
        for(int iCont = 0; iCont < sarray.length; iCont++){
        	if(!(sarray[iCont].equals(null))) System.out.println(sarray[iCont]);
			     
        }
    }

}
