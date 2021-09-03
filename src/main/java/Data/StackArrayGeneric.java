package Data;

public class StackArrayGeneric<T> {
	
	private static final int N = 10*23;
	private int top;
	private T[] sarray;
	
	
	//Constructors
	
	public StackArrayGeneric() {
		this(N);
		
	}
	
	@SuppressWarnings("unchecked")
	public StackArrayGeneric(int n) {
		
		top = 0;
		sarray = (T[]) new Object[n];
			
	}
	
	//Value returning methods	
	
	public boolean empty() {
		
		return top<=0;
	}
	
	public boolean full() {
		
		return top>=sarray.length;
	}
	
	public T pop() {
		
		if(empty()) throw new RuntimeException("Stack is empty");
		
		top--;
		return sarray[top];
	}
	
	public void push(T t) {
		
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
