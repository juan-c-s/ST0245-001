package Resta;

import java.util.LinkedList;
import java.util.Iterator;

public class Restas {

    private int[] pixels;

    public Restas(int[] pixeles) {
        this.pixels = pixeles;
        this.resta();
    }

    public int[] getRestasPixels() {
        return this.pixels;

    }

    private void resta() {
        int anterio = this.pixels[0];
        for (int i = 1; i < pixels.length; i++) {

            int axi = pixels[i];
            pixels[i] = pixels[i] - anterio;
            anterio = axi;

        }
    }

    public int[] linkedlistToArray(LinkedList<Integer> list) {
        Iterator<Integer> itt = list.iterator();
        int staticArray[] = new int[list.size()];
        int i = 0;
        while (itt.hasNext()) {
            staticArray[i] = itt.next();
            i++;
        }
        return staticArray;
    }

    public int[] decompressResta(LinkedList<Integer> list) {
        int phto[] = linkedlistToArray(list);
        int before = phto[0];
        for (int i = 1; i < this.pixels.length; i++) {
            phto[i] = before + phto[i];
            before = phto[i];
        }

        return phto;
    }

}
