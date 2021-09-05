package BusinessLogic;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import Data.*;


public class Login {
	
	static public int length;
	
	  public String TopMovies(String email) {
			QueueArrayGeneric<MovieComparable> topMovies = new QueueArrayGeneric<MovieComparable>();
			XML arch = new XML();
			arch.create();
			HashMap<String, User> Users = arch.read();
			User Userdef = Users.get(email);
			//Scanner scc= new Scanner(Userdef.getMoviespq());
			//while(scc.hasNextLine()) {
				//Scanner scc2= new Scanner(scc.nextLine());
				//scc2.useDelimiter(";");
				//int runtime = Integer.parseInt(scc.next());
				//String title = scc.next();
				//String director = scc.next();
				//String year = scc.next();
				//String genres = scc.next();
				//String description = scc.next();
				//Double rating = Double.parseDouble(scc.next());
				
				//MovieComparable movie = new MovieComparable(title,director,year,genres,description,rating,runtime);
				//topMovies.enqueue(movie);	
				
			//}
			
			
			return Userdef.getMoviespq();
		}

  public static String InicioSesion(String email, String password) {
	  String UsuarioAutenticado = "UsuarioAutenticado";
	  String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
	  Pattern p = Pattern.compile(emailRegex);
	  XML arch = new XML();
	  arch.create();
	  HashMap<String, User> Users = arch.read();
	  Matcher m = p.matcher(email);
	    if(!m.find()){
	      return("Ingrese un correo valido");
	    }else{
	    	if(Users.containsKey(email)){
	          User CurrentUser = Users.get(email);
	          if (!CurrentUser.CorrectUser(password)){
	        	  return("Contraseña incorrecta, intentalo de nuevo");
	          }
	    	}
	    	else{
		        return("El usuario relacionado a ese correo no existe, por favor cree una cuenta.");
		        }
	    }	   
		return UsuarioAutenticado;
  }
  public static String Registrar(String nombre, String email, String password, ArrayList<String> generos) {
    String UsuarioAutenticado = "UsuarioAutenticado";
    String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
    Pattern p = Pattern.compile(emailRegex);
    XML arch = new XML();
    arch.create();
    HashMap<String, User> Users = arch.read();
	Matcher m = p.matcher(email);
	 if(!m.find()){
	      return("Ingrese un correo valido");
	      }
	 else {
		 User usuario = new User(email);
         if(Users.containsKey(email)){
           return("Este correo ya tiene un usuario");
	     }
         else if(password.length()<8){
           return("Escribe contraseña valida");
         }
         else {
             usuario.Register(nombre, email, password, generos);
             arch.write(usuario);
         }
     }
	return UsuarioAutenticado;
  }
}


