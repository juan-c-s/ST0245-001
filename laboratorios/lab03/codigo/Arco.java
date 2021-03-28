public class Arco{

    public Verteci ver1;
    public Verteci ver2;
    public long idver1;
    public long idver2;
    public double distancia;
    public String nombre;

    public Arco(Verteci ver1, Verteci ver2,long idver1,long idver2, double distancia, String nombre){
        this.ver1 = ver1;
        this.ver2 = ver2;
        this.idver1 = idver1;
        this.idver2 = idver2;
        this.distancia = distancia;
        this.nombre = nombre;

    }

}