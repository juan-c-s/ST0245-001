public class Array2 {
     public String[] fizzBuzz(int start, int end) {
        String[] listWords = new String[end - start];
        for (int i = 0; i < end - start; i++) {
            if ((i + start) % 3 == 0 && (i + start) % 5 == 0) {
                listWords[i] = "FizzBuzz";
            } else if ((i + start) % 3 == 0) {
                listWords[i] = "Fizz";
            } else if ((i + start) % 5 == 0) {
                listWords[i] = "Buzz";
            }
  
            else
                listWords[i] = String.valueOf(i + start);
        }
        return listWords;
    }
  
  public int[] evenOdd(int[] nums) {
        int[] newArr = new int[nums.length];
        int even = 0;
        int odd = nums.length - 1;
  
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                newArr[even] = nums[i];
                even++;
            } else {
                newArr[odd] = nums[i];
                odd--;
            }
        }
        return newArr;
    }
  public boolean haveThree(int[] nums) {
        int cont = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                cont++;
                i++;
            }
        }
        return cont == 3;
    }
  
  public int[] withoutTen(int[] nums) {
  
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 10) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
  
                }
  
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 10) {
                nums[i] = 0;
            }
        }
  
        return nums;
    }
  
      public int[] zeroMax(int[] nums) {
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[nums.length - i] % 2 == 1) {
                max = Math.max(max, nums[nums.length - i]);
            }
            if (nums[nums.length - i] == 0) {
                nums[nums.length - i] = max;
            }
        }
        return nums;
    }
 
    
}
