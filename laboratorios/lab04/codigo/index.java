import java.util.ArrayList;

public class index {



    
    public static void main(String[] args) {

       Reader.Read("./data.txt");
        Reader.findBounds();

        System.out.println("maxLatitud: " + Reader.maxLatitud);
        System.out.println("minLatitud: " +Reader.minLatitud);
        System.out.println("maxLongitu: " +Reader.maxLongitud);
        System.out.println("minLongitud: " +Reader.minLongitud);
        System.out.println("maxAltura: " +Reader.maxAltura);
        System.out.println("minAltura: " +Reader.minAltura);

    

        Tree ntree = new Tree(Reader.abejas,Reader.maxLatitud,Reader.minLatitud,Reader.maxLongitud,Reader.minLongitud,Reader.maxAltura,Reader.minAltura);
        //Tree ntree = new Tree(Reader.abejas,-68,-80,9,-2,1800,1311.05);
        System.out.println("-------");
        ntree.createTree();

       
    }
    

}
