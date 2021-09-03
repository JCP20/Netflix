package Data;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<T extends Comparable<T>> {
	
	
	
	ArrayList<T> arrayList = new ArrayList<T>();

	public void add(T obj) {
	    arrayList.add(obj);
	}

	public T prioritySearch() {
	    T priority = arrayList.get(0);
	    for (int i = 0; i < arrayList.size(); i++) {
	        if (arrayList.get(i).compareTo(priority) > 0) {
	            priority = arrayList.get(i);
	        }
	    }
	    return priority;
	}

	public void priorityCompare() {
	    int out, in;
	    for (out = arrayList.size() - 1; out > 0; out--) {
	        for (in = 0; in < out; in++) {
	        	if (arrayList.get(in).compareTo(arrayList.get(in + 1)) > 0) {
	                swap(in, in + 1);
	            }
	            
	        }
	    }
	}

	private void swap(int one, int two) {
	    Collections.swap(arrayList, one, two);
	}

	public Object remove() {
	    if (arrayList.isEmpty()) {
	        return null;
	    }
	    T obj = prioritySearch();
	    arrayList.remove(obj);
	    return obj;
	}

	public void print() {
	    for (int i = 0; i < arrayList.size(); i++) {
	        System.out.println(arrayList.get(i));
	    }
	}
	
	public String getItems() {
		
		String items = "";
	    for (int i = 0; i < arrayList.size(); i++) {
	        items += arrayList.get(i).toString() + "\n";
	    }
		
		
		return items;
		
	}
	
	public boolean full() {
		
		
		return this.arrayList.size()==10;
		
		
		
	}
	

}
