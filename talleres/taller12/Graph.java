import java.util.ArrayList;

public abstract class Graph{

    protected int size;

    public Graph(int vertecies){
        this.size = vertecies;
    }

    public abstract void addArc(int source,int destination,int weight);
    public abstract ArrayList<Integer> getSuccesor(int vertex);
    public abstract int getWeight(int origin,int destination);
    public int getSize(){
        return this.size;
    }


}