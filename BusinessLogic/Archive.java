package BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.LinkedListGeneric;
import Data.MovieComparable;
import Data.Serie;

public class Archive {
	
	private static File databaseFile = new File("DataBase");
	
	
	
	
	public static LinkedListGeneric<MovieComparable> movies(){
		
		//ArrayList<Movie> movies = new ArrayList<Movie>();
		
		LinkedListGeneric<MovieComparable> movies = new LinkedListGeneric<MovieComparable>();
		
		try {
			Scanner sc = new Scanner(databaseFile);
			
			while(sc.hasNext()) {
				
				String s = sc.nextLine();
				@SuppressWarnings("resource")
				Scanner read = new Scanner(s);
				read.useDelimiter(",");
				
				String tittle = read.next();
				String director = read.next();
				String release_year = read.next();
				String description = read.next();
				String type = read.next();
				String runtime = read.next();
				String genders = read.next();
				double average = Double.parseDouble(read.next());
				
				if(type.contentEquals("movie")){
					
					int runtimet = Integer.parseInt(runtime);
					
					
					MovieComparable movie = new MovieComparable(tittle,director,release_year,genders,description,average,runtimet);
				
					movies.insert(movie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return movies;
	}
	
	public static ArrayList<Serie> series(){
		
		ArrayList<Serie> series = new ArrayList<Serie>();
		
		try {
			Scanner sc = new Scanner(databaseFile);
			
			while(sc.hasNext()) {
				
				String s = sc.nextLine();
				Scanner read = new Scanner(s);
				read.useDelimiter(",");
				
				String tittle = read.next();
				String director = read.next();
				String release_year = read.next();
				String description = read.next();
				String type = read.next();
				String runtime = read.next();
				String genders = read.next();
				double average = Double.parseDouble(read.next());
				
				if(!(type.contentEquals("movie"))){
					
					
					Serie serie = new Serie(tittle,director,release_year,genders,description,average,runtime);
					series.add(serie);
					System.out.println(serie);
					
				}				
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return series;
		
		
		
	}
	

}

