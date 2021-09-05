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
	
	  public List<MovieComparable> TopMovies(String Moviespq) {
			List<MovieComparable> topMovies = new ArrayList<MovieComparable>();
			Scanner scc= new Scanner(Moviespq);
			while(scc.hasNextLine()) {
				Scanner scc2= new Scanner(scc.nextLine());
				scc2.useDelimiter(";;");
				int runtime = Integer.parseInt(scc2.next());
				String title = scc2.next();
				String director = scc2.next();
				String year = scc2.next();
				String genres = scc2.next();
				String description = scc2.next();
				Double rating = Double.parseDouble(scc2.next());
				scc2.close();
				MovieComparable movie = new MovieComparable(title,director,year,genres,description,rating,runtime);
				topMovies.add(movie);		
			}
			scc.close();
			
			return topMovies;
		}
	  public List<SerieComparable> TopSeries(String Seriespq) {
			List<SerieComparable> topseries = new ArrayList<SerieComparable>();
			Scanner scc= new Scanner(Seriespq);
			while(scc.hasNextLine()) {
				Scanner scc2= new Scanner(scc.nextLine());
				scc2.useDelimiter(";;");
				String runtime = scc2.next();
				String title = scc2.next();
				String director = scc2.next();
				String year = scc2.next();
				String genres = scc2.next();
				String description = scc2.next();
				Double rating = Double.parseDouble(scc2.next());
				scc2.close();
				SerieComparable series = new SerieComparable(title,director,year,genres,description,rating,runtime);
				topseries.add(series);		
			}
			scc.close();
			
			return topseries;
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


