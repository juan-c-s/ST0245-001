import java.util.Scanner;

public class Main {
    public static void main(String[] argumento) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Arbol ar = new Arbol();

        while (!str.isEmpty()) {
            ar.addNodo(Integer.parseInt(str));
            str = in.nextLine();
        }

        ar.printOrden();
    }
}
