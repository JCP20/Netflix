package Data;

import java.io.*;
import java.util.*;

public class User {
  public String name, password, email;

  public HashMap<String, String[]> infoUsers = new HashMap<String, String[]>();// Usar las clases arreglos dinamicos que haga Diego
                                                                  // (String[])
  LinkedListGeneric<String> favGenres = new LinkedListGeneric<String>(); //Con linked List que haga Diego
  
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

  public LinkedListGeneric<String> getFavGenres() {
    return favGenres;
  }

  public void setFavGenres(LinkedListGeneric<String> favGenres) {
    this.favGenres = favGenres;
  }

  public User(String email){
    this.email = email;
    //Mientras está arreglos dinamicos
    favGenres.insert("Action/Aventure");
    favGenres.insert("Anime");
    favGenres.insert("Family Movies");
    favGenres.insert("Classic");
    favGenres.insert("Comedies");
    favGenres.insert("Crime");
    favGenres.insert("Cults");
    favGenres.insert("Documentaries"); 
    favGenres.insert("Drama");
    favGenres.insert("Horror");
    favGenres.insert("Independent");
    favGenres.insert("International");
    favGenres.insert("Kids");
    favGenres.insert("Romantic");
    favGenres.insert("Musical");
    favGenres.insert("Reality");
    favGenres.insert("Sports");
    favGenres.insert("Thriller");
    favGenres.insert("Sci-Fi");
    favGenres.insert("LGBTQ");
  }

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
        "Escoge el género de peliculas o series que prefieras, pon la que quieras en una sola linea, separados por espacios:\nAction/Aventure (0)\nAnime (1)\nBritish TVShows (2)\nFamily Movies (3)\nClassic (4)\nComedies(5)\nCrime (6)\nCults (7)\nDocumentaries (8)\nDrama (9)\nHorror (10)\nIndependent (11)\nInternational (12)\nKids (13)\nRomantic (14)\nMusical (15)\nReality (16)\nSports (17)\nThriller (18)\nSci-Fi (19)\nLGBTQ+ (20)\n");
    String genre = s.nextLine();
    String[] index = genre.split(" ");
    
    // Codigo Arreglo Dinamico
    //infoUsers.put(this.email, infoUser);
  }

  public boolean CorrectUser(Scanner s){
       System.out.println("Escribe tu contraseña");
       String posiblePassword = s.nextLine();
       if (this.password.equals(posiblePassword)){
         return true;
       }else{
         return false;
       }
  }
  public static void mejores10(String gnder,NodeGeneric<MovieComparable> primero){
		NodeGeneric<MovieComparable> TEM = primero;
		LinkedListGeneric Best10 = new LinkedListGeneric();
		MovieComparable genericmovie = new MovieComparable(" "," "," ",gnder," ",0," ");
		Best10.insertarfirst(genericmovie);
		while (TEM.getNext()!= null){ 
		  if (TEM.getData().getGenders() == gnder){
			NodeGeneric<MovieComparable> num1 = Best10.getFirst();
			if(TEM.getData().getAverage_rating()>=num1.getData().getAverage_rating()){
			  Best10.insertarfirst(TEM.getData());
			}else{
			  Boolean condicional = true;
			  NodeGeneric<MovieComparable> PRevv = num1;
			  num1 = num1.getNext();
			  while(condicional && num1 != null ){
				if(TEM.getData().getAverage_rating()>=num1.getData().getAverage_rating()){
					NodeGeneric<MovieComparable> nuevo = new NodeGeneric();
					newn.setData(TEM.getData());
					newn.setNext(num1);
				    PRevv.setNext(nuevo);
				    condicional = false;
				}else{
				PRevv = PRevv.getNext();
				num1 = num1.getNext();
				}
			  }
			}
		  }
		  TEM = TEM.getNext();
		}
		NodeGeneric<MovieComparable> temp = Best10.getFirst();
		for(int i=1;i<=10;i++){
			if (temp.getNext()!= null){
			    system.out.println(i+"."+temp.getData().getTitle()+".");
			    system.out.println("Director:"+temp.getData().getDirector()+".");
			    system.out.println("Año:"+temp.getData().getRelease_year()+".");
			    system.out.println("Genero:"+temp.getData().getGenders()+".");
			    system.out.println("descripcion:"+temp.getData().getDescription()+".");
			    system.out.println("Puntuacion:"+temp.getData().getAverage_rating()+".");
			    temp = temp.getNext();
			}
		}
  }
	
}