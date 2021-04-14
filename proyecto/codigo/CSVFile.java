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
    private int multiploCompresion;
    private int[][] matrix;
    private int[][] compressedMatrix;
    private int[][] decompressed;

    CSVFile(String path, boolean compress, boolean decompress, int multiploCompresion) {
        this.paths = path;
        this.findWidthHeight();
        this.createMatrix();
        this.fillMatrix();
        if (compress) {
            this.compress(multiploCompresion);
        }
        if (decompress) {
            this.decompress();
        }

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

    public void createCompressedImage() {
        try {
            int rowMax = this.compressedMatrix.length;
            int colMax = this.compressedMatrix[0].length;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = this.compressedMatrix[i][j];
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

    public void createDecompressedImage() {
        try {
            int rowMax = this.decompressed.length;
            int colMax = this.decompressed[0].length;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = this.decompressed[i][j];
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

    // Average method
    public int average(int x, int y) {
        return (x + y) / 2;
    }

    public int[][] getCompressedMat() {
        return this.compressedMatrix;
    }

    // interpolation algorithm
    public void compress(int multiploCompresion) {
        int[][] temp = new int[height / 2][maxWidth / 2];
        int[][] nuevaImagenGrande = this.matrix;
        this.multiploCompresion = multiploCompresion;
        for (int w = 0; w < this.multiploCompresion; w++) {

            this.compressedMatrix = temp;
            int iC = 0;
            int jC = 0;
            // Contadores de compressed Matrix
            for (int i = 0; i < this.compressedMatrix.length * 2 && iC < this.compressedMatrix.length; i += 2) {
                jC = 0;
                for (int j = 0; j < this.compressedMatrix[0].length * 2
                        && jC < this.compressedMatrix[0].length; j += 2) {
                    int horizontal1 = average(nuevaImagenGrande[i][j], nuevaImagenGrande[i][j + 1]);
                    int horizontal2 = average(nuevaImagenGrande[i + 1][j], nuevaImagenGrande[i + 1][j + 1]);
                    this.compressedMatrix[iC][jC] = average(horizontal1, horizontal2);
                    jC++;
                }
                iC++;

            }
            nuevaImagenGrande = this.compressedMatrix;
            temp = new int[this.compressedMatrix.length / 2][this.compressedMatrix[0].length / 2];
        }

    }

    public void decompress() {
        // this is the decompress area
        int[][] temp = new int[this.compressedMatrix.length * 2][this.compressedMatrix[0].length * 2];
        int[][] nuevaImagenPequeña = this.compressedMatrix;
        for (int w = 0; w < this.multiploCompresion; w++) {

            int compressedHeight = nuevaImagenPequeña.length;
            int compressedWidth = nuevaImagenPequeña[0].length;

            this.decompressed = temp;
            int iD = 0;
            int jD = 0;
            for (int i = 0; i < compressedHeight * 2 && iD < compressedHeight; i += 2) {
                jD = 0;
                for (int j = 0; j < compressedWidth * 2 && jD < compressedWidth; j += 2) {
                    this.decompressed[i][j] = nuevaImagenPequeña[iD][jD];
                    this.decompressed[i + 1][j] = nuevaImagenPequeña[iD][jD];
                    this.decompressed[i + 1][j + 1] = nuevaImagenPequeña[iD][jD];
                    this.decompressed[i][j + 1] = nuevaImagenPequeña[iD][jD];
                    jD++;
                }

                iD++;
            }
            nuevaImagenPequeña = this.decompressed;
            temp = new int[decompressed.length * 2][decompressed[0].length * 2];
        }
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
