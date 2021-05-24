package Multiples;

public class TuplaBinaria {
    private int number;
    private int frequency;

    public TuplaBinaria(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getNumber() {
        return this.number;
    }

    public TuplaBinaria(int number) {
        this.number = number;
    }

    public String tString() {
        if (frequency > 1) {
            return this.number + "*" + this.frequency + ",";
        } else
            return this.number + ",";
    }
}
