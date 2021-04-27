package Data;

import java.io.*;
import java.util.*;

import BusinessLogic.Archive;

// La clase user contendra las variables y metodos asociados al objeto user que posteriormente sera guardado en el archivo XML

public class User {
  public String name, password, email,stack,queue;
  public int length;
  public StackArrayGeneric<MovieComparable> topMovies;
  public QueueArrayGeneric<SerieComparable> topSeries;
  

  public HashMap<String, String[]> infoUsers = new HashMap<String, String[]>();
  
   // se guarda en un arreglo todos los generos 
   static String favGenres [] = new String[] {"Action","Animation","Biography","Comedy","Crime","Documentary","Drama","Family","Fantasy","Adventure","Horror","History","Musical","Mystery","News","Romance","Reality-TV","Sport","Sci-Fi","Short","Thriller","War","Western"}; //Con linked List que haga Diego
  
   
   

// setters y getters
public void setLength(int length) {
	this.length = length;
}

public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }



  public User(String email){
    this.email = email;
    

  }
  
  
  
 
  public String getQueue() {
	return queue;
}

public void setQueue(String queue) {
	this.queue = queue;
}

public User(String name, String password, String email, String stack, String queue) {
	this.name = name;// datos de inico de secion
	this.password = password;
	this.email = email;
	this.stack = stack;// Datos asociados a las recomendaciones.
	this.queue = queue;
}
// el metodo register solicita al usuario los datos de registro y le pregunta sobre sus gustos para asi poder dar las correpondientes recomendaciones 
public void Register(Scanner s) {
    boolean FlagPasswordCorrect = true;
    System.out.println("Escribe el nombre que deseas utilizar"); // Comparar con Hashmap
    this.name = s.nextLine();
    while(FlagPasswordCorrect){
      System.out.println("Escribe la contraseña que deseas utilizar, que sea mayor 8 caracteres");
      this.password = s.nextLine();
      if(this.password.length()<8){
        System.out.println("Escribe contraseña valida");
        FlagPasswordCorrect = true;
      }else{
        FlagPasswordCorrect = false;
      }
    }
    System.out.println(
        "Escoge el género de peliculas o series que prefieras, pon la que quieras en una sola linea, separados por espacios:\nAction (0)\nAnimation (1)\nBiography (2)\nComedy (3)\nCrime (4)\nDocumentary(5)\nDrama (6)\nFamily (7)\nFantasy (8)\nAdventure (9)\nHorror (10)\nHistory (11)\nMusical (12)\nMystery (13)\nNews (14)\nRomance (15)\nReality-TV (16)\nSport (17)\nSci-Fi (18)\nShort (19)\nThriller (20)\nWar (21)\nWestern (22)");
    String genre = s.nextLine();
    String[] index = genre.split(" ");
    
  
    
    
    
   // dependiendo de los generos escojidos por el usuario se crean pilas y colas para organizar los recomendados
	
   // Se crean pilas de pilas y colas de colas, teniendo en cuenta que el usuario escoje varios generos, 
   // cada pila o cola representa una pila o cola de recomendaciones de  uno de los generos.
   
    QueueArrayGeneric<QueueArrayGeneric<SerieComparable>> topGenresSeries = new QueueArrayGeneric<QueueArrayGeneric<SerieComparable>>(index.length);
    StackArrayGeneric<StackArrayGeneric<MovieComparable>> topGenresMovies = new StackArrayGeneric<StackArrayGeneric<MovieComparable>>(index.length);
   
    for(int i = 0;i < index.length; i++) {
    	
    	StackArrayGeneric<MovieComparable> topMovies = Archive.topMovies(favGenres[Integer.parseInt(index[i])]);
    	topGenresMovies.push(topMovies);
    	
    	QueueArrayGeneric<SerieComparable> topSeries = Archive.topSeries(favGenres[Integer.parseInt(index[i])]);
    	topGenresSeries.enqueue(topSeries);
    	
    	
    	
    }
    
    
    
    this.queue="";
    this.stack="";
    
    // se aprobecha los metodos pop y dequeue para devolver los datos escojidos
	
    for(int i = 0;i<index.length;i++) {
    	
    	QueueArrayGeneric<SerieComparable> aux = topGenresSeries.dequeue();
    	StackArrayGeneric<MovieComparable> aux1 = topGenresMovies.pop();
    	
    	for(int j = 0;j < 10;j++) {
    		
    		
    		this.queue += aux.dequeue().toString() + "\n";
    		this.stack += aux1.pop().toString() +"\n";
    		
    	}
    	
    }
    
    
  
    
   /* for(int i = 0;i < index.length; i++) {
    	
    	StackArrayGeneric<MovieComparable> aux = topGenresMovies.pop();
    	
    	for(int j = 0; j < 10;j++) {
    		
    		this.stack += aux.pop().toString() +"\n";
    		
    		
    	}
    }
    
    
  */
  }


public String getStack() {
	return stack;
}
// solicita la contraseña para verificar si esta es correcta
public boolean CorrectUser(Scanner s){
       System.out.println("Escribe tu contraseña: ");
       String posiblePassword = s.nextLine();
       
       return this.password.equals(posiblePassword);
  }

	
}
