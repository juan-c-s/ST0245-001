
import java.util.ArrayList;

public class MatrizAdyacencia {

    private int size;
    private int[][] mA;

    public MatrizAdyacencia(int size) {
        this.size = size;
        this.mA = new int[size][size];
    }

    public ArrayList<Integer> getSucesores(int vertice) {
        ArrayList<Integer> sucesores = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            if (this.mA[vertice][i] != 0) {
                sucesores.add(i);
            }
        }
        return sucesores;
    }

    public void addArc(int origen, int destino, int weight) {
        mA[origen][destino] = weight;
    }

    public int getWeight(int origen, int destino) {
        return mA[origen][destino];
    }

}