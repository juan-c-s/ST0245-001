
import java.util.ArrayList;

public class Lzz7{

    public int[] phtoValues;
    public ArrayList<Triple> encodedValues;
    private int serchBack;
    private int serchFront; 

   

    public Lzz7(int[] phtoValues, int serchBack, int serchFront){
        this.phtoValues = phtoValues;
        this.encodedValues = new ArrayList<>();
        this.serchFront = serchFront;
        this.serchBack = serchBack;
        encodeLZ();
    }

    public int[] decompress() {
        int[] decompressed = new int[this.phtoValues.length];
        for (int i = 0; i < this.encodedValues.size(); ++i) {
            Triple currTupla = encodedValues.get(i);
            int moverAtras = currTupla.first;
            int numerosPorCojer = currTupla.second;
            int proxNumero = currTupla.third;
            int empieza = i - moverAtras;
            for (int j = 0; j < numerosPorCojer; j++) {
                decompressed[i] = decompressed[empieza + j];
                System.out.println("Decompressed: " + decompressed[i]);
                i++;
            }
            decompressed[i] = proxNumero;
        }

        return decompressed;
    }

    public void encodeLZ(){

        int contador = 0;

        while(contador < this.phtoValues.length){
            ArrayList<Integer> lookBack = new ArrayList<>();
            ArrayList<Integer> lookFront = new ArrayList<>();

            addBackList(lookBack,contador);
            addFrontList(lookFront,contador);

            Triple result = serch(lookBack,lookFront);
            

            if(result.first == 0 || result.second == 0){
                this.encodedValues.add(new Triple(0,0,result.third));
                contador++;
            }else{
                this.encodedValues.add(result);
                contador = contador + result.second + 1;
            }
            
        }

    }

    private void addBackList(ArrayList<Integer> l,int contador){

        if(contador < this.serchBack){
            for(int tt = 0; tt < contador;tt++){
                l.add(this.phtoValues[tt]);
            }
            
        }else{
            for(int tt = 0; tt < this.serchBack; tt++){ 
                l.add(this.phtoValues[(contador-this.serchBack)+tt]);
            }
        }
    }

    private void addFrontList(ArrayList<Integer> l, int contador){

        if(this.phtoValues.length - this.serchFront < contador){
            
            for(int tt = 0; tt < this.phtoValues.length - contador;tt++){
                l.add(this.phtoValues[contador+tt]);
            }

        }else{
            for(int tt = 0; tt < this.serchFront; tt++){
                l.add(this.phtoValues[contador+tt]);
            }
        }
        
    }

    public Triple serch(ArrayList<Integer> serchBack, ArrayList<Integer> serchFront){

        int serchB = serchBack.size();

        if(serchB == 0){
            return new Triple(0,0,serchFront.get(0));
        }


        ArrayList<Integer> allNums = new ArrayList<>();
        allNums.addAll(serchBack);
        allNums.addAll(serchFront);
        int maxBack = 0;
        int maxInclude = 0;

        int mainPointer = serchBack.size();


        for(int tt = 0; tt < serchB;tt++){
            int size = 0;
            while(allNums.get(tt+size) == allNums.get(mainPointer+size)){
                size++;
                if(allNums.size() == mainPointer + size){
                    size--;
                    break;
                }
                if(tt+size >= mainPointer){
                    break;
                }
            }
            if(size > maxInclude && size > 1){
                maxBack = tt;
                maxInclude = size;
            }
        }


        return new Triple(mainPointer-maxBack,maxInclude,allNums.get(mainPointer+maxInclude));
        

    }














    public Triple serchV2(int bs,int be,int fs,int fe){

        int serchB = be - bs;
       

        if(serchB == 0){
            return new Triple(0,0,this.phtoValues[fs]);
        }


        int maxBack = 0;
        int maxInclude = 0;

        int mainPointer = fs;


        for(int tt = 0; tt < serchB;tt++){
            int size = 0;
            while(this.phtoValues[tt+size] == this.phtoValues[mainPointer+size]){
                size++;
                if(fe-bs == mainPointer + size){
                    size--;
                    break;
                }
                if(tt+size >= mainPointer){
                    break;
                }
            }
            if(size > maxInclude){
                maxBack = tt;
                maxInclude = size;
            }
        }

        System.out.println("serch back: " + maxBack);
        System.out.println("serch include: " + maxInclude);



        return new Triple(mainPointer-maxBack,maxInclude,this.phtoValues[mainPointer+maxInclude]);
        

    }




    







}