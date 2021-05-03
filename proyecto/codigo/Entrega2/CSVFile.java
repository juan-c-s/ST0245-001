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



    CSVFile(String path, boolean compress, boolean decompress, int multiploCompresion) {
        this.paths = path;
        this.findWidthHeight();
        this.createMatrix();
        this.fillMatrix();

    }


    public void saveCompressedMatrix(){
        Writer writerMachine = new Writer("./","data.txt");
        writerMachine.saveCompressFile(this.matrix,Huffman.table);
    }

    public void readEncodedCompresedFile(){
        Writer writerMachine = new Writer("./","data.txt");
        int[][] newMatrix =  writerMachine.readCompressed(new int[matrix.length][matrix[0].length],Huffman.tableCodes);
        createCompressedImage(newMatrix);

    }


    public void createOriginalImage() {
        try {
            int rowMax = height;
            int colMax = maxWidth;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = this.matrix[i][j];
                    Color newColor = new Color(cl, cl, cl);
                    img.setRGB(j, i, newColor.getRGB());
                }

            }
            File out = new File("Original.jpg");
            ImageIO.write(img, "jpg", out);
        } catch (Exception e) {
            System.out.println("Error2: " + e);
        }
    }

    public void createCompressedImage(int[][] matrix) {
        try {
            int rowMax = height;
            int colMax = maxWidth;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = matrix[i][j];
                    Color newColor = new Color(cl, cl, cl);
                    img.setRGB(j, i, newColor.getRGB());
                }

            }
            File out = new File("DeCompressed.jpg");
            ImageIO.write(img, "jpg", out);
        } catch (Exception e) {
            System.out.println("Error2: " + e);
        }
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
