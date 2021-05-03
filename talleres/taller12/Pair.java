public class Pair {
<<<<<<< HEAD
    public int destino;
    public int peso;

    public Pair(int a, int s) {
        this.destino = a;
        this.peso = s;
    }
=======

    private int key;
    private int value;

    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public int getKey(){
        return this.key;
    }
    
    
>>>>>>> 39267b7abfc8f907eea886c9d9a51264f3db90c3
}
