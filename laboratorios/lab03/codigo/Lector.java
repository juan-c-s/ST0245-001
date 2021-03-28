import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;

import java.util.Scanner;

import javax.sound.sampled.LineEvent; 

public class Lector {

    public static boolean isVerteci = false;
    public static boolean isArco = false;
    public static Cuidad med  = new Cuidad();
    public static int sizeCiudad = 0;


    public static  void read(String database){

            try {
              File myObj = new File(database);
              Scanner myReader = new Scanner(myObj);

              while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Lector.manipulateDataLine(data);
              }

              myReader.close();
            } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
    }

    public static void manipulateDataLine(String data){

        if(data.equals("")){return;}
        if(data.equals("Vertices. Formato: ID coordenadaY coordenadaX nombre")){isVerteci=true; return;}
        if(data.equals("Arcos. Formato: ID ID distancia nombre ")){isArco=true; isVerteci=false; return;}
        int contador = 1;
        int index = 0;
        int start = 0;
        int end  = 0;

        if(isVerteci){
        
            String[] rawData = data.split(" ");
            String[] line = new String[4];

            for(int tt = 0; tt < data.length();tt++){
                if(data.charAt(tt) == ' ' && contador <= 3){
                    end = tt;
                    line[index] = data.substring(start,end);
                    index++;
                    contador++;
                    start = tt+1;
                }
            }
                line[index] = data.substring(start);
            

            if(rawData.length == 3){
                line[3] = "desconocido";
            }

            Verteci newVer = new Verteci(Long.parseLong(line[0]),Float.parseFloat(line[1]), Float.parseFloat(line[2]),line[3]); 
           Lector.med.vertes.add(newVer);
           Lector.sizeCiudad++;
        

        }else if(isArco){

            String[] rawData = data.split(" ");
            String[] line = new String[4];


            for(int tt = 0; tt < rawData.length;tt++){
                line[tt] = rawData[tt];
            }
            if(rawData.length == 3){
                line[3] = "desconocido";
            }

            Lector.addArco(line);

        }

        
       
        
    }

    public static void addArco(String[] info){

        Verteci ver1 = new Verteci();
        Verteci ver2 = new Verteci();
        int positionver1 = 0;
        int positionver2 = 0;


        for(int tt = 0; tt < Lector.sizeCiudad;tt++){
            if(Lector.med.vertes.get(tt).id == Long.parseLong(info[0])){
                ver1 = Lector.med.vertes.get(tt);
                positionver1 = tt;
            }
            if(Lector.med.vertes.get(tt).id == Long.parseLong(info[1])){
                ver2 = Lector.med.vertes.get(tt);
                positionver2 = tt;
            }
            

        }

        Arco newarco = new Arco(ver1,ver2,Long.parseLong(info[0]),Long.parseLong(info[1]),Double.parseDouble(info[2]),info[3]);
        Lector.med.vertes.get(positionver1).acros.add(newarco);
        Lector.med.vertes.get(positionver2).acros.add(newarco);
        
    }

    public static void main(String[] args) {

        Lector.read("medellin_colombia-grande.txt");

        System.out.println(Lector.med.vertes.get(0).acros.get(0).nombre);
  
        
        
    }
    
}
