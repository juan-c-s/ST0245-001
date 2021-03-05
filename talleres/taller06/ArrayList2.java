
public class ArrayList2 {
    private int size;
    private int vectorSize;
    private int[] list;
    public static int tamañoDefault = 10;

    public ArrayList2() {
        this.vectorSize = tamañoDefault;
        this.list = new int[vectorSize];
    }

    public ArrayList2(int initialSize) {
        this.vectorSize = initialSize;
        this.list = new int[vectorSize];
    }

    public int size() {
        return this.size;
    }

    public void addElement(int el) {
        if (size + 1 <= vectorSize) {
            list[size] = el;
            size++;
        } else {
            this.vectorSize += tamañoDefault;
            int[] listaux = new int[vectorSize];
            for (int i = 0; i < size; i++) {

                listaux[i] = list[i];
            }
            this.list = listaux;
            this.list[size] = el;
            this.size++;
        }
    }

    public int at(int index) {
        return list[index];
    }

    public int search(int num) {
        for (int i = 0; i < size; i++) {
            if (list[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    public void delete(int index) {
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
                index++;
            }

        }
        list[size - 1] = 0;
        size--;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                str += list[i] + ", ";
            } else
                str += list[i] + "]";
        }

        return str;
    }
    // public void eraseElement(int el) {
    // if (size + 1 <= vectorSize) {
    // list[size] = el;
    // size++;
    // } else {

    // }
    // }

}