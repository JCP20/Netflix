package Data;

public class MovieComparable extends Audiovisual implements Comparable<MovieComparable> {
	
	
	private int runtime;
	private double average_rating;
	private String tittle;

	public MovieComparable(String title, String director, String release_year, String genders, String description,
			double average_rating,int runtime) {
		
		super(title, director, release_year, genders, description);
		
		this.tittle = title;
		this.average_rating = average_rating;
		this.runtime = runtime;
		
		
	}

	
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
		return  this.runtime+";;"+this.tittle +";;"+this.getDirector()+";;"+this.getRelease_year()+";;"+this.getGenders() +";;"+this.getDescription()+";;"+this.average_rating+"\n";
	}



	@Override
	public int compareTo(MovieComparable otherMovie) {
		
		int result;
		Double m1 = Double.valueOf(this.getAverage_rating());
		Double m2 = Double.valueOf(otherMovie.getAverage_rating());
		
		if(m1.compareTo(m2)<0)
			result = -1;
		
		else
			if(m1.compareTo(m2)>0)
				result = 1;
			else
				result = 0;
		
		
		return result;
	}
	
	public boolean equals(Object otherMovie) {
		
		MovieComparable otherMovieObject = (MovieComparable) otherMovie;
		
		return(this.tittle.contentEquals(otherMovieObject.getTitle()));
		
	}
	
	
	

}
