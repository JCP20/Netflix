package Data;

public class SerieComparable extends Audiovisual implements Comparable<SerieComparable> {
	
	private String runtime;
	private String tittle;
	private double average_rating;
	private int idimagen;

	public SerieComparable(String title, String director, String release_year, String genders, String description,
			double average_rating, String runtime) {
		super(title, director, release_year, genders, description, average_rating);
		
		this.runtime = runtime;
		this.average_rating = average_rating;
		this.tittle = title;
		this.idimagen =(int) Math.floor(Math.random() * 9);
	}

	public int getIdimagen() {
		return idimagen;
	}

	public void setIdimagen(int idimagen) {
		this.idimagen = idimagen;
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
		
		Double s1 = Double.valueOf(this.getAverage_rating());
		Double s2 = Double.valueOf(otherSerie.getAverage_rating());
		
		
		int result;
		if(s1.compareTo(s2)<0)
			result = -1;
		
		else
			if(s1.compareTo(s2)>0)
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
	return  this.runtime+";;"+this.tittle +";;"+this.getDirector()+";;"+this.getRelease_year()+";;"+this.getGenders() +";;"+this.getDescription()+";;"+this.average_rating+"\n";
}



	
	
	
	
	

}
