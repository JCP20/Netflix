package BusinessLogic;

import java.util.ArrayList;


import Data.*;

// Runner funciona como un main 
public class Runner {

	public static void main(String[] args) {
		// se guardan las peliculas en listas enlazadas
		LinkedListGeneric <MovieComparable> movies = Archive.movies();
		//movies.printRecursive();
		
		// Se guardan las series en listas enlazadas
		
		//LinkedListGeneric series = Archive.series();
		//series.printRecursive();
		
		// Se crea y se ejecuta la interfaz login
		Login l = new Login();
		l.Inicio(movies);
		
		
	

		

	}

}
