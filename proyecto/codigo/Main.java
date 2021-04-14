
public class Main {
    public static void main(String[] argumento) {
        CSVFile csv = new CSVFile("04be43ab919b6b22d950d3b59834f4a1.csv", true, false, 3);
        csv.createOriginalImage();
        csv.createCompressedImage();
        csv.decompress();
        csv.createDecompressedImage();

    }
}
