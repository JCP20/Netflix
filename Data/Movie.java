package Data;

public class Movie extends Audiovisual {
	
	private int runtime;

	public Movie(String title, String director, String release_year, String genders, String description,
			double average_rating,int runtime) {
		super(title, director, release_year, genders, description, average_rating);
		this.runtime = runtime;
		
	}

	public int getRuntime() {
		return runtime;
	}

	@Override
	public String toString() {
		return "Movie [runtime=" + runtime + ", getTitle()=" + getTitle() + ", getDirector()=" + getDirector()
				+ ", getRelease_year()=" + getRelease_year() + ", getGenders()=" + getGenders() + ", getDescription()="
				+ getDescription() + ", getAverage_rating()=" + getAverage_rating() + "]";
	}


	
	
	

}
