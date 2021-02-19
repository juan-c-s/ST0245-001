
public class VolumenMax {
    public static void main(String[] argumento) {
        int[] arr = new int[36];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random() * 5000);
        }
        long start = System.currentTimeMillis();
        subVolumen(arr, 30, 0);
        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println(time);
    }

    public static boolean subVolumen(int[] objetos, int total, int index) {
        if (index >= objetos.length) {
            return total == 0;
        }
        return subVolumen(objetos, total - objetos[index], index + 1) || subVolumen(objetos, total, index + 1);
    }
}
