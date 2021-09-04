package Data;

import java.util.ArrayList;

public class HashMapGeneric<E>{

    int counterKeys = 0;
    int l = 50; //Longitud cadena más larga (key)
    int p, x;

    ArrayList<LinkedListDoubleGeneric<String,E>> arrayListKey = new ArrayList<LinkedListDoubleGeneric<String,E>>(p);

    public HashMapGeneric() {
        this.p = 4831;
        this.x = (int) (Math.random()*(p-1))+1;
        LinkedListDoubleGeneric<String,E> L;
        for(int i = 0; i < this.p; i++){
            L = new LinkedListDoubleGeneric<String,E>();
            this.arrayListKey.add(L);
        }
    }
    
    public HashMapGeneric(int p) {
        this.p = p;
        this.x = (int) (Math.random()*(p-1))+1;
        LinkedListDoubleGeneric<String,E> L;
        for(int i = 0; i < this.p; i++){
            L = new LinkedListDoubleGeneric<String,E>();
            this.arrayListKey.add(L);
        }
    }

    public void put(String key, E value){
        rehash();
        LinkedListDoubleGeneric<String,E> L = arrayListKey.get(polyHash(key));
        if(L.search(key, value)){
            return;
        }
        L.insert(key, value);
        counterKeys++;
    }

    private int polyHash(String t) {
        int hash = 0;
        for(int i = t.length()-1; i>=0 ; i--){
            hash = (hash*x + (int) t.charAt(i))%p;
        }
        return hash;
    }

    private void rehash(){
        int s = this.arrayListKey.size();
        double loadFactor = l/p;

        if(loadFactor>0.9){
            ArrayList<LinkedListDoubleGeneric<String,E>> newArray = new ArrayList<LinkedListDoubleGeneric<String,E>>(s*2);
            this.p = 9239; 
            this.x = (int) (Math.random()*(p-1))+1;
            for(LinkedListDoubleGeneric<String,E> O: arrayListKey){
                newArray.add(polyHash(O.getFirst().getDataK().toString()), O);
            }
            this.arrayListKey = newArray; 
        }
    }

    public E get(String key){
        LinkedListDoubleGeneric<String,E> L = arrayListKey.get(polyHash(key));
        return L.get(key).getDataV();
    }

    public void print(String key){
        LinkedListDoubleGeneric<String,E> L = arrayListKey.get(polyHash(key));
        L.printRecursive();
    }

    public void printTotal(){
        for(LinkedListDoubleGeneric<String,E> O: arrayListKey){
            if(O.getFirst() != null){
                O.printRecursive();
            }    
        }
        
    }

    public boolean find(String key){
        LinkedListDoubleGeneric<String,E> L = arrayListKey.get(polyHash(key));
        return L.search(key);
    }

    public E remove(String key){
        LinkedListDoubleGeneric<String,E> L = arrayListKey.get(polyHash(key));
        if(L.search(key)){
            return L.erase(key);
        }
        return null;
    }

}
