package Data;
public class QueueArrayGeneric<T> {
private final int N = 10*23;
private int front, rear, count;
private T[] qarray;

	
//implementacion de la colas apartir de lo visto en clase y del texto guia
	
public QueueArrayGeneric() {
front = rear = count = 0;
qarray = (T[]) new Object[N];
}

@SuppressWarnings("unchecked")
	// constructor
public QueueArrayGeneric(int size) {
	

	front = rear = count = 0;
	qarray = (T[]) new Object[size];
	
	
	
}

public T dequeue() {// desencolar
T item = null;
if(empty())
System.out.println("Queue is empty: item not dequeued");
else {
item = qarray[front];
front = (front + 1) % N;
count--;
}
return item;
}
public void enqueue(T item) {// encolar
if(full())
System.out.println("Queue is full: item not enqueued");
else {
qarray[rear] = item;
rear = (rear + 1) % N;
count++;
}
}
public boolean empty() {// vacio
return count <= 0;
}
public boolean full() { // lleno
return count >= 10;
}
public int getCount() {
return count;
}
} 
