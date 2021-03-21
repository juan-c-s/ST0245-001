import java.util.*;

public class Neveras {

    public static void main(String[] arg) {
        Stack<Pair> neveras = new Stack<>();
        neveras.push(new Pair(1, "haceb"));
        neveras.push(new Pair(2, "lg"));
        neveras.push(new Pair(3, "ibm"));
        neveras.push(new Pair(4, "haceb"));
        neveras.push(new Pair(5, "lg"));
        neveras.push(new Pair(6, "ibm"));
        neveras.push(new Pair(7, "haceb"));
        neveras.push(new Pair(8, "lg"));
        neveras.push(new Pair(9, "ibm"));
        neveras.push(new Pair(8, "lg"));
        neveras.push(new Pair(9, "ibm"));

        Stack<Pair> solicitudes = new Stack<>();
        solicitudes.push(new Pair("eafit", 10));
        solicitudes.push(new Pair("la14", 2));
        solicitudes.push(new Pair("olimpica", 4));
        solicitudes.push(new Pair("exito", 1));
        ejercicio2(neveras, solicitudes);
    }

    public static void ejercicio2(Stack<Pair> neveras, Stack<Pair> solicitudes) {
        while (solicitudes.size() != 0) {
            Pair indsolicitud = solicitudes.pop();
            int length = (Integer) indsolicitud.getValue();
            System.out.print("(\"" + indsolicitud.getKey() + "\", [");
            for (int i = 0; i < length && neveras.size() != 0; i++) {
                Pair indvNeveras = neveras.pop();
                System.out.print("(" + indvNeveras.getKey() + ", " + indvNeveras.getValue() + "), ");

            }
            System.out.println("])");
        }
    }

}
