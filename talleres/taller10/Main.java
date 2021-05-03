public class Main {
    public static void main(String[] argumeto) {
        Arbol newArbol = new Arbol();
        newArbol.insert(5);
        newArbol.insert(1);
        newArbol.insert(3);
        System.out.println(newArbol.buscar(4));
    }
}