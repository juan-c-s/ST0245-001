import java.util.LinkedList;
import java.util.ArrayList;

public class ListaAdyacencia {
    private ArrayList<ArrayList<Pair>> lista;
    private int size;

    public ListaAdyacencia(int size) {
        lista = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            lista.add(new ArrayList<Pair>());
        }

    }

    public void addVertice(int origen, int destino, int weight) {

        if (lista.get(origen).size() == 0) {
            lista.add(new ArrayList<Pair>());
        }

        lista.get(origen).add(new Pair(destino, weight));
    }

    public ArrayList<Integer> getSucesores(int vertice) {
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        for (int i = 0; i < lista.get(vertice).size(); i++) {
            if (lista.get(vertice).get(i).peso != 0) {
                sucesores.add(lista.get(vertice).get(i).destino);
            }
        }
        return sucesores;
    }

    public int getWeight(int origen, int destino) {
        int peso = 0;
        for (int i = 0; i < lista.get(origen).size(); ++i) {
            if (lista.get(origen).get(i).destino == destino) {
                peso = lista.get(origen).get(i).peso;
            }
        }
        return peso;
    }
}
