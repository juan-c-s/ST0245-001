import java.util.ArrayList;


public class Tree {

    public Nodo main; 

    

    public Tree(ArrayList<Bee> abejas,double maxLatitud, double minLatitud,double maxLongitud,double minLongitud,double maxAltura,double minAltura){
        this.main = new Nodo(maxLatitud,minLatitud,maxLongitud,minLongitud,maxAltura,minAltura);
        this.main.addAbejas(abejas);
        
    }

    public void createTree(){
        createTree(this.main);
    }

    private void createTree(Nodo currentNode){
        if(currentNode.Abejas.size() < 2){
            return;
        }
        //System.out.println(distanceM.distance(currentNode.maxLatitud,currentNode.minLatitud,currentNode.maxLongitud,currentNode.minLongitud,currentNode.maxAltura,currentNode.minAltura));
        if(distanceM.distance(currentNode.maxLatitud,currentNode.minLatitud,currentNode.minLongitud,currentNode.maxLongitud,currentNode.maxAltura,currentNode.minAltura) <= 100){
            System.out.println(distanceM.distance(currentNode.maxLatitud,currentNode.minLatitud,currentNode.maxLongitud,currentNode.minLongitud,currentNode.maxAltura,currentNode.minAltura));
            currentNode.printAbejas();
            System.out.println("-------");
            return;
        }

        
        Nodo upperLeft = new Nodo(currentNode.maxLatitud,(currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.maxLongitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,(currentNode.maxAltura+currentNode.minAltura)/2.0,currentNode.minAltura);
        fillBeeList(upperLeft,currentNode.Abejas);
        Nodo lowerLeft = new Nodo((currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.minLatitud,currentNode.maxLongitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,(currentNode.maxAltura+currentNode.minAltura)/2.0,currentNode.minAltura);
        fillBeeList(lowerLeft,currentNode.Abejas);
        Nodo upperRigth = new Nodo(currentNode.maxLatitud,(currentNode.maxLatitud + currentNode.minLatitud)/2.0,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.minLongitud,(currentNode.maxAltura+currentNode.minAltura)/2.0,currentNode.minAltura);
        fillBeeList(upperRigth,currentNode.Abejas);
        Nodo lowerRight = new Nodo((currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.minLatitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.minLongitud,(currentNode.maxAltura+currentNode.minAltura)/2.0,currentNode.minAltura);
        fillBeeList(lowerRight,currentNode.Abejas);

        currentNode.first = upperLeft;
        currentNode.second = lowerLeft;
        currentNode.third = upperRigth;
        currentNode.fourth = lowerRight;


        Nodo upperLeft2 = new Nodo(currentNode.maxLatitud,(currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.maxLongitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.maxAltura,(currentNode.maxAltura+currentNode.minAltura)/2.0);
        fillBeeList(upperLeft2,currentNode.Abejas);
        Nodo lowerLeft2 = new Nodo((currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.minLatitud,currentNode.maxLongitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.maxAltura,(currentNode.maxAltura+currentNode.minAltura)/2.0);
        fillBeeList(lowerLeft2,currentNode.Abejas);
        Nodo upperRigth2 = new Nodo(currentNode.maxLatitud,(currentNode.maxLatitud + currentNode.minLatitud)/2.0,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.minLongitud,currentNode.maxAltura,(currentNode.maxAltura+currentNode.minAltura)/2.0);
        fillBeeList(upperRigth2,currentNode.Abejas);
        Nodo lowerRight2 = new Nodo((currentNode.maxLatitud + currentNode.minLatitud)/2.0,currentNode.minLatitud,(currentNode.maxLongitud+currentNode.minLongitud)/2.0,currentNode.minLongitud,currentNode.maxAltura,(currentNode.maxAltura+currentNode.minAltura)/2.0);
        fillBeeList(lowerRight2,currentNode.Abejas);

        currentNode.fifth = upperLeft2;
        currentNode.sixth = lowerLeft2;
        currentNode.seventh = upperRigth2;
        currentNode.eighth = lowerRight2;

        createTree(upperLeft);
        createTree(lowerLeft);
        createTree(upperRigth);
        createTree(lowerRight);

        createTree(upperLeft2);
        createTree(lowerLeft2);
        createTree(upperRigth2);
        createTree(lowerRight2);

    }

    public void fillBeeList(Nodo currentNode,ArrayList<Bee> Abejas){

        for(int tt = 0;tt < Abejas.size();tt++){
            if(
                (Abejas.get(tt).latitud >= currentNode.minLatitud) && (Abejas.get(tt).latitud <= currentNode.maxLatitud) &&
                (Abejas.get(tt).longitud >= currentNode.minLongitud) && (Abejas.get(tt).longitud <= currentNode.maxLongitud) &&
                (Abejas.get(tt).altura >= currentNode.minAltura) && (Abejas.get(tt).altura <= currentNode.maxAltura)
            ){
                currentNode.Abejas.add(Abejas.get(tt));
            }
        }
    }

}
