package BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.*;


public class Archive {
	
	private static File databaseFile = new File("DataBase");
	
	
	public static QueueArrayGeneric<SerieComparable> topSeries(String genre) {
		
		QueueArrayGeneric<SerieComparable> topSeries = new QueueArrayGeneric(11);
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
				
				if(!(type.contentEquals("movie")) && genders.contains(genre) && !topSeries.full()){
					
		
				
					
					SerieComparable serie = new SerieComparable(tittle,director,release_year,genders,description,average,runtime);
					topSeries.enqueue(serie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return topSeries;
		
		
	}
	
	
	public static StackArrayGeneric<MovieComparable> topMovies(String genre){
		
		StackArrayGeneric<MovieComparable> topMovies = new StackArrayGeneric<MovieComparable>(10);
		
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
				
				if(type.contentEquals("movie") && genders.contains(genre) && !topMovies.full()){
					
					int runtimet = Integer.parseInt(runtime);
					
					
					MovieComparable movie = new MovieComparable(tittle,director,release_year,genders,description,average,runtimet);
					topMovies.push(movie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return topMovies;
		
		
		
	}
	
	
	
	
	
	public static LinkedListGeneric<MovieComparable> movies(){
		

		
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
	
	public static LinkedListGeneric series(){
		
		LinkedListGeneric series = new LinkedListGeneric();
		
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
					
					
					SerieComparable serie = new SerieComparable(tittle,director,release_year,genders,description,average,runtime);
					System.out.println(serie);
					series.insert(serie);
					
					
					
					
				}				
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return series;
		
		
		
	}
	

}

