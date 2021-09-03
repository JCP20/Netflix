package com.example.servingwebcontent;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 Login l = new Login();
		 String x = l.InicioSesion(usuario,password);
		 if (x == "UsuarioAutenticado") {
			 modelo.setViewName("peliculas");
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
		 String favGenres [] = new String[] {"Action","Animation","Biography","Comedy","Crime","Documentary","Drama","Family","Fantasy","Adventure","Horror","History","Musical","Mystery","Romance","Reality-TV","Sport","Sci-Fi","Short","Thriller","War"};
		 for(int i = 0;i < favGenres.length; i++) {
				String generoactual = req.getParameter(favGenres[i]);
	            if(generoactual != null) {
				       generos.add(favGenres[i]);
				       
			 }
		     }
		 Login l = new Login();
		 String xr = l.Registrar(username,correo,password,generos);
		 if (xr == "UsuarioAutenticado") {
			 modelo.setViewName("peliculas");
		 }
		 else {
			 model.addAttribute("mensage",xr);
			 modelo.setViewName("register");
		 }
	     return modelo;
	  }	 

}
