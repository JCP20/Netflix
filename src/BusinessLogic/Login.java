package BusinessLogic;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import Data.*;

// Esta clase se encarga en pocas palabras de presentar una primera interfas  que interactua con el usuario
class Login {
	
	static public int length;
	  // Al igual que la clase archivo, login tambien lee un archivo y guardar datos de peliculas en pilas
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
	// Se piden y se procesan las acciones del usuario para poder manipular las estructuras
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
      System.out.println("Bienvenid@ a *nombre aplicación*\nYa tienes una cuenta (c), deseas registrarte(r) o salir (s)");
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
      //dependiendo de la repuesta del usuario se realizan diferentes acciones como inciar secion, registrarse o cerrar el programa
      switch(newUser)
      {
        case "c" :
        if(Users.containsKey(email)){
          User CurrentUser = Users.get(email);
          boolean flagPassword= true;
          // Se imprimen los datos(recomendaciones) guardados durante el registro.
          while(flagPassword){
            if (CurrentUser.CorrectUser(myObj)){
              System.out.println("Hola " + CurrentUser.getName());
              
              System.out.println("Estas son tus peliculas recomendadas: ");
              System.out.println(CurrentUser.getStack());
              
              System.out.println("Estas son tus series recomendadas: ");
              System.out.println(CurrentUser.getQueue());
              
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
        // Se crea un objecto usuario y se llama al metodo register que se encarga de guardar los datos que el usuario registre.
        case "r" :
          User usuario = new User(email);
          if(Users.containsKey(email)){
            System.out.println("Este correo ya tiene un usuario");
          }else{
           	 
           usuario.Register(myObj);
            arch.write(usuario);
          }
        break;
        // Se rompe el ciclo para poder finalizar el programa
        case "s":
         flagRun = false;
         System.out.println("Gracias por usar nuestra aplicación");
        break;
        
        default : 
          System.out.println("Escoje una de las tres opciones");
        }
      
    }
    myObj.close();
  }
}
