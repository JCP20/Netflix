package Data;

// Se creo este tipo de dato para clasificar los datos en series

public class SerieComparable extends Audiovisual implements Comparable<SerieComparable> {
	
	private String runtime;
	private String tittle;
	private double average_rating;
 
	// constructor
	public SerieComparable(String title, String director, String release_year, String genders, String description,
			double average_rating, String runtime) {
		super(title, director, release_year, genders, description, average_rating);
		
		this.runtime = runtime;
		this.average_rating = average_rating;
		this.tittle = title;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}
	

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
        
	// comparableto organiza los datos en las estructuras dependiendo de su puntuacion dada por la critica
	@Override
	public int compareTo(SerieComparable otherSerie) {
		
		
		int result;
		if(this.getTitle().charAt(0) < otherSerie.getTitle().charAt(0) && this.getTitle().charAt(this.getTitle().length()-1) < otherSerie.getTitle().charAt(otherSerie.getTitle().length()-1))
			result = -1;
		
		else
			if(this.getTitle().charAt(0) > otherSerie.getTitle().charAt(0) && this.getTitle().charAt(this.getTitle().length()-1) < otherSerie.getTitle().charAt(otherSerie.getTitle().length()-1))
				result = 1;
			else
				result = 0;
		
		
		return result;
		
		
		
	}
// compara las series	
public boolean equals(Object otherSerie) {
		
		SerieComparable otherSerieObject = (SerieComparable) otherSerie;
		
		 
		  
		return (this.tittle.contentEquals(otherSerieObject.getTitle()));
		
	}

@Override
	// retorna en un string todos los datos asociados 
public String toString() {
	return "SerieComparable [runtime=" + runtime + ", tittle=" + tittle + ", average_rating=" + average_rating
			+ ", getTitle()=" + getTitle() + ", getDirector()=" + getDirector() + ", getRelease_year()="
			+ getRelease_year() + ", getGenders()=" + getGenders() + ", getDescription()=" + getDescription()
			+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}



	
	
	
	
	

}
