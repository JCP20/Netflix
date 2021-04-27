package BusinessLogic;

import java.util.ArrayList;


import Data.*;


public class Runner {

	public static void main(String[] args) {
		
		LinkedListGeneric <MovieComparable> movies = Archive.movies();
		//movies.printRecursive();
		
		//LinkedListGeneric series = Archive.series();
		//series.printRecursive();
		
		Login l = new Login();
		l.Inicio(movies);
		
		
	

		

	}

}
