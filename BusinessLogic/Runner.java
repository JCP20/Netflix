package BusinessLogic;

import java.util.ArrayList;

import Data.*;

public class Runner {

	public static void main(String[] args) {
		
		LinkedListGeneric <MovieComparable> movies = Archive.movies();// lista enlazada ordenada por rating de las peliculas
		//ArrayList<Serie> series = Archive.series(); //arraylist de las series,cambiar a arreglo dinamico
		//movies.printRecursive();
    Login l = new Login();
    l.Inicio();
  }
}
