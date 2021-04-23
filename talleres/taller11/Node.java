public class Node{

    public Node right;
    public Node left;
    public Long telefono;
    public String nombre;


    Node(Long telefono,String nombre){
        this.telefono = telefono;
        this.nombre = nombre;
        this.right = null;
        this.left = null;
    }
}