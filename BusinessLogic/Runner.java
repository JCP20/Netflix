package BusinessLogic;

import java.util.ArrayList;

import Data.Movie;
import Data.Serie;

public class Runner {

	public static void main(String[] args) {
		
		ArrayList<Movie> movies = Archive.movies();
		ArrayList<Serie> series = Archive.series();
		
		//System.out.println("Peliculas: ");
		//for(Movie m:movies) {
			//System.out.println(m);
		
		//}
		
		
		
		System.out.println("Series: ");
		for(Serie s:series) {
			System.out.println(s);
			
		}
		
		

	}

}
