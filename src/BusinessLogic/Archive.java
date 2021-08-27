package BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.*;

// Esta clase se encarga de leer y guardar los datos necesarios desde un archivo .txt 
public class Archive {
	// el archivo esta guardado de tal manera en que sea facil de leerce mediante un simple while.
	private static File databaseFile = new File("DataBase");
	
	// Este metodo guarda los datos de series teniendo en cuenta un determinado genero.
	public static QueueArrayGeneric<SerieComparable> topSeries(String genre) {
		// El tamano de la cola es estatico pues solo se busca recomendar 10 series
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
				
				//Se filtra los datos segun el tipo de producion(serie) y el genero (genre)
				if(!(type.contentEquals("movie")) && genders.contains(genre) && !topSeries.full()){
					
		
				
					// Crea un objeto de tipo serie comparable ingresando a la vez los datos especificos de cada serie encontrada.
					SerieComparable serie = new SerieComparable(tittle,director,release_year,genders,description,average,runtime);
					// Se encola la serie encontrada.
					topSeries.enqueue(serie);
					
					
					
				}				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return topSeries;
		
		
	}
	
	// Este metodo lee el archivo y lo guarda solo los datos que tengan que ver con peliculas y con un genero especifico.
	public static StackArrayGeneric<MovieComparable> topMovies(String genre){
		// el tamano de la pila es estatico pues lo que se busca es recomendar solo 10 peliculas
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
				//Se filtra los datos segun el tipo de producion(movie)y el genero(genre)
				if(type.contentEquals("movie") && genders.contains(genre) && !topMovies.full()){
					
					int runtimet = Integer.parseInt(runtime);
					
					//Crea un objeto tipo moviecomparable para posteriormente guardar este objecto en la pila
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
	
	
	
	
	// Este metodo lee el archivo, guarda y ordena todos los datos relacionados con peliculas.
	public static LinkedListGeneric<MovieComparable> movies(){
		

		// crea la estructura dond se guardaran todos los datos requeridos
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
				// se filtran los datos de tal manera de que solo recibe peliculas
				if(type.contentEquals("movie")){
					
					int runtimet = Integer.parseInt(runtime);
					
					// se crea el objeto de tipo moviecomparable para posteriormente guardalo en la lista enlazada
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
	// por ultimo este metodo se encarga de leer el archivo tomando solamente los datos que representan a las series
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
					
					// se guarda los datos en objetos para posteriormente ser guardados en la lista enlazada
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

