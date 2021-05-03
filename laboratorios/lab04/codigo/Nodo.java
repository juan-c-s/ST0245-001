import java.util.ArrayList;

public class Nodo{

    public ArrayList<Bee> Abejas = new ArrayList<>();
    public double maxLatitud;
    public double maxLongitud;
    public double maxAltura;
    public double minLongitud;
    public double minLatitud;
    public double minAltura;

    public Nodo first;
    public Nodo second;
    public Nodo third;
    public Nodo fourth;

    public Nodo fifth;
    public Nodo sixth;
    public Nodo seventh;
    public Nodo eighth;

    public Nodo(double maxLatitud,double minLatitud,double maxLongitud ,double minLongitud,double maxAltura, double minAltura){
        this.maxLongitud = maxLongitud;
        this.minLongitud = minLongitud;
        this.minAltura = minAltura;
        this.maxAltura = maxAltura;
        this.maxLatitud = maxLatitud;
        this.minLatitud = minLatitud;   
      

    }

    public void addAbejas(ArrayList<Bee> abejas){
        this.Abejas = abejas;
    }

    public void printAbejas(){
        for(int tt = 0; tt < Abejas.size();tt++){
            System.out.println(Abejas.get(tt).latitud + " , " + Abejas.get(tt).longitud + " , " + Abejas.get(tt).altura);
        }

    }


}