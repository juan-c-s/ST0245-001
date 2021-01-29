import java.util.ArrayList;

public class Line2D {
    private ArrayList<Punto> coordenadas = new ArrayList<>();
    private Punto one;
    private Punto two;
    private double intercepto;
    private double distance;
    private double pendiente;

    public Line2D(Punto one, Punto two) {
        this.one = one;
        this.two = two;
    }

    public double getPendiente() {
        return pendiente;
    }

    public double getInterceptoY() {
        return intercepto;
    }

    public double getDistance() {
        return distance = one.distance(two);
    }

    public void setPendiente() {
        pendiente = (two.getY() - one.getY()) / (two.getX() - one.getX());
    }

    public void setInterceptoY() {
        intercepto = (-1.0 * pendiente * one.getX()) + one.getY();
    }

    // y=mx+b
    // y-y1=m(x-x1)
    public ArrayList<Punto> middleCoordinates() {
        for (int i = 0; i <= two.x; i++) {
            coordenadas.add(new Punto(i, (this.pendiente * i) + intercepto));
        }
        return coordenadas;
    }

    public String toString(ArrayList<Punto> n) {
        String message = "";
        for (int i = 0; i < n.size(); i++) {
            message += "[" + n.get(i).getX() + ", " + n.get(i).getY() + "]";
        }
        return message;
    }

    public boolean isDistanceGreater(Line2D linea) {
        if (this.distance > linea.getDistance()) {
            return true;
        } else
            return false;
    }

}
