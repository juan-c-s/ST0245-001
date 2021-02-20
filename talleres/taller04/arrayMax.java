import java.util.Arrays;
import java.util.Random;

public class arrayMax{

    public static void main(String[] args) {

        int[] nums = arrayMax.genereRandomArray();
        long startTime = System.currentTimeMillis();

        System.out.println(arrayMax.ArraymaxCalc(nums,nums.length-1));

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
    }

    public static int ArraymaxCalc(int[] nums,int index){
       int max = nums[index]; // Const 
        if(index == 0){   //Const 
            max = nums[0]; //Const 
        }
        if(index != 0){ //Const 
            int temporal = arrayMax.ArraymaxCalc(nums,index-1); //T(n-1)
            if(temporal > max){ //Const 
                max = temporal; //Const 
            }
        }
        return max; //Const 
    }

    public static int[] genereRandomArray(){
        int size = 1000;
        int max = 5000;
        int[] nums = new int[size];
        Random randomGenerator = new Random(size);
        for(int tt = 0;tt<size;tt++){
            nums[tt] = randomGenerator.nextInt(max);
        }
        return nums;
    } 

}