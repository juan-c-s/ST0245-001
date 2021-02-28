import java.util.Random;

public class Genome {
    public static void main(String[] argumento) {

     

     

        int nums = 20;
        String str1 = "";
        String str2 = "";
        for(int tt = 0; tt < nums; tt++){
            Random rnd = new Random();
            str1 = str1 + (char) ('a' + rnd.nextInt(26));
            str2= str2 + (char) ('a' + rnd.nextInt(26));
          
        }

        System.out.println(str1);
        System.out.println(str2);

        

     

        long startTime = System.currentTimeMillis();

        System.out.println(Genome.genoma(str1,str2));

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println( "Tiempo: " + estimatedTime);
        
  
    }
  
    public static int genoma(String cadena, String subCadena){
        if (cadena.length() == 0 || subCadena.length() == 0) {
            return 0;
        } else if (cadena.charAt(0) == subCadena.charAt(0)) {
  
            return 1 + genoma(cadena.substring(1), subCadena.substring(1));
        }
        int llamado1 = genoma(cadena.substring(1), subCadena);
        int llamado2 = genoma(cadena, subCadena.substring(1));
        if (llamado1 > llamado2) {
            return llamado1;
        } else {
            return llamado2;
        }
  
    }

    
 }