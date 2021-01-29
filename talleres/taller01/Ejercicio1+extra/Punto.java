/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y
 * calcular su distancia.
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Punto {
    double x;
    double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
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
        return Math.atan(this.y / this.x);
    }

    public double polarRadius() {
        return Math.sqrt(Math.pow(this.x - 0, 2) + Math.pow(this.y - 0, 2));
    }

}
