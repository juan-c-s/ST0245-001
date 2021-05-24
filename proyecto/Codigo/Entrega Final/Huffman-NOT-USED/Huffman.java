package Huffm;
import java.util.HashMap;
import java.util.ArrayList;

public class Huffman {

    public int[][] matrix;
    public static HashMap<Integer,TableValue> table = new HashMap<>();
    public static HashMap<String,TableValue> tableCodes = new HashMap<>();

    public ArrayList<FrequencyValue> frequencylist = new ArrayList<FrequencyValue>();
    FrequencyValue head;

    public Huffman(int[][] matrix){
        this.matrix = matrix;
        this.head = null;
    }

    private void createTree(){

        FrequencyValue newNode = null;
        while(frequencylist.size()>=2){
            FrequencyValue nodeleft = frequencylist.get(0);
            FrequencyValue nodeRight = frequencylist.get(1);

            newNode = new FrequencyValue(nodeleft.frequency+nodeRight.frequency,nodeleft,nodeRight);

          

            frequencylist.remove(0);
            frequencylist.remove(0);
            frequencylist.add(newNode);
            sortFrequencyList();


        }
        this.head = newNode;
        
   
    }

    private void traverseTreeCall(){
        System.out.println("----------");
        traverseTree(this.head,"");
    }


    private void traverseTree(FrequencyValue curreentNode,String code){
        if(curreentNode.isBase == true){
            Huffman.table.put(curreentNode.number,new TableValue(curreentNode.frequency,code));
            Huffman.tableCodes.put(code,new TableValue(curreentNode.frequency,curreentNode.number));
            System.out.println(curreentNode.number + " : " + code);
            return;
        }
        traverseTree(curreentNode.left,code+"0");
        traverseTree(curreentNode.right,code+"1");
    }


    private void convertfrequencyvalues(){
        double contador = 0;
        for(int tt = 0;tt<frequencylist.size();tt++){
            frequencylist.get(tt).frequency = frequencylist.get(tt).frequency/(matrix.length*matrix[0].length)*100;
            contador += frequencylist.get(tt).frequency;
        }
        System.out.println("sum: " + contador);
    }


    public void makeFrequencyList(){
        for(int g = 0;g<matrix.length;g++){
            for(int s = 0;s<matrix.length;s++){
                if(!frequencylistContains(matrix[g][s])){
                    frequencylist.add(new FrequencyValue(matrix[g][s],0));
                }
            }
        }

        FillFrequency();
        convertfrequencyvalues();
        sortFrequencyList();
        for(FrequencyValue node : frequencylist){
            System.out.println(node.number + " : " + node.frequency);
        }
        createTree();
        traverseTreeCall();


    }

    private void sortFrequencyList(){

        int len = frequencylist.size();
        for (int g = 0; g < len-1; g++){
            for (int s = 0; s < len-g-1; s++){

                if (frequencylist.get(s).frequency > frequencylist.get(s+1).frequency){
                    FrequencyValue t = frequencylist.get(s);
                    frequencylist.set(s,frequencylist.get(s+1));
                   frequencylist.set(s+1,t);
                }

            }
        }
    }

    private void FillFrequency(){
        for(int g = 0;g<matrix.length;g++){
            for(int s = 0;s<matrix.length;s++){

                for(int tt = 0;tt<frequencylist.size();tt++){
                    if(matrix[g][s] == frequencylist.get(tt).number){
                        frequencylist.get(tt).frequency++;
                    }

                }
                
            }
        }
    }


    private boolean frequencylistContains(int value){
        for(int tt = 0;tt<frequencylist.size();tt++){
            if(value == frequencylist.get(tt).number){
                return true;
            }
        }
        return false;
    }

    
}
