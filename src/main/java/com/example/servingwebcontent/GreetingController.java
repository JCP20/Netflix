package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import BusinessLogic.*;
import Data.*;

@Controller
public class GreetingController {
	 
	 String emaindef ;

	 @RequestMapping("/index")
	  public String index(Model modelo) {    
	    modelo.addAttribute("holi","Juli");
	    return "index";
	  }
	 @RequestMapping("/register")
	  public String register(Model modelo) {    
	    modelo.addAttribute("n","Juli");
	    return "register";
	  }
	 @RequestMapping("/peliculas")
	  public String peliculas(Model modelo) {    
	    modelo.addAttribute("n","Juli");
	    return "peliculas";
	  }
	 @RequestMapping("/login")
	  public String login(Model modelo) { 
		 modelo.addAttribute("n","Juli");
	    return "login";
	  }
	 @RequestMapping("/aboutus")
	  public String aboutus(Model modelo) { 
		 modelo.addAttribute("n","Juli");
	    return "aboutus";
	  }
	 @RequestMapping("validator")
	  public ModelAndView getValidaLogin(HttpServletRequest req,HttpServletResponse resp,Model model ) {  
		 ModelAndView modelo = new ModelAndView();
		 String usuario = req.getParameter("email");
		 String password = req.getParameter("password");
		 String loginn = "Your Diego";
		 model.addAttribute("pruv", loginn);
		 Login l = new Login();
		 String x = Login.InicioSesion(usuario,password);
		 if (x == "UsuarioAutenticado") {
			 XML arch = new XML();
			 arch.create();
			 HashMap<String, User> Users = arch.read();
			 User CurrentUser = Users.get(usuario);
			 modelo.setViewName("peliculas");
			 model.addAttribute("name", CurrentUser.name);
			 List<MovieComparable> listapeliculas = l.TopMovies(CurrentUser.moviespq);
			 model.addAttribute("topmovi",listapeliculas);
			 List<SerieComparable> listaseries = l.TopSeries(CurrentUser.seriespq);
			 model.addAttribute("topseries",listaseries);


		 }
		 else {
			 model.addAttribute("mensaje",x);
			 modelo.setViewName("login");
		 }
	     return modelo;
	  }
	 @RequestMapping("Rvalidator")
	  public ModelAndView getValidaRegister(HttpServletRequest req, HttpServletResponse resp, Model model ) {  
		 ModelAndView modelo = new ModelAndView();
		 String username = req.getParameter("username");
		 String correo = req.getParameter("email");
		 String password = req.getParameter("password");
		 ArrayList<String> generos = new ArrayList<String>();		 
		 String favGenres [] = new String[] {"Action","Animation","Biography","Comedy","Crime","Documentary","Drama","Family","Fantasy","Adventure","Horror","History","Musical","Mystery","Romance","Sport","Sci-Fi","Thriller","War"};
		 for(int i = 0;i < favGenres.length; i++) {
				String generoactual = req.getParameter(favGenres[i]);
	            if(generoactual != null) {
				       generos.add(favGenres[i]);
				       
			 }
		     }
		 Login l = new Login();
		 String xr = Login.Registrar(username,correo,password,generos);
		 int r =(int) Math.floor(Math.random() * 9);
		 if (xr == "UsuarioAutenticado") {
			 XML arch = new XML();
			 arch.create();
			 HashMap<String, User> Users = arch.read();
			 User CurrentUser = Users.get(correo);
			 modelo.setViewName("peliculas");
			 model.addAttribute("name", CurrentUser.name);
			 model.addAttribute("random",r);
			 List<MovieComparable> listapeliculas = l.TopMovies(CurrentUser.moviespq);
			 model.addAttribute("topmovi",listapeliculas);
			 List<SerieComparable> listaseries = l.TopSeries(CurrentUser.seriespq);
			 model.addAttribute("topseries",listaseries);
			 
		 }
		 else {
			 model.addAttribute("mensage",xr);
			 modelo.setViewName("register");
		 }
	     return modelo;
	  }
	  //@RequestMapping("Getpelis")
	  //public String listar(Model model ) {  
		  //Login l = new Login();
		  //QueueArrayGeneric<MovieComparable> listapeliculas = l.topMovies(this.emaindef);
		  //model.addAttribute(listapeliculas);
	    //  return "peliculas";
	  //}
	  //@RequestMapping("Dartitulo")
	  //public String dtitulo(Model model ) {
		//  String loginn = "Your Diego";
		  //model.addAttribute("name",loginn);
	      //return "peliculas";
	  //}

	 

}
