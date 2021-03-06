import java.util.Scanner;

public class Drones{

    private static ArrayList2 lista = new ArrayList2();

    public static int getDataScanner(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();


    }

    public static void main(String[] args) {

        
        while(true){
            int data = Drones.getDataScanner();
            if(data == -1){break;}
            Drones.lista.addElement(data);
        }
        // O(n ^2)
        // con esta complejidad en terminos de tiempo si seria posible manejar n de un millon.
        

        System.out.println(Drones.lista.toString());
        
    }



}