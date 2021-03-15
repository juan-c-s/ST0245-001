import java.util.Arrays;



public class Merge {


    public static void main(String[] args) {

        
        
        int[] nums = random(100000000);

        long start = System.currentTimeMillis();

        sortList(nums, 0, nums.length - 1);

        long endTime = System.currentTimeMillis() - start;

        
        System.out.println(endTime);

        // Title: Merge Sort
        // Author: Rajat Mishra
        // data:  11 Feb, 2021
        // Availavility : https://www.geeksforgeeks.org/merge-sort/

        
    }

    public static void merge(int[] nums, int start,int medium,int end){

        int b = end-medium;
        int t = medium-start+1;

        int[] botom = new int[b];
        int[] top = new int[t];

         
        for(int tt = 0;tt < t;tt++){
            top[tt] = nums[start+tt];
        }

        for(int tt = 0;tt < b;tt++){
            botom[tt] = nums[medium+tt+1];
        }
        
        int contadorBotom  = 0;
        int contadorTop = 0;
        int mainContador = start;

        while (contadorBotom < b && contadorTop < t) {
            
            if (botom[contadorBotom] <= top[contadorTop]) {
             
                nums[mainContador] = botom[contadorBotom];
                contadorBotom++;
            }
            else {
                nums[mainContador] = top[contadorTop];
                contadorTop++;
            }
            mainContador++;
        }
   
        while (contadorBotom < b) {

            nums[mainContador] = botom[contadorBotom];
            contadorBotom++;

            mainContador++;
        }
 
   
        while (contadorTop < t) {
            nums[mainContador] = top[contadorTop];
            contadorTop++;

            mainContador++;
        }

    }

    public static void sortList(int[] nums,int start,int end){

        if(start < end){

            int mid = start+(end-start)/2;

            sortList(nums,start,mid);
            sortList(nums,mid+1,end);

            merge(nums,start,mid,end);
            
        }

    

    }

    public static  int[] random(int nums) {

        int ar[] = new int[nums];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) Math.round(Math.random() * 2000);
            
        }

        return ar;

    }
    
}
