import java.util.ArrayList;

public class Mapa {
    private int distancia;
    private ArrayList<Punto> mapa = new ArrayList<>();

    public Mapa() {
    }

    public void añadirPunto(Punto punto) {
        mapa.add(punto);
    }

    public int encontrarDistancia() {

        for (int i = 0; i < this.mapa.size() - 1; i++) {
            distancia += Math.sqrt(Math.pow(mapa.get(i + 1).getY() - mapa.get(i).getY(), 2)
                    + Math.pow(mapa.get(i + 1).getX() - mapa.get(i).getX(), 2));
        }
        return distancia;
    }

}
