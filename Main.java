import java.util.*;
import java.io.*;
class Main {
  public static void main(String args[]) {
    Scanner myObj = new Scanner(System.in);
    boolean flagRun = true;
    String email = "";
    HashMap<String, User> Users = new HashMap<String, User>();
    while(flagRun){
      System.out.println("Bienvenid@ a *nombre aplicación*\nYa tienes una cuenta (c), deseas registrarte(r) o salir (s)");
      String newUser = myObj.nextLine();
      if(!newUser.equals("s")) {
	      System.out.println("Escribe tu correo"); 
	      email = myObj.nextLine();
      }
      switch(newUser)
      {
        case "c" :
        if(Users.containsKey(email)){
          User CurrentUser = Users.get(email);
          boolean flagPassword = true;
          while(flagPassword){
            if (CurrentUser.CorrectUser(myObj)){
              System.out.println("Hola " + CurrentUser.name);
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
            Users.put(usuario.email, usuario);//no guarda el elemento en el map
          }
        break;

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