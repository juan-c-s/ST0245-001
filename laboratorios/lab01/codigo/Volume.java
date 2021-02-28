public class Volume {


    public static int fit1x2(int nrec ,int tiles){
        if(nrec*2 == tiles){
            return 1;
        } else if(nrec*2 < tiles){
            return 0;
        }else{
            return fit1x2(nrec, tiles + 2) + fit1x2(nrec, tiles + 4);
        }
    }
 
}
