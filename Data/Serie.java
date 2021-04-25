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
	public static void mejores10(String gnder,NodeGeneric<T> primero){
		NodeGeneric<T> TEM = primero;
		LinkedListGeneric Best10 = new LinkedListGeneric();
		Serie genericserie = new Serie(" "," "," ",gnder," ",0," ");
		Best10.insertarfirst(genericserie);
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
