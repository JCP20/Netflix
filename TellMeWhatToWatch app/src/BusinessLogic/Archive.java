package BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.*;


public class Archive {
	
	private static File dataBaseFile = new File("DataBase.txt");
	
	
	public static PriorityQueue <SerieComparable> topSeries(String genre) {
		
		
		PriorityQueue <SerieComparable> topSeriespq = new PriorityQueue <SerieComparable>();
		
		
		try {
			Scanner sc = new Scanner(dataBaseFile,"UTF-8");
			
			
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
				
			
				
				if(!(type.contentEquals("movie")) && genders.contains(genre) && !topSeriespq.full()){
					
		
				
					
					SerieComparable serie = new SerieComparable(tittle,director,release_year,genders,description,average,runtime);
					
					
					
					topSeriespq.add(serie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return topSeriespq;
		
		
	}
	
	
	public static PriorityQueue <MovieComparable> topMovies(String genre){
		
		PriorityQueue <MovieComparable> topMoviespq = new PriorityQueue <MovieComparable>();
		try {
			Scanner sc = new Scanner(dataBaseFile,"UTF-8");
			
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
				
				if(type.contentEquals("movie") && genders.contains(genre) && !topMoviespq.full()){
					
					int runtimet = Integer.parseInt(runtime);
					
					
					MovieComparable movie = new MovieComparable(tittle,director,release_year,genders,description,average,runtimet);
					
					
					topMoviespq.add(movie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return topMoviespq;
		
		
		
	}
	
	
	
	
	
	public static LinkedListGeneric<MovieComparable> movies(){
		

		
		LinkedListGeneric<MovieComparable> movies = new LinkedListGeneric<MovieComparable>();
		
		try {
			Scanner sc = new Scanner(dataBaseFile,"UTF-8");
			
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
			Scanner sc = new Scanner(dataBaseFile,"UTF-8");
			
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
					series.insert(serie);
					
					
					
					
				}				
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return series;
		
		
		
	}
	

}

