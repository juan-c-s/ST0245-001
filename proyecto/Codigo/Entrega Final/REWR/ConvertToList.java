package REWR;

public class ConvertToList {
    public static int columnas;

    public static int[] convertMatrixToList(int[][] m) {
        int[] newList = new int[m.length * m[0].length];
        int listIndex = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; ++j) {
                newList[listIndex] = m[i][j];
                listIndex++;
            }
        }
        return newList;
    }

    public static int[][] convertListToMatrix(int[] list, int column) {
        int height = list.length / column;
        int[][] m = new int[height][column];
        int index = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < column; j++) {
                m[i][j] = list[index++];
            }
        }
        return m;
    }

}
