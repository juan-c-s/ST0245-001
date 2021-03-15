public class Insertion {

    public static void main(String[] args) {
        int[] rand = new int[500];
        for (int i = 0; i < rand.length; i++) {
            rand[i] = (int) Math.round(Math.random() * 500);
        }
        long inicial = System.currentTimeMillis();
        insertionSort(rand);
        long fin = System.currentTimeMillis();
        long avg = fin - inicial;
        System.out.println(avg);
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { 
            int key = arr[i];
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

        }
        return arr;
    }
}