package Data;

import java.util.Arrays;

public class DynamicArray {
  // El almacenamiento de los elementos. 
  // La capacidad es la longitud de esta matriz.
  private int[] data;

  // El número de elementos (tamaño lógico).
  // Debe ser menor que la capacidad.
  private int size;


  public DynamicArray()
  {
    data = new int[16];
    size = 0;
  }

  public DynamicArray(int capacity)
  {
    if (capacity < 16)
    capacity = 16;
    data = new int[capacity];
    size = 0;
  }

  // Aumenta la capacidad, si es necesario, para asegurar que
  // Que puede contener al menos el número de elementos
  // Especificado por el argumento de capacidad mínima.
  public void ensureCapacity(int minCapacity)
  {
    int oldCapacity = data.length;
    if (minCapacity > oldCapacity)
    {
      int newCapacity = (oldCapacity * 2);
      if (newCapacity < minCapacity)
        newCapacity = minCapacity;
      data = Arrays.copyOf(data, newCapacity);
    }
  }

  // Returns the logical size
  public int size()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  // Comprueba si el índice especificado está dentro del rango.  
  private void rangeCheck(int index)
  {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException("Index: " + 
            index + ", Size: " + size);
  }

  // Returns the element at the specified position.
  public int get(int index)
  {
    rangeCheck(index);
    return data[index];
  }

  // Appends the specified element to the end.
  public boolean add(int element)
  {
    ensureCapacity(size + 1);
    data[size++] = element;
    return true;
  }

  // Elimina todos los elementos.
  public void clear()
  {
    size = 0;
  }

  // Reemplaza el elemento en la posición especificada
  public int set(int index, int element)
  {
    rangeCheck(index);
    int oldValue = data[index];
    data[index] = element;
    return oldValue;
  }

  public int capacity()
  {
    return data.length;
  }
}