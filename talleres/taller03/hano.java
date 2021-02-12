public class hano {

    public static void main(String[] args) {

        hano.hanoi(3,"A","B","c");
        
    }

    public static void hanoi(int N,String start,String aux,String end){
        if(N==1){
            System.out.println("Start: " + start +  " End: " + end);
            
        }else{
            hanoi(N-1,start,end,aux);
            hanoi(N-1,start,aux,end);
            hanoi(N-1,aux,start,end);
        }
        
    }
    
}
