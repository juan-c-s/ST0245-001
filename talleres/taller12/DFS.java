import java.util.ArrayList;

public class DFS {

    private int start;
    private int end;
    private Graph graf;


    public DFS(int start,int end,Graph graf){
        this.start = start;
        this.end = end;
        this.graf = graf;
    }

    public boolean runDFS(){
        return runDFSRecursion(this.start,new boolean[this.graf.size]);
    }

    private boolean runDFSRecursion(int current,boolean[] visited){
        if(current == this.end){
            return true;
        }
        System.out.print(current + " - ");
        visited[current] = true;
        for(int sucessor : this.graf.getSuccesor(current)){
            if(!visited[sucessor]){
                if(runDFSRecursion(sucessor,visited)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
}
