package Data;

import java.util.*;

import BusinessLogic.Archive;

public class User {
  public String name, password, email;
  public String moviespq, seriespq;
  public int length;
  private PriorityQueue <MovieComparable> topMovies;
  private PriorityQueue <SerieComparable> topSeries;
  
  static String favGenres [] = new String[] {"Action","Animation","Biography","Comedy","Crime","Documentary","Drama","Family","Fantasy","Adventure","Horror","History","Musical","Mystery","News","Romance","Reality-TV","Sport","Sci-Fi","Short","Thriller","War","Western"}; //Con linked List que haga Diego
  
   
   


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
  
  
 
public User(String name, String password, String email,String moviespq,String seriespq) {
	this.name = name;
	this.moviespq = moviespq;
	this.password = password;
	this.email = email;
	this.seriespq = seriespq;
}

public void Register(Scanner s) {
    boolean FlagPasswordCorrect = true;
    System.out.println("Escribe el nombre que deseas utilizar"); 
    this.name = s.nextLine();
    while(FlagPasswordCorrect){
      System.out.println("Escribe la contraseña que deseas utilizar, que sea mayor 7 caracteres");
      this.password = s.nextLine();
      if(this.password.length()<8){
        System.out.println("Escribe contraseña valida");
        FlagPasswordCorrect = true;
      }else{
        FlagPasswordCorrect = false;
      }
    }
    System.out.println(
        "Escoge el genero de peliculas o series que prefieras, pon la que quieras en una sola linea, separados por espacios:\nAction (0)\nAnimation (1)\nBiography (2)\nComedy (3)\nCrime (4)\nDocumentary(5)\nDrama (6)\nFamily (7)\nFantasy (8)\nAdventure (9)\nHorror (10)\nHistory (11)\nMusical (12)\nMystery (13)\nNews (14)\nRomance (15)\nReality-TV (16)\nSport (17)\nSci-Fi (18)\nShort (19)\nThriller (20)\nWar (21)\nWestern (22)");
    String genre = s.nextLine();
    
    String[] index = genre.split(" ");
    
   
    this.moviespq ="";
    this.seriespq ="";
    
    for(int i = 0;i < index.length; i++) {
    	
 
    	topMovies = Archive.topMovies(favGenres[Integer.parseInt(index[i])]);
    	topSeries = Archive.topSeries(favGenres[Integer.parseInt(index[i])]);
    
    	for(int j=0;j<10;j++) {
    		
    		this.moviespq += topMovies.prioritySearch().toString();
    		topMovies.remove();
    		
    		this.seriespq += topSeries.prioritySearch().toString();
    		topSeries.remove();
    		
    		}

    } 
    
}




public String getSeriespq() {
	return seriespq;
}

public void setSeriespq(String seriespq) {
	this.seriespq = seriespq;
}

public String getMoviespq() {
	return moviespq;
}

public void setMoviespq(String moviespq) {
	this.moviespq = moviespq;
}



public boolean CorrectUser(Scanner s){
       System.out.println("Escribe tu contrase�a: ");
       String posiblePassword = s.nextLine();
       
       return this.password.equals(posiblePassword);
  }

	
}