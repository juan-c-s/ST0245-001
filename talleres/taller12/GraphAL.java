import java.util.ArrayList;

public class GraphAL extends Graph{

    private int[][] matrix;

    public GraphAL(int size){
        super(size);
        this.matrix = new int[this.size][this.size];
    }

    public void addArc(int origin,int destination,int weight){
        this.matrix[origin][destination] = weight;
    }
    public ArrayList<Integer> getSuccesor(int vertex){
        ArrayList<Integer> susesores = new ArrayList<Integer>();
        for(int tt = 0;tt<this.size;tt++){
            if(this.matrix[vertex][tt] != 0){
                susesores.add(tt);
            }
        }
        return susesores;
    }
    public  int getWeight(int origin,int destination){
        return this.matrix[origin][destination];
    }

    

}