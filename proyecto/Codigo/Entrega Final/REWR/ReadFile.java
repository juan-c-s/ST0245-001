package REWR;

import java.io.*;
import Multiples.TuplaBinaria;

import java.util.Iterator;
import java.util.LinkedList;

public class ReadFile {

    private int[][] matrix;
    private String path;

    public ReadFile(String path) {
        this.path = path;
        this.matrix = createMatrix();
        this.matrix = readFile();

    }

    public int[][] getPhotoMatrix() {
        return this.matrix;
    }

    // este lee el csv original
    private int[][] readFile() {

        int[][] newMatrix = this.matrix;

        try {

            BufferedReader bf = new BufferedReader(new FileReader(this.path));
            String line;
            int contador = 0;
            while ((line = bf.readLine()) != null) {
                String[] lineList = line.split(",");

                for (int tt = 0; tt < lineList.length; tt++) {
                    newMatrix[contador][tt] = Integer.parseInt(lineList[tt]);

                }
                contador++;

            }

        } catch (Exception err) {
            System.out.println(err);
        }

        return newMatrix;

    }

    public static Tupla readDecompressed(String path) {

        LinkedList<Integer> compressed = new LinkedList<>();
        Tupla tupla = new Tupla();
        try {

            BufferedReader bf = new BufferedReader(new FileReader(path));
            tupla.columns = Integer.parseInt(bf.readLine());
            String line;
            int contador = 0;
            while ((line = bf.readLine()) != null) {
                String[] lineList = line.split(",");

                for (int tt = 0; tt < lineList.length; tt++) {
                    if (lineList[tt].contains("*")) {
                        int indexAsterisco = lineList[tt].indexOf("*");
                        int frequency = Integer.parseInt(lineList[tt].substring(indexAsterisco + 1));
                        int num = Integer.parseInt(lineList[tt].substring(0, indexAsterisco));
                        for (int i = 0; i < frequency; i++) {
                            compressed.add(num);
                        }
                    } else {
                        compressed.add(Integer.parseInt(lineList[tt]));
                    }
                }
                contador++;

            }
            tupla.list = compressed;

        } catch (Exception err) {
            System.out.println(err);
        }

        return tupla;

    }

    // este calcula el tamaño de la matriz para el csv original
    private int[][] createMatrix() {

        int contadorHeight = 0;
        int contadorWith = 0;

        try {
            BufferedReader bff = new BufferedReader(new FileReader(this.path));
            String line;

            while ((line = bff.readLine()) != null) {
                String[] lineList = line.split(",");

                for (int tt = 0; tt < lineList.length; tt++) {
                    contadorWith = tt;
                }
                contadorHeight++;

            }

        } catch (Exception err) {
            System.out.println(err);
        }

        return new int[contadorHeight][contadorWith + 1];
    }

    // aqui va el va el metodo que lee el compressed file
    public static boolean compareLists(LinkedList<Integer> ll, int arr[]) {

        if (ll.size() != arr.length)
            return false;
        Iterator<Integer> itt = ll.iterator();
        int i = 0;
        while (itt.hasNext()) {
            if (itt.next() != arr[i])
                return false;
            i++;
        }
        return true;
    }

}
