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


