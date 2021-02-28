public class Recuercion2 {

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length){ // 3C_1
            return target == 0; // 2C_2
        }else if(nums[start] == 6){ // 4C_3
            return groupSum6(start+1,nums,target-6); // 4C_4 + F(n-1)
        }
        return groupSum6(start+1,nums,target-nums[start])||groupSum6(start+1,nums,target); 
     // 7C_5 + F(n-1) + F(n-1)
    }

    public boolean groupSum(int index,int[] nums,int target){
        if(index == nums.length){ // 3C_1
            return target == 0; // // 2C_2
        }else{
            return groupSum(index + 1,nums,target-nums[index]) || groupSum(index + 1,nums,target); 
         // 7C_3 + F(n-1) + F(n-1)
  
         // F(n) = c_1 2^(n - 1) (where c_1 is an arbitrary parameter)
         //O(2^(n)) donde n es la longitud del arreglo
        }
    }

    public static boolean groupNoAdj(int index, int[] nums, int target){
        if(index >= nums.length){ // 3C_1
            return target == 0; // 3C_2
        }
        return groupNoAdj(index + 2,nums,target-nums[index]) || groupNoAdj(index + 1,nums,target); 
 // 7C_3 + F(n-1) + F(n-1)
 // F(n) = c_1 2^(n - 1) (where c_1 is an arbitrary parameter)
    }

    public static boolean groupSum5(int start, int[] nums, int target){
  
        if(start >= nums.length){ 
           return target == 0; 
        }
  
        if(nums[start]%5 == 0){ 
            if(start < nums.length-1){ 
                if(nums[start+1] == 1){
                    return groupSum5(start+2,nums,target-nums[start]);
                }
                return groupSum5(start+1,nums,target-nums[start]);
            }
        }
        return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
       
    } 

    public static  boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length){ // 3C_1
            return target == 0; // 2C_1
         }
         int countadorValor = 0; // C_2
         int countadorIndex = 0;	// C_3
         boolean seguidos = true; // C_4
  
         for(int tt = start; tt < nums.length;tt++){ 
            seguidos = (nums[tt] == nums[start]); 
  
             if(seguidos){
                 countadorValor = countadorValor + nums[tt];
                 countadorIndex++;
             }
         }
         return (
         groupSumClump(start+countadorIndex,nums,target-countadorValor)
         ||
         groupSumClump(start+countadorIndex,nums,target));
     } 
 
    
}
