package Data;

public class Serie extends Audiovisual {
	
	private String runtime;

	public Serie(String title, String director, String release_year, String genders, String description,
			double average_rating,String runtime) {
		super(title, director, release_year, genders, description, average_rating);
		
		this.runtime = runtime;
	}

	public String getRuntime() {
		return runtime;
	}

	@Override
	public String toString() {
		return "Serie [runtime=" + runtime + ", getTitle()=" + getTitle() + ", getDirector()=" + getDirector()
				+ ", getRelease_year()=" + getRelease_year() + ", getGenders()=" + getGenders() + ", getDescription()="
				+ getDescription() + ", getAverage_rating()=" + getAverage_rating() + "]";
	}
	
	
	

}
