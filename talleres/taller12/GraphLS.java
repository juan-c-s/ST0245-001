import java.util.ArrayList;
import java.util.LinkedList;

public class GraphLS extends Graph{

    public ArrayList<LinkedList<Pair>> nodo;
    

    public GraphLS(int size){
        super(size);
        this.nodo = new ArrayList<>();
        for(int tt = 0;tt < this.size;tt++){
            this.nodo.add(new LinkedList<>());
        }
    }

    public void addArc(int source,int destination,int weight){
        this.nodo.get(source).add(new Pair(destination,weight));

    }
    public ArrayList<Integer> getSuccesor(int vertex){
        ArrayList<Integer> susesores = new ArrayList<>();
        
        for(Pair tupla : this.nodo.get(vertex)){
          
            susesores.add(tupla.getKey());
        }
        return susesores;
    }
    public int getWeight(int origin,int destination){
        for(Pair tupla : this.nodo.get(origin)){
            if(tupla.getKey() == destination){
                return tupla.getValue();
            }
        }
        return -1;
    }



}