import java.util.HashMap;
import java.util.LinkedList;


public class countries{
    
    public static HashMap<String,LinkedList<String>> counties = new HashMap<String,LinkedList<String>>();
    public static void main(String[] args){
        countries.work();
    }

    public static void work(){

        counties.put("google",new LinkedList<String>());
        counties.get("google").add("US");
        counties.get("google").add("india");
        counties.put("rappi",new LinkedList<String>());
        counties.get("rappi").add("colombia");
        counties.put("shopify",new LinkedList<String>());
        counties.get("shopify").add("canada");
        counties.put("apple",new LinkedList<String>());
       

        for(String empresa : counties.keySet()){
            System.out.println(counties.get(empresa));
        }

    }
}