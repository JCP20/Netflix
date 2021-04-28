package Data;

public class SerieComparable extends Audiovisual implements Comparable<SerieComparable> {
	
	private String runtime;
	private String tittle;
	private double average_rating;

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
	
public boolean equals(Object otherSerie) {
		
		SerieComparable otherSerieObject = (SerieComparable) otherSerie;
		
		 
		  
		return (this.tittle.contentEquals(otherSerieObject.getTitle()));
		
	}

@Override
public String toString() {
	return "Serie: " + this.tittle + "\n"
			+ "Descripcion: "+ this.getDescription()+"\n\n";
}



	
	
	
	
	

}
