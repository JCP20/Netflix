# TellMeWhatToWatch

<p align="center">
<img src="./Logos/TellMeWhatToWatch-logos_black.png" width="500" height="500" class="center">
 </p>
 
 Netflix y otras plataformas de streaming han sido de gran importancia en la última década, puesto que cada vez son más los usuarios que se unen a estas plataformas.
Sin embargo, esto genera un problema, ya que al usuario sólo se le recomiendan películas o series que son populares o similares al contenido que ha consumido anteriormente, quitándole la oportunidad de encontrar producciones nuevas que potencialmente serían de su gusto. 

Debido a que la plataforma no ofrecería este servicio, surge la necesidad de que el usuario conozca todo el contenido disponible para poder escoger producciones audiovisuales diferentes. Aun así, hay miles de películas y series en estas plataformas, haciendo que sea muy difícil que el usuario busque estas producciones manualmente. Por esto, es indispensable organizar esta información para que sea más accesible y no represente una tarea adicional para el usuario.

# Base de datos

<p align="center">
<img src="./Logos/netflix.png" class="center">
 </p>
 
Se construyó la base de datos a partir de la reconocida plataforma de entretimiento [Netflix](https://www.netflix.com/co/), Netflix es un servicio de streaming por suscripción que les permite a sus miembros ver series y películas, e [IMDb](https://www.imdb.com/), Internet Movie DataBase, o IMDB según las siglas por las que es internacionalmente conocida, es la más importante base de datos de cine y televisión del mundo..Primeramente se tomaron tanto las peliculas como las series de Netflix y prosteriormente a cada pelicula y serie se les adjunto un puntaje obtenido de IMDb.

# IDE(Entorno de Desarrollo Integrado)

<p align="center">
<img src="./Logos/eclipse.png" class="center">
 </p>

Se utlizó como IDE de preferencia para realizar la aplicación -> [Eclipse](https://www.eclipse.org/downloads/)

# Aplicación

<p align="center">
<img src="./Logos/java_logo.png" class="center">
 </p>
 
Para construir la aplicación de recomendación de peliculas y series, se utlizó el lenguaje de programación Java, debido a sus buenas propiedades para manejar objetos y clases en programación.La aplicación se construyó de la siguiente manera, hay 3 paquetes:
 - Paquete encargado de la lógica del negocio denominado [Business Logic](./TellMeWhatToWatch%20app/src/BusinessLogic), dentro de este paquete hay 4 clases:
<p align="center">
<img src="./Logos/business.png" height = 300 width = 300 class="center">
 </p>

   - Clase [Archive](./TellMeWhatToWatch%20app/src/BusinessLogic/Archive.java) -> Clase encargada de cargar la base de datos y manipularla para que otras clases la puedan utilizar.
   - Clase [Login](./TellMeWhatToWatch%20app/src/BusinessLogic/Login.java) -> Clase encargada del inicio de sesión del usuario.
   - Clase [Runner](./TellMeWhatToWatch%20app/src/BusinessLogic/Runner.java) -> Clase 'Main' del programa, es decir, donde se ejecuta.
   - Clase [XML](./TellMeWhatToWatch%20app/src/BusinessLogic/XML.java) -> Clase encargada del manejo de etiquetas XML para guardar la información de cada usuario.

- Paquete encargado de los datos denominado [Data](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java), dentro de este parquete hay 9 clases:
<p align="center">
<img src="./Logos/data.png" height = 300 width = 300 class="center">
 </p>


  - Clase [Audiovisual](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/Audiovisual.java) -> Clase madre de las clases MovieComparable y SerieComparable.
  - Clase [MovieComparable](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/MovieComparable.java) -> Clase que modela una pelicula con sus atributos.
  - Clase [SerieComparable](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/SerieComparable.java) -> Clase que modela una serie, un show de TV o un documental con sus atributos.
  - Clase [LinkedListGeneric](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/LinkedListGeneric.java) -> Clase que modela una lista enlazada generica.
  - Clase [NodeGeneric](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/NodeGeneric.java) -> Clase que modela un nodo generico, esta clase es utilizada por la clase LinkedListGeneric.
  - Clase [PriorityQueue](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/PriorityQueue.java) -> Clase que modela una cola prioritaria, mas especificamente un Max Heap, esta clase es la encargada de recomendar peliculas y/o series.
  - Clase [QueueArrayGeneric](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/QueueArrayGeneric.java) -> Clase encargada de modelar una cola generica, esta clase es usada para almacenar las series, documentales y shows de TV.
  - Clase [StackArrayGeneric](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/StackArrayGeneric.java) -> Clase encargada de modelar una pila generica, esta clase es usada para almancenar las peliculas.
  - Clase [User](./TellMeWhatToWatch%20app/src/BusinessLogic/Data.java/User.java) -> CLase encargada de modelar un Usuario de la aplicación.

- Paquete encargado de la interfaz gráfica denominado [UI]((./TellMeWhatToWatch%20app/src/UI.java).



# Miembros del equipo

<p align="center">
<img src="./Logos/team.png" class="center">
 </p>



 - Juliana Cardozo - Estudiante Ingenieria de Sistemas UNAL.
 - Diego Malagón - Estudiante Ingenieria Mecatronica UNAL.
 - Laura Castiblanco - Estudiante Ingenieria de Sistemas UNAL.
 - Andrés Perez -  Estudiante Ingenieria Mecatronica UNAL.
 - Oscar Rodriguez - Estudiante Ciencias de la computación UNAL.  

  
  
  









