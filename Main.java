import java.util.*;
import java.io.*;
class Main {
  public static void main(String args[]) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Bienvenid@ a *nombre aplicación*\nYa tienes una cuenta (c) o deseas registrarte(r)");
    HashMap<String, User> Users = new HashMap<String, User>();
    String newUser = myObj.nextLine();
    System.out.println("Escribe tu correo"); 
    String email = s.nextLine();
    switch(newUser)
    {
      case "c" :
       //comparar el email y la contraseña
       //Si no se encuentra ese email avisarle al usuario
      break; // break es opcional
   
      case "r" :
      User usuario = new User();
      //Buscar email en hashmap si está decir que el usuario ya existe, sino:
      usuario.Register(myObj);
      break; 
      
      default : 
        System.out.println("Escoje una de las dos opciones");
      }
  }
}