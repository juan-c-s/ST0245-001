
public class Arbol {
    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int data, Nodo raizTemporal) {
        if (data < raizTemporal.data) {
            if (raizTemporal.izq == null) {
                raizTemporal.izq = new Nodo(data);
                return;
            } else if (raizTemporal.izq != null)
                insertar(data, raizTemporal.izq);
        } else if (data >= raizTemporal.data) {
            if (raizTemporal.der == null) {
                raizTemporal.der = new Nodo(data);
                return;
            } else if (raizTemporal.der != null)
                insertar(data, raizTemporal.der);
            return;
        }
    }

    public void insert(int data) {
        if (this.raiz == null)
            this.raiz = new Nodo(data);
        else
            insertar(data, this.raiz);
    }

    public void imprimir() {
    }

    public void imprimirArbol() {

    }

    public Boolean buscarData(int data, Nodo r) {
        if (r == null)
            return false;
        if (data == r.data) {
            return true;
        } else if (data < r.data) {
            return buscarData(data, r.izq);
        } else if (data > r.data) {
            return buscarData(data, r.der);
        } else {
            return true;
        }

    }

    public Boolean buscar(int data) {
        return buscarData(data, this.raiz);
    }

}