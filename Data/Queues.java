import Data.*;

public class QueuesC {

    private int head=-1;
    private int tail=-1;
    private Serie Data[];
    private int max=10;

    public QueuesC(){
        Data=new Serie [max];
    }
    public boolean complete(){
        if(tail==max-1 && head==0 || tail+1==head){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean Empty(){
        if(tail==-1 && head==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void Push(Serie dato){

        if(Llena()==true){
            System.out.print("Overflow \n");
        }
        else{

            if(tail==max-1 && tail>0){
                tail=0;
                Data[tail]=dato;
            }
            else{
                tail++;
                Data[tail]=dato;
                head=0;
            }
            
        }
    }
    public void Pop(){
        if(Vacia()==true){
            System.out.print("Empty \n");
        }
        else{
            if(head==tail){
                head=-1;
                tail=-1;
            }
            else{
                head++;
            }
        }
        return aux;
    }
    public void printqueue(){
        for(int iCont=0; iCont<Data.length; iCont++){
			      System.out.println(i+"."+Data[iCont].getTitle()+".");
			      System.out.println("Director:"+Data[iCont].getDirector()+".");
			      System.out.println("Año:"+Data[iCont].getRelease_year()+".");
			      System.out.println("Genero:"+Data[iCont].getGenders()+".");
			      System.out.println("descripcion:"+Data[iCont].getDescription()+".");
			      System.out.println("Puntuacion:"+Data[iCont].getAverage_rating()+".");
        }
    }
}
