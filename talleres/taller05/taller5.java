import java.math.BigInteger;
import java.util.Arrays;

public class taller5{


    public static void main(String[] args) {

        

        int[] nums = taller5.randomArray(100000);
        long startTime = System.currentTimeMillis();

        //taller5.cuentaTodo(nums);
        //taller5.cunetaRecuersiva(nums,0);
        //taller5.insertionSort(nums);

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
        
    }

    public static int cuentaTodo(int[] nums){

        int contador = 0;

        for(int tt = 0;tt< nums.length;tt++){
            contador = contador + nums[tt];
        }

        return contador;
    }

    public static int cunetaRecuersiva(int[] nums,int index){
        if(index == nums.length-1){
            return nums[index];
        }
        return nums[index] + cunetaRecuersiva(nums,index+1);
    }


    public static int[] randomArray(int size){

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random() * 10);
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i];
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

        }
        return arr;
    }

}