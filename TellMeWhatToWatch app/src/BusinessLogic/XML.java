package BusinessLogic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import Data.HashMapGeneric;
import Data.User;

public class XML{
   
	public void create() { //Si no existe archivo usuarios
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "users", null);
            documento.setXmlVersion("1.0");
            
 
            Element allUsers = documento.createElement("all_users"); 
            documento.getDocumentElement().appendChild(allUsers);
 
            Source source = new DOMSource(documento);
            
            if(!(new File ("users.xml")).exists()) {
            	Result result = new StreamResult(new File("users.xml"));
            	Transformer transformer = TransformerFactory.newInstance().newTransformer();
              transformer.transform(source, result);
            }
            
    
 
        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
 
    }

    public HashMapGeneric<User> read() {
      HashMapGeneric<User> mapUsers = new HashMapGeneric<User>();
        try {
        	
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("users.xml"));
            // Cojo todas las etiquetas coche del documento
            NodeList listaUser = documento.getElementsByTagName("user");
            
            String email ="";
            String name ="";
            String seriespq="";
            String password="";
            String moviespq ="";
            
           
            // Recorro las etiquetas
            for (int i = 0; i < listaUser.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaUser.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                       
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            if("email".equals(hijo.getNodeName())){
                              email = hijo.getTextContent();
                              
                              
                            }
                            else if("password".equals(hijo.getNodeName())){
                              password=(hijo.getTextContent());
                            }else if("name".equals(hijo.getNodeName())){
                              name=(hijo.getTextContent());
                            }
                            else if("topMovies".equals(hijo.getNodeName())){
                            
                            moviespq=(hijo.getTextContent());
                            
                            	
                            }
                            else {
                            	
                            	seriespq = hijo.getTextContent();
                            	
                            }
                        }
                    }
                   User u = new User( name, password, email, moviespq,seriespq);
                   
                  mapUsers.put(email,u);
                }
            
            }
         return mapUsers;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return mapUsers;
    }

    public void write(User u){
      try {
        // 1. cargar el XML original
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        Document documento = db.parse(new File("users.xml"));
        documento.getDocumentElement().normalize();

        //Creamos un nuevo elemento en la casa
        Element user = documento.createElement("user");
        //Le añadimos una característica
        Element ema = documento.createElement("email");
        Text textEma = documento.createTextNode(u.getEmail());
        ema.appendChild(textEma);
        user.appendChild(ema);
        

        Element pass = documento.createElement("password");
        Text textpass = documento.createTextNode(u.getPassword());
        pass.appendChild(textpass);
        user.appendChild(pass);

        Element name = documento.createElement("name");
        Text textname = documento.createTextNode(u.getName());
        name.appendChild(textname);
        user.appendChild(name);
        
        Element topMovies = documento.createElement("topMovies");
        Text textTopMovies = documento.createTextNode(u.getMoviespq());
        topMovies.appendChild(textTopMovies);
        user.appendChild(topMovies);
        
        Element topSeries = documento.createElement("topSeries");
        Text textTopSeries = documento.createTextNode(u.getSeriespq());
        topSeries.appendChild(textTopSeries);
        user.appendChild(topSeries);
        
        //Añadimos la información a la casa ya existente
        NodeList nodoRaiz = documento.getDocumentElement().getElementsByTagName("all_users");
        nodoRaiz.item(0).appendChild(user);

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File("users.xml"));
    	  Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        

        
      } catch (ParserConfigurationException e) {
          e.printStackTrace();
      } catch (SAXException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (TransformerConfigurationException e) {
        e.printStackTrace();
      } catch (TransformerFactoryConfigurationError e) {
        e.printStackTrace();
      } catch (TransformerException e) {
        e.printStackTrace();
      }
    }
}