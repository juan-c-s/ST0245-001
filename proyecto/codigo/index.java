import java.util.Arrays;

public class index{
    
    public static void main(String[] args) {
        CSVFile f1 = new CSVFile("/Users/tomascalle/Desktop/read/11-0.csv");

        System.out.println(Arrays.deepToString(f1.getMatrix()));

    }
}