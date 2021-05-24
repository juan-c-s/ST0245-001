package Renderimg;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Render {

    public static void createCompressedImage(int[][] matrix, String savePath) {
        try {
            int rowMax = matrix.length;
            int colMax = matrix[0].length;
            BufferedImage img = new BufferedImage(colMax, rowMax, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    int cl = matrix[i][j];
                    Color newColor = new Color(cl, cl, cl);
                    img.setRGB(j, i, newColor.getRGB());
                }

            }
            File out = new File(savePath);
            ImageIO.write(img, "jpg", out);
        } catch (Exception e) {
            System.out.println("Error2: " + e);
        }
    }

}
