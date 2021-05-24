package BIliniar;

import java.text.BreakIterator;
import java.util.Arrays;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Biliniar {

    private int maxWidth;
    private int height;
    private int[][] matrix;
    private int[][] compressedMatrix;
    private int[][] decompressed;

    public Biliniar(int[][] matrix) {
        this.matrix = matrix;
        this.compress();

    }

    public int average(int x, int y) {
        return (x + y) / 2;
    }

    public int[][] getCompressedMatrix() {
        return this.compressedMatrix;
    }

    public int[][] getDecompressed() {
        return this.decompressed;
    }

    public void compress() {

        int[][] temp = new int[this.matrix.length / 2][this.matrix[0].length / 2];

        int iC = 0;
        // Contadores de compressed Matrix
        for (int i = 0; i < this.matrix.length  && iC < temp.length; i += 2) {

            int jC = 0;
            for (int j = 0; j < this.matrix[0].length  && jC < temp[0].length; j += 2) {

                int horizontal1 = average(this.matrix[i][j], this.matrix[i][j + 1]);
                int horizontal2 = average(this.matrix[i + 1][j], this.matrix[i + 1][j + 1]);
                temp[iC][jC] = average(horizontal1, horizontal2);
                jC++;

            }
            iC++;

        }

        this.compressedMatrix = temp;

    }

    public void decompress(int[][] compressed) {
        // this is the decompress area
        int[][] temp = new int[compressed.length * 2][compressed[0].length * 2];
        int iD = 0;
        int jD = 0;
        for (int i = 0; i < compressed.length * 2 && iD < compressed.length; i += 2) {
            jD = 0;
            for (int j = 0; j < compressed[0].length * 2 && jD < compressed[0].length; j += 2) {
                temp[i][j] = compressed[iD][jD];
                temp[i + 1][j] = compressed[iD][jD];
                temp[i + 1][j + 1] = compressed[iD][jD];
                temp[i][j + 1] = compressed[iD][jD];
                jD++;
            }

            iD++;
        }
        this.decompressed = temp;
    }
}
