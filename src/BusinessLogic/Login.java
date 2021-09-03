package BusinessLogic;


//import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import Data.*;


class Login {
	
	static public int length;
	
	  public static StackArrayGeneric<MovieComparable> topMovies(String stack) {
			Scanner sc = new Scanner(stack);
			StackArrayGeneric<MovieComparable> topMovies = new StackArrayGeneric<MovieComparable>();

			while(sc.hasNext()) {
				String s = sc.nextLine();
				Scanner scc = new Scanner(s);
				scc.useDelimiter(",");
				int runtime = Integer.parseInt(scc.next());
				String title = scc.next();
				String director = scc.next();
				String year = scc.next();
				String genres = scc.next();
				String description = scc.next();
				Double rating = Double.parseDouble(scc.next());
				
				MovieComparable movie = new MovieComparable(title,director,year,genres,description,rating,runtime);
				topMovies.push(movie);	
				
				
			}
			
			return topMovies;

		}
	

	  public static void Inicio(LinkedListGeneric<MovieComparable> list) {
		  Scanner myObj = new Scanner(System.in);
		  boolean flagRun = true;
		  String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
		  Pattern p = Pattern.compile(emailRegex);
		  String email = "";
		  XML arch = new XML();
		  arch.create();
	 
		  while(flagRun){
			  HashMap<String, User> Users = arch.read();
			  System.out.println("Bienvenid@ a TellWhatToWatch\nYa tienes una cuenta (c), deseas registrarte(r) o salir (s)");
			  String newUser = myObj.nextLine();
			  if(!newUser.equals("s")) {
				  boolean flagEmail = true;
				  System.out.println("Escribe tu correo"); 
				  while(flagEmail){
					  email = myObj.nextLine();
					  Matcher m = p.matcher(email);
					  if(!m.find()){
						  System.out.println("Ingrese un correo valido");
						  flagEmail = true;
					  }else{
						  flagEmail = false;
					  }
				  }
			  }
			  
			  switch(newUser){
			  
			  	case "c" :		
			  	if(Users.containsKey(email)){
			  		User CurrentUser = Users.get(email);
			  		boolean flagPassword= true;
			  		while(flagPassword){
			  			if (CurrentUser.CorrectUser(myObj)){
			  				System.out.println("Hola " + CurrentUser.getName() +" :)" + "");
	              
			  				System.out.println("Estas son tus peliculas recomendadas: ");
			  				System.out.println(CurrentUser.getMoviespq());
			  				System.out.println("Estas son tus series recomendadas: ");
			  				System.out.println(CurrentUser.getSeriespq());
	              
			  				flagPassword = false;
			  			}else{
			  				System.out.println("Contraseña incorrecta, intentalo de nuevo");
			  				flagPassword = true;
			  			}
			  		}
			  	}else{
			  		System.out.println("El usuario relacionado a ese correo no existe, por favor cree una cuenta.");
			  	}
			  	break; 
	    
			  	
			  	case "r" :
			  	User usuario = new User(email);
			  	if(Users.containsKey(email)){
			  		System.out.println("Este correo ya tiene un usuario");
			  	}else{ 
			  		usuario.Register(myObj);
			  		arch.write(usuario);
			  	}
			  	break;
	
			  	
			  	case "s":
			  	flagRun = false;
			  	System.out.println("Gracias por usar nuestra aplicacion");
			  	break;
	        
			  	default : 
			  		System.out.println("Escoje una de las tres opciones");
			  }
	    }
	    myObj.close();
	  }
}