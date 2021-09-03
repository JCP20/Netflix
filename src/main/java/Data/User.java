package Data;

import java.io.*;
import java.util.*;

import BusinessLogic.Archive;

public class User {
  public String name, password, email,stack,queue;
  public int length;
  public StackArrayGeneric<MovieComparable> topMovies;
  public QueueArrayGeneric<SerieComparable> topSeries;
  public String moviespq, seriespq;

  public HashMap<String, String[]> infoUsers = new HashMap<String, String[]>();
    
   
   


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
	this.name = name;
	this.password = password;
	this.email = email;
	this.stack = stack;
	this.queue = queue;
}

public void Register(String nombre, String email, String password, ArrayList generos) {
    this.name = nombre;
    this.password = password;
    this.moviespq ="";
    this.seriespq ="";
    
    for(int i = 0;i < generos.size(); i++) {
    	String x = (String) generos.get(i);
    	String y = (String) generos.get(i);
    	PriorityQueue <MovieComparable> topMovies = Archive.topMovies(x);
    	PriorityQueue <SerieComparable> topSeries = Archive.topSeries(y);
    	  	
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



public boolean CorrectUser(String posiblePassword){
       
       return this.password.equals(posiblePassword);
  }

	
}