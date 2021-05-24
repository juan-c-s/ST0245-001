import java.io.*;
import java.util.Arrays;

import BIliniar.Biliniar;
import REWR.*;
import Resta.Restas;
import Multiples.*;
import Renderimg.Render;

public class index {

    private static final long MEGABYTE = 1024L * 1024L;

    // Juan camilo -- Tomas 

    
    public static void main(String[] args) {


        String[] name = new String[]{"img1.csv","img2.csv","img3.csv","img4.csv","img5.csv","img6.csv","img7.csv"};

        for (String s : name) {
            
            ReadFile rf = new ReadFile("./imgs/originals/" + s);
            int[][] photo = rf.getPhotoMatrix();

            // <------------- START OF COMPRESSION -------------->
            Biliniar b = new Biliniar(photo);

            // <------------- LOSS less --------------->
            long startTime = System.currentTimeMillis();
            Runtime runtime = Runtime.getRuntime();
            runtime.gc();


            // matrix after biliniar
            int[][] compMatrix = b.getCompressedMatrix();
            // convert the compressed matrix to a list
            int[] photoList = ConvertToList.convertMatrixToList(compMatrix);

            // apply the restas algo
            Restas res = new Restas(photoList);
            // APLICAR ALGORÍTMO DE FRECUENCIAS
            SameNumbers sm = new SameNumbers(res.getRestasPixels());

         
        
            long memory = runtime.totalMemory() - runtime.freeMemory();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("COMPRESS");
            System.out.println("Used memory is bytes: " + memory);
            System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
            System.out.println("Time ==> " + elapsedTime);
            System.out.println("-------");

            // <------------- START OF DECOMPRESSION -------------->



            WriteFile.saveCompressFile(sm.getCompressedList(), "./imgs/compressed/COMPRESSED"+s, compMatrix.length);

            long startTime1 = System.currentTimeMillis();
            Runtime runtime1 = Runtime.getRuntime();
            runtime1.gc();

            int[] beforebilinear = res.decompressResta(ReadFile.readDecompressed("./imgs/compressed/COMPRESSED"+s).list);
            b.decompress(ConvertToList.convertListToMatrix(beforebilinear, compMatrix[0].length));
            int[][] afterBilinear = b.getDecompressed();

            long memory1 = runtime1.totalMemory() - runtime1.freeMemory();
            long stopTime1 = System.currentTimeMillis();
            long elapsedTime1 = stopTime1 - startTime1;

            System.out.println("DECOMPRESS");
            System.out.println("Used memory is bytes: " + memory1);
            System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory1));
            System.out.println("Time ==> " + elapsedTime1);
            System.out.println("-------");


            Render.createCompressedImage(afterBilinear, "./imgs/Rende/i"+s+".jpg");

            System.out.println("############ ----> " + s);

        }


    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }


}
