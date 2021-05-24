package REWR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Iterator;

import Multiples.TuplaBinaria;

public class WriteFile {

    public static void saveCompressFile(LinkedList<TuplaBinaria> pixels, String path, int columns) {

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(path));
            Iterator<TuplaBinaria> it = pixels.iterator();
            bf.write(columns + "\n");

            while (it.hasNext()) {

                bf.write(it.next().tString());

            }

            bf.close();

        } catch (Exception err) {
            System.out.println("err printer");
        }
    }

}
