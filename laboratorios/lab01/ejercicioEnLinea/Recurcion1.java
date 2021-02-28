public class Recurcion1 {

    public boolean array220(int[] nums, int index) {
        if(index>=nums.length-1){
          return false;
        }else if(nums[index]*10==nums[index+1]){
          return true;
        }
        else return array220(nums,index+1); 
      }


      public boolean nestParen(String str) {
        if(str.length()==0){
          return true;
        }
        else if(str.length()==1) {
          return false;
        }
        else if((str.charAt(0)!='(' && str.charAt(str.length()-1)==')')
        ||(str.charAt(0)=='(' && str.charAt(str.length()-1)!=')')
        ||(str.charAt(0)!='(' && str.charAt(str.length()-1)!=')')){
          return false;
        }
        return nestParen(str.substring(1,str.length()-1));
      }

      public String parenBit(String str) {
        if(str.length()==0) return "";
        else if(str.charAt(0) =='('&&str.charAt(str.length()-1)==')'){
           return str;
        }else if(str.charAt(0) == '('&&str.charAt(str.length()-1)!=')'){
          return parenBit(str.substring(0,str.length()-1));
        }else if(str.charAt(0) != '('&&str.charAt(str.length()-1)==')'){
          return parenBit(str.substring(1));
        }
        else{
          return parenBit(str.substring(1,str.length()-1));
        }
      }

      public int countAbc(String str) {
        if(str.length()<3){
         return 0;
       }
       if(str.substring(0,3).equals("abc")||str.substring(0,3).equals("aba")){
         return 1 + countAbc(str.substring(1));
       }else return countAbc(str.substring(1));
     }

     public int strCount(String str, String sub) {
        if(str.length()==0) return 0;
        else if(str.length()<sub.length()) return 0;
        else if(str.substring(0,sub.length()).equals(sub)){
          return 1+strCount(str.substring(sub.length()),sub);
        }else return strCount(str.substring(1),sub);
      }
 
    
}
