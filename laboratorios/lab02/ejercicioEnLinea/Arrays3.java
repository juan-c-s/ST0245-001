public class Arrays3 {

    public boolean canBalance(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        boolean equal = false;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            int auxSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                auxSum += nums[j];
                if (j == right && auxSum == sum) {
                    return true;
                }
            }
        }
        return false;
    }

  
  
  
 public static boolean linearIn(int[] outer, int[] inner){
  
    int innerContador = 0;
    for(int tt = 0;tt<outer.length;tt++){
  
        if(innerContador < inner.length && outer[tt] == inner[innerContador]){
            innerContador++;
        }
    }
  
     return innerContador == inner.length;
 }
     

    public static int[] seriesUp(int n) {
  
        int[] nums = new int[(n*(n+1))/2];
  
        int start = 1;
        int contador = 0;
        for(int grande = 0; grande < nums.length; grande+= contador){
            for(int peque = 0; peque <= contador;peque++){
               nums[grande+peque] = start;
               start++;
            }
            start = 1;
            contador++;
        }
        return nums;
     }

  
  
   public static int[] squareUp3(int n) {
  
        if(n==0){return new int[0];}
        int[] nums = new int[n*n];
  
        int indexes = 1;
        for(int grande = n;grande <= n*n;grande+=n){
            for(int peque = indexes; peque > 0;peque--){
                 nums[grande-peque] = peque;
            }
            indexes++;
        }
         return nums;
    }

    public int maxMirror(int[] nums) {
        int max = 0;
        int iaux = 0;
        boolean equal = false;
        for (int i = 0; i < nums.length; i++) {
            int cont = 0;
            iaux = i;
            for (int j = 0; j < nums.length - i; j++) {
                equal = false;
                if (nums[iaux] == nums[nums.length - 1 - j]) {
                    cont++;
                    iaux++;
                    equal = true;
                }
                if (!equal && cont > 0) {
                    if (max < cont) {
                        max = cont;
                    }
                    cont = 0;
                }
            }
            if (max < cont) {
                max = cont;
            }
  
        }
        return max;
    }

  
     
 
    
}
