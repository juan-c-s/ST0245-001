public class Tupla {
    private int moverseAtras;
    private int numeroElementos;
    private char letraSiguiente;

    public Tupla(int moverseAtras, int numeroElementos, char letraSiguiente) {
        this.moverseAtras = moverseAtras;
        this.numeroElementos = numeroElementos;
        this.letraSiguiente = letraSiguiente;
    }

    public String toString() {
        return "(" + moverseAtras + "," + numeroElementos + "," + letraSiguiente + ")";
    }
}
