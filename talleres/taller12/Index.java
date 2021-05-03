import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class Index {

    public static void main(String[] args) {

        GraphAL g = new GraphAL(4);
        g.addArc(0,2,100);
        g.addArc(0,1,110);
        g.addArc(1,3,110);
        g.addArc(3,2,110);

        DFS algoD = new DFS(0,3,g);
        System.out.println(algoD.runDFS());

        System.out.println("---");

        GraphLS l = new GraphLS(4);

        l.addArc(1,0,100);
        l.addArc(2,0,100);
        l.addArc(3,0,100);
        l.addArc(0,2,100);

        BFS algoB = new BFS(1,2,l);
        System.out.println(algoB.runBFS());

    }
    
}
