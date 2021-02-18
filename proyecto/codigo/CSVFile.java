import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;


public class CSVFile{
    private String paths;
    private int maxWith;
    private int height;
    private int[][] matrix;
    

    CSVFile(String path,boolean compress,boolean decompress){
        this.paths = path;
        this.findWithHeight();
        this.createMatrix();
        this.fillMatrix();
        if(compress){
            this.compress();
        }
        if(decompress){
            this.decompress();
        }

    }

    public void compress(){
        //this is the compress area 

    }

    public void decompress(){
        //this is the decompress area 
    }

    public void save(){
        // aqui va el codigo  que guarda la verzion compress o la decompress 
        System.out.println(Arrays.deepToString(matrix));
    }

    public int getMaxWith(){
        return this.maxWith;
    }

    public int getHeight(){
        return this.height;
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    private void createMatrix(){
        this.matrix = new int[this.height][this.maxWith];
    }

    private void fillMatrix(){
        String line = "";
        int indexCounter = 0;
        try{
            BufferedReader rd = new BufferedReader(new FileReader(this.paths));
            while((line = rd.readLine()) != null){
                String[] values = line.split(",");  

                for(int tt = 0;tt < values.length;tt++){
                    this.matrix[indexCounter][tt] = Integer.parseInt(values[tt]);
                }
                indexCounter++;
            }

            rd.close();

        }catch(FileNotFoundException err){
            err.printStackTrace();

        }catch(IOException err){
            err.printStackTrace();
        }


    }

    private void findWithHeight(){
        String line = "";
        try{
            BufferedReader rd = new BufferedReader(new FileReader(this.paths));
            while((line = rd.readLine()) != null){
                String[] values = line.split(",");  
                this.maxWith = Math.max(maxWith,values.length);
                this.height++;
            }

            rd.close();

        }catch(FileNotFoundException err){
            err.printStackTrace();

        }catch(IOException err){
            err.printStackTrace();
        }
    }
    
}
