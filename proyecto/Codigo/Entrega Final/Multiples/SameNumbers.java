package Multiples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SameNumbers {
    private int[] pixels;
    private LinkedList<TuplaBinaria> compressed;
    private int[] deCompressed;

    public SameNumbers(int pixels[]) {
        this.pixels = pixels;
        compressed = new LinkedList<>();
        compress();
    }

    public LinkedList<TuplaBinaria> getCompressedList() {
        return this.compressed;
    }

    public void compress() {

        int currSameNumber = -1;

        int frequency = 1;
        for (int i = 0; i < this.pixels.length; i++) {

            if (currSameNumber == this.pixels[i]) {
                frequency++;
            } else if (currSameNumber != this.pixels[i] && frequency > 1) {
                this.compressed.add(new TuplaBinaria(currSameNumber, frequency));
                frequency = 1;
                currSameNumber = this.pixels[i];
            } else {
                if (i != 0) {
                    this.compressed.add(new TuplaBinaria(currSameNumber));
                }
                frequency = 1;
                currSameNumber = this.pixels[i];

            }
        }
        this.compressed.add(new TuplaBinaria(currSameNumber, frequency));
    }

    public void compressToString() {
        // System.out.println("Size 1: " + originalSize);
        // System.out.println("Size 2: " + this.compressed.size());
        // double rate = (double) (originalSize - this.compressed.size()) /originalSize;
        // System.out.println("Compression Rate: " + rate);

        Iterator<TuplaBinaria> it = this.compressed.iterator();
        int contador = 0;
        while (it.hasNext()) {

            System.out.print(it.next().tString());
            contador++;
        }
    }

    public static int[] decompress(LinkedList<TuplaBinaria> lista, int size) {
        int decompressed[] = new int[size];
        TuplaBinaria tupla;
        int decIndex = 0;
        while ((tupla = lista.poll()) != null) {

            int num = tupla.getNumber();
            if (tupla.getFrequency() > 1) {
                int frequency = tupla.getFrequency();
                for (int i = 0; i < frequency; i++) {
                    decompressed[decIndex] = num;
                    decIndex++;
                }
            } else {
                decompressed[decIndex] = num;
                decIndex++;

            }

        }
        return decompressed;
    }
}
