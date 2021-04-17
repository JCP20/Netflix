import java.io.*;
import java.util.*;

class User {
  String name, password, email;

  HashMap<String, String[]> infoUsers = new HashMap<String, String[]>();// Usar las clases arreglos dinamicos que haga Diego
                                                                  // (String[])
  String[] genres = new String[] {"Action/Aventure", "Anime", "British TVShows", "Family Movies","Classic", "Comedies", "Crime", "Cults", "Documentaries", "Drama", "Horror", "Independent", "International", "Kids", "Romantic","Musical","Reality","Sports","Thriller","Sci-Fi","LGBTQ"}; //Con linked List que haga Diego

  public User(String email){
    this.email = email;
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
        "Escoge el género de peliculas o series que prefieras, pon la que quieras en una sola linea, separados por espacios:\nAction/Aventure (1)\nAnime (2)\nBritish TVShows (3)\nFamily Movies (4)\nClassic (5)\nComedies(6)\nCrime (7)\nCults (8)\nDocumentaries (9)\nDrama (10)\nHorror (11)\nIndependent (12)\nInternational (13)\nKids (14)\nRomantic (15)\nMusical (16)\nReality (17)\nSports (18)\nThriller (19)\nSci-Fi (20)\nLGBTQ+ (21)\n");
    String genre = s.nextLine();
    String[] genreArray = genre.split(" ");
    int[] indexGenre = new int[genreArray.length];
    for (int i = 0; i<genreArray.length; i++) {
     indexGenre[i] = Integer.parseInt(genreArray[i])-1; 
    }
    
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