public class Euclides {

    public static int eulides(int grande,int peque){
        if(grande%peque == 0){
            return peque;
        }else{
            return eulides(peque,grande%peque);
        }
    }
    
}
