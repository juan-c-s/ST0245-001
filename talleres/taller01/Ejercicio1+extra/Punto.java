/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y
 * calcular su distancia.
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Punto {
    private double x;
    private double y;
    private double polarAngle;
    private double polarRadius;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.polarAngle = Math.atan(y / x);
        this.polarRadius = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distance(Punto otro) {
        double suma = Math.pow(otro.getX() - this.x, 2) + Math.pow(otro.getY() - this.y, 2);
        double raiz = Math.sqrt(suma);
        return raiz;
    }

    public double polarAngle() {
        return this.polarAngle;
    }

    public double polarRadius() {
        return this.polarRadius;
    }

}
