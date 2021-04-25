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
	
	public static void mejores10(String gnder,NodeGeneric<T> primero){
		NodeGeneric<T> TEM = primero;
		LinkedListGeneric Best10 = new LinkedListGeneric();
		MovieComparable genericmovie = new MovieComparable(" "," "," ",gnder," ",0," ");
		Best10.insertarfirst(genericmovie);
		while (TEM.getNext()!= null){ 
		  if (TEM.getData().genders == gnder){
			NodeGeneric<T> num1 = Best10.getFirst();
			if(TEM.getData().average_rating>=num1.getData().average_rating){
			  Best10.insertarfirst(TEM.getData());
			}else{
			  Boolean condicional = true;
			  NodeGeneric<T> PRevv = num1;
			  num1 = num1.getNext();
			  while(condicional && num1 != null ){
				if(TEM.getData().average_rating>=num1.getData().average_rating){
					NodeGeneric<T> nuevo = new NodeGeneric();
					newn.setData(TEM.getData());
					newn.setNext(num1);
				    PRevv.setNext(nuevo);
				    condicional = false;
				}else{
				PRevv = PRevv.getNext();
				num1 = num1.getNext();
				}
			  }
			}
		  }
		  TEM = TEM.getNext();
		}
		
		
	  }

	

}
