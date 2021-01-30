public class Main {
    public static void main(String[] argumento) {
        Punto primerPunto = new Punto(0.1, 0.0);
        Punto segundoPunto = new Punto(3.0, 3.0);

        Line2D segmento = new Line2D(primerPunto, segundoPunto);


        System.out.println("Intecepto: " + segmento.getInterceptoY());
        System.out.println("Pendiente: " + segmento.getPendiente());
        System.out.println(segmento.toString(segmento.middleCoordinates()));
        Punto tercerPunto = new Punto(6.0, 4.0);
        Mapa listaPuntos = new Mapa();

        listaPuntos.añadirPunto(primerPunto);
        listaPuntos.añadirPunto(segundoPunto);
        listaPuntos.añadirPunto(tercerPunto);
        System.out.println(listaPuntos.encontrarDistancia());

    }
}
