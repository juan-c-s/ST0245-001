public class Tree {

    public Node root;

    public void add(String name,Long cell){
        if(this.root == null){
            this.root = new Node(cell,name);
        }else{
            insert(new Node(cell,name),this.root);
        }
    }

    private void insert(Node newNode,Node currentNode){
        if(newNode.telefono < currentNode.telefono){
            if(currentNode.left == null){
                currentNode.left = newNode;
                return;
            }else{
                insert(newNode,currentNode.left);
            }
        }else{
            if(currentNode.right == null){
                currentNode.right = newNode;
            }else{
                insert(newNode,currentNode.right);
                return;
            }
        }
    }

    public String get(Long telefono){
        return this.serch(telefono,this.root);
    }

    private String serch(Long telefono,Node currentNode){
        if(currentNode == null){
            return "";
        }else if(currentNode.telefono == telefono){
            return currentNode.nombre;
        }

       
        if(telefono < currentNode.telefono){
            return serch(telefono, currentNode.left);
        }else{
            return serch(telefono, currentNode.right);
        }
    }

    
}
