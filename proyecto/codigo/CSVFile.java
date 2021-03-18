import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CSVFile {
    private String paths;
    private int maxWidth;
    private int height;
    private int[][] matrix;
    private int[][] compressedMatrix;

    CSVFile(String path, boolean compress, boolean decompress) {
        this.paths = path;
        this.findWidthHeight();
        this.createMatrix();
        this.fillMatrix();
        if (compress) {
            this.compress();
        }
        if (decompress) {
            this.decompress();
        }

    }

    public void createImage(int matriz[][]) {
        try {
            int rowMax = matriz.length;
            int colMax = matriz[0].length;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = matriz[i][j];
                    Color newColor = new Color(cl, cl, cl);
                    img.setRGB(j, i, newColor.getRGB());
                }

            }
            File out = new File("CompressedImg.jpg");
            ImageIO.write(img, "jpg", out);
        } catch (Exception e) {
            System.out.println("Error2: " + e);
        }
    }

    // Average method
    public int average(int x, int y) {
        return (x + y) / 2;
    }

    public int[][] getCompressedMat() {
        return this.compressedMatrix;
    }

    // interpolation algorithm
    public void compress() {
        this.compressedMatrix = new int[height / 2][maxWidth / 2];
        int iC = 0;
        int jC = 0;
        for (int i = 0; i < this.height && iC < height / 2; i += 2) {
            jC = 0;
            for (int j = 0; j < this.maxWidth && jC < maxWidth / 2; j += 2) {
                int horizontal1 = average(this.matrix[i][j], this.matrix[i][j + 1]);
                int horizontal2 = average(this.matrix[i + 1][j], this.matrix[i + 1][j + 1]);
                this.compressedMatrix[iC][jC] = average(horizontal1, horizontal2);
                jC++;
            }
            iC++;

        }

    }

    public void decompress() {
        // this is the decompress area
    }

    public void save() {
        // aqui va el codigo que guarda la verzion compress o la decompress
        System.out.println(Arrays.deepToString(matrix));
    }

    public int getMaxWith() {
        return this.maxWidth;
    }

    public int getHeight() {
        return this.height;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    private void createMatrix() {
        this.matrix = new int[this.height][this.maxWidth];
    }

    private void fillMatrix() {
        String line = "";
        int indexCounter = 0;
        try {
            BufferedReader rd = new BufferedReader(new FileReader(this.paths));
            while ((line = rd.readLine()) != null) {
                String[] values = line.split(",");

                for (int tt = 0; tt < values.length; tt++) {
                    this.matrix[indexCounter][tt] = Integer.parseInt(values[tt]);
                }
                indexCounter++;
            }

            rd.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();

        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    private void findWidthHeight() {
        String line = "";
        try {
            BufferedReader rd = new BufferedReader(new FileReader(this.paths));
            while ((line = rd.readLine()) != null) {
                String[] values = line.split(",");
                this.maxWidth = Math.max(maxWidth, values.length);
                this.height++;
            }

            rd.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
