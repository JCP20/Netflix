package BusinessLogic;

import java.util.ArrayList;


import Data.*;


public class Runner {

	public static void main(String[] args) {
		
		
		LinkedListGeneric <MovieComparable> movies = Archive.movies();
		LinkedListGeneric<SerieComparable> series = Archive.series();
		
		
		
		
		
		
		Login l = new Login();
		l.Inicio(movies);
		
		
	
		
		

	}

}
