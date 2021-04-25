package Data;

public class MovieComparable extends Audiovisual implements Comparable<MovieComparable> {
	
	
	private int runtime;
	private double average_rating;

	public MovieComparable(String title, String director, String release_year, String genders, String description,
			double average_rating,int runtime) {
		
		super(title, director, release_year, genders, description);
		
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
		return "Movie [runtime=" + runtime + ", getTitle()=" + getTitle() + ", getDirector()=" + getDirector()
				+ ", getRelease_year()=" + getRelease_year() + ", getGenders()=" + getGenders() + ", getDescription()="
				+ getDescription() + ", getAverage_rating()=" + getAverage_rating() + "]";
	}



	@Override
	public int compareTo(MovieComparable otherMovie) {
		
		int result;
		if(this.average_rating < otherMovie.getAverage_rating())
			result = -1;
		
		else
			if(this.average_rating > otherMovie.getAverage_rating())
				result = 1;
			else
				result = 0;
		
		
		return result;
	}
	
	public boolean equals(Object otherMovie) {
		
		MovieComparable otherMovieObject = (MovieComparable) otherMovie;
		
		return(average_rating == otherMovieObject.getAverage_rating() );
		
	}
	


	

}
