package BusinessLogic;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Data.User;

public class XML{
    public void create(String email, String password, String nombre, String genres) { //Si no existe archivo usuarios
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "users", null);
            documento.setXmlVersion("1.0");
 
            Element allUsers = documento.createElement("all_users");
            Element user = documento.createElement("user");

            Element ema = documento.createElement("email");
            Text textEma = documento.createTextNode(email);
            ema.appendChild(textEma);
            user.appendChild(ema);
 
            Element pass = documento.createElement("password");
            Text textpass = documento.createTextNode(password);
            pass.appendChild(textpass);
            user.appendChild(pass);

            Element name = documento.createElement("name");
            Text textname = documento.createTextNode(nombre);
            name.appendChild(textname);
            user.appendChild(name);

            allUsers.appendChild(user);
 
            documento.getDocumentElement().appendChild(allUsers);
 
            Source source = new DOMSource(documento);
            
            Result result = new StreamResult(new File("users.xml"));
 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
 
        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
 
    }

    public HashMap<String, User> read() {
        try {
          HashMap<String, User> mapUsers = new HashMap<String, User>();
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("users.xml"));
            // Cojo todas las etiquetas coche del documento
            NodeList listaUser = documento.getElementsByTagName("user");
 
            // Recorro las etiquetas
            for (int i = 0; i < listaUser.getLength(); i++) {
                User u = new User();
                // Cojo el nodo actual
                Node nodo = listaUser.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < listaUser.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            if("email".equals(hijo.getNodeName())){
                              String em = hijo.getTextContent();
                            }else if("password".equals(hijo.getNodeName())){
                              u.setPassword(hijo.getTextContent());
                            }else{
                              u.setName(hijo.getTextContent());
                            }
                        }
                    }
                  mapUsers.put(em,u);
                }
            
            }
         return mapUsers;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
    public void write(){
      try {
        // 1. cargar el XML original
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("ruta/al/archivo.xml"));

        // 2. buscar y eliminar el elemento <enfermera id="3"> de entre 
        //    muchos elementos <enfermera> ubicados en cualquier posicion del documento
        NodeList items = doc.getElementsByTagName("enfermera");
        for (int ix = 0; ix < items.getLength(); ix++) {
            Element element = (Element) items.item(ix);
            // elejir un elemento especifico por algun atributo
            if (element.getAttribute("id").equalsIgnoreCase("3")) {
                // borrar elemento
                element.getParentNode().removeChild(element);
            }
        }
      
        // 3. Exportar nuevamente el XML
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("ruta/a/resultado.xml"));
        Source input = new DOMSource(doc);
        transformer.transform(input, output);

      } catch (ParserConfigurationException | SAXException | IOException ex | TransformerException ex) {
            System.out.println(ex.getMessage());
      }
    }*/
}