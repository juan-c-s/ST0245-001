public class Triple {

    public int first;
    public int second;
    public int third;


    public Triple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String  toString(){
        return "(" + this.first + "," + this.second + "," + this.third + ")";
    }
    
}
