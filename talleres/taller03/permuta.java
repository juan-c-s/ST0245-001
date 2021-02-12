import java.util.ArrayList;

public class permuta {

    private static ArrayList<String> passList = new ArrayList<>();

    public static void main(String[] args) {

        permuta.haker("","abc");
        System.out.println(passList.toString());
        
    }

    public static void haker(String respu,String info){
        if(info.length() == 1){
            permuta.passList.add(respu+info);
        }else{
            for(int tt = 0;tt<info.length();tt++){
                haker(respu+info.charAt(tt),info.replace(info.substring(tt,tt+1),""));
            }
        } 
    }
    
}
