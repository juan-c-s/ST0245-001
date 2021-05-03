import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;

public class Writer {

    private String path;
    

    public Writer(String path,String fileName){
        this.path = path+fileName;
    }
    
    public void saveCompressFile(int[][] matrix,HashMap<Integer,TableValue> table){
        try{

            BufferedWriter bf = new BufferedWriter( new FileWriter(this.path));

                for(int g = 0;g < matrix.length;g++){
                    String line = "";
                    for(int s = 0; s < matrix[g].length;s++){
                        line += table.get(matrix[g][s]).code;
                                   
                        if(s != matrix[g].length-1){
                            line += ",";
                        }
                    }
                    bf.write(line+"\n");
                }
                bf.close();

        }catch(Exception err){
            System.out.println("err printer");
        }
    }


    public int[][] readCompressed(int[][] newMatrix,HashMap<String,TableValue> table){

        try{

           BufferedReader bf = new BufferedReader(new FileReader(this.path));

           int contador = 0;
           String line;
           while((line=bf.readLine()) != null){
                String[] lineList = line.split(",");

                for(int tt = 0;tt<lineList.length;tt++){
                    newMatrix[contador][tt] = table.get(lineList[tt]).value;
                   
                }

                contador++;
           }

           //System.out.println(Arrays.deepToString(newMatrix));
               

        }catch(Exception err){
            System.out.println("err printer");
        }

        return newMatrix;

    }
    
}
