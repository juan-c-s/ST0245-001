public class Arbol {
    private Nodo main;

    public Arbol() {
        this.main = null;
    }

    public void String() {
        toString(this.main);
    }

    public void toString(Nodo curr) {
        if (curr == null) {
            return;
        } else {
            toString(curr.der);
            toString(curr.izq);

            System.out.println(curr.data);
        }
    }

    public void addNodo(int data) {
        if (this.main == null) {
            main = new Nodo(data);
        } else
            addNodo(this.main, data);
    }

    public void printOrden() {
        printOrden(this.main);
    }

    public void printOrden(Nodo curr) {
        if (curr == null) {
            return;
        } else {
            printOrden(curr.izq);
            printOrden(curr.der);
            System.out.println(curr.data);
        }
    }

    public void addNodo(Nodo curr, int data) {
        if (curr == null) {
            curr = new Nodo(data);
        } else if (data < curr.data) {
            if (curr.izq == null) {
                curr.izq = new Nodo(data);
                return;
            } else
                addNodo(curr.izq, data);
        } else if (data >= curr.data) {
            if (curr.der == null) {
                curr.der = new Nodo(data);
                return;
            } else
                addNodo(curr.der, data);

        }
    }
}