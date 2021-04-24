package Data;

import java.io.*;
import java.util.*;

public class User {
  public String name, password, email;

  public HashMap<String, String[]> infoUsers = new HashMap<String, String[]>();// Usar las clases arreglos dinamicos que haga Diego
                                                                  // (String[])
  LinkedListGeneric<String> favGenres = new LinkedListGeneric<String>(); //Con linked List que haga Diego

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
}