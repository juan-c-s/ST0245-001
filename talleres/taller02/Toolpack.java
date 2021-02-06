import java.lang.annotation.Target;
import java.util.Arrays;

public class Toolpack{
     public static void main(String[] args) {

        System.out.println(findToolsSums(0,new int[] {3,3,4},9));

   
         
     }

     public static boolean findToolsSums(int index,int[] nums,int target){
         
      if(index >= nums.length){
          return target == 0;
      }

      return findToolsSums(index+1,nums,target-nums[index]) || findToolsSums(index+1,nums,target);

    }


}