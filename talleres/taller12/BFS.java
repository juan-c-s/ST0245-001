import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    private int start;
    private int end;
    private Graph graf;


    public BFS(int start,int end,Graph graf){
        this.start = start;
        this.end = end;
        this.graf = graf;
    }

    public boolean runBFS(){
        Queue<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[this.graf.size];
        list.add(this.start);

        while(list.size() != 0){
            System.out.print(list.peek() + " - ");
            if(list.peek() == this.end)return true;
            for(int susesor : this.graf.getSuccesor(list.peek())){
                if(!visited[susesor]){
                    list.add(susesor);
                    visited[susesor] = true;
                }
            }
            list.remove();
        }
        return false;
    }

    
    
}
