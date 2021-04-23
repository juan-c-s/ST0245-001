import java.util.ArrayList;

public class Main {
    public static void main(String arg[]) {
        ListaAdyacencia lA = new ListaAdyacencia(10);
        lA.addVertice(0, 5, 1);
        lA.addVertice(0, 2, 1);
        lA.addVertice(0, 3, 1);
        lA.addVertice(0, 8, 1);
        ArrayList<Integer> sucesores = lA.getSucesores(0);
        System.out.println(sucesores.toString());
        System.out.println(lA.getWeight(0, 6));

    }

}
