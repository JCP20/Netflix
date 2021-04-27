package Data;

// En esta clase se definen los objetos movies de esta manera para asi clasificar los datos mas rapidamente.

public class MovieComparable extends Audiovisual implements Comparable<MovieComparable> {
	
	
	private int runtime;
	private double average_rating;
	private String tittle;
        // constructor
	public MovieComparable(String title, String director, String release_year, String genders, String description,
			double average_rating,int runtime) {
		
		super(title, director, release_year, genders, description);
		
		this.tittle = title;
		this.average_rating = average_rating;
		this.runtime = runtime;
		
		
	}

	// getters y setters 
	public int getRuntime() {
		return runtime;
	}


	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	

	public double getAverage_rating() {
		return average_rating;
	}


	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}


	@Override
	public String toString() {
		return  "Pelicula: "+this.tittle+
				"\nDescripcion: "+this.getDescription();
	}

 

	// se comparan las peliculas segun su puntuacion pra asi organizarlas en las diferentes estructuras
	@Override
	public int compareTo(MovieComparable otherMovie) {
		
		int result;
		if(this.getTitle().charAt(0) < otherMovie.getTitle().charAt(0) && this.getTitle().charAt(this.getTitle().length()-1) < otherMovie.getTitle().charAt(otherMovie.getTitle().length()-1))
			result = -1;
		
		else
			if(this.getTitle().charAt(0) > otherMovie.getTitle().charAt(0) && this.getTitle().charAt(this.getTitle().length()-1) < otherMovie.getTitle().charAt(otherMovie.getTitle().length()-1))
				result = 1;
			else
				result = 0;
		
		
		return result;
	}
	
	// revisa si se esta tratando de las mismas peliculas
	public boolean equals(Object otherMovie) {
		
		MovieComparable otherMovieObject = (MovieComparable) otherMovie;
		
		return(this.tittle.contentEquals(otherMovieObject.getTitle()));
		
	}
	
	
	

}
