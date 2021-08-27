package Data;

// clase madre de las series y las peliculas, incluye datos generales que todo producto de netflix ofrece

public class Audiovisual {
	
	private String title;
	private String director;
	private String release_year;
	private String genders;
	private String description;
	private double average_rating;
	// constructor basico
	public Audiovisual(String title, String director, String release_year, String genders, String description,
			double average_rating) {
		
		this.title = title;
		this.director = director;
		this.release_year = release_year;
		this.genders = genders;
		this.description = description;
		this.average_rating = average_rating;
	}
        // hay muchos datos que aun no cuentan con una puntuacion
	public Audiovisual(String title, String director, String release_year, String genders, String description
			) {
		
		this.title = title;
		this.director = director;
		this.release_year = release_year;
		this.genders = genders;
		this.description = description;
		
	}
	
	// setters y getters

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public String getRelease_year() {
		return release_year;
	}

	public String getGenders() {
		return genders;
	}

	public String getDescription() {
		return description;
	}

	public double getAverage_rating() {
		return average_rating;
	}

	// Retorna un string con todos los datos organizados, esto para luego ser imprmidos
	@Override
	public String toString() {
		return "Audiovisual [title=" + title + ", director=" + director + ", release_year=" + release_year
				+ ", genders=" + genders + ", description=" + description + ", average_rating=" + average_rating + "]";
	}
	
	
	
	
	
	

}
