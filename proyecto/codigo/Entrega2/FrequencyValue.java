public class FrequencyValue {

    int number;
    double frequency;

    public FrequencyValue parent;
    public FrequencyValue left;
    public FrequencyValue right;


    public boolean isBase;


    public FrequencyValue(int number,double frequency){
        this.number = number;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isBase = true;
    }

    public FrequencyValue(double frequency,FrequencyValue left,FrequencyValue right){
        this.isBase = false;
        this.frequency = frequency;
        this.right = right;
        this.left = left;
        this.parent = null;
        

    }

    
}
