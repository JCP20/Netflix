package Data;



public class ArrayListGeneric<T extends Comparable<T>> {
		private int position, count;
		private SerieComparable[] dArray;
		private int sizeofarray;
		
	
	public void print() {
		
		for(int i=0; i < sizeofarray; i++) {
			
			System.out.println(this.dArray[i]);
			
			
		}
		
	}
	
	
	public ArrayListGeneric() {
		sizeofarray = 1;
		SerieComparable[] dArray =(SerieComparable[]) new Object[sizeofarray];
		//dArray = (T[]) Array.newInstance(clazz, sizeofarray);
		count = 0;   
	}
	
	private boolean empty() {
		return count <= 0;
	}
	
	private boolean full() {
		return count >= sizeofarray;
	}
	
	
	public boolean insert(SerieComparable item) {
		boolean inserted=false;
		if(!full())
			if (!search(item)){
				for(int j=count; j>position; j--)
					dArray[j] = dArray[j-1];
				dArray[position] = (SerieComparable) item;
				count++;
				inserted = true;
			}
		else
			growSize();
			insert(item);
		return inserted;
	}
	
	public void growSize(){    
		SerieComparable[] temp = null;   
		if (count == sizeofarray){   
			temp =  (SerieComparable[]) new Object [sizeofarray * 2];   
			for (int i = 0; i < sizeofarray; i++){   
				temp[i] = (SerieComparable) dArray[i];   
				}   
		}   
		dArray = temp;   
		sizeofarray= sizeofarray * 2;   
	} 	
	
	
	
	public boolean delete(SerieComparable item) {
		boolean deleted=false;
		if(!empty())
			if(search(item)){
				for(int j=position; j<count-1; j++)
					dArray[j] = dArray[j+1];
				count--;
				deleted = true;
			}
		else
			System.out.println("List is Empty");
		return deleted;
	 }
	
	public boolean search(SerieComparable item) {
		boolean found, stop;
		found = false;
		stop = false;
		position = 0;
		while(position != count && !stop)
			if(dArray[position].compareTo(item) >= 0){
				stop = true;
				if(dArray[position].compareTo(item) == 0)
					found = true;
			}
			else
				position++;
		return found;
	}	
} 