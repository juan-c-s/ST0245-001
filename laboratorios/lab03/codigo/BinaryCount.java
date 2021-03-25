import java.util.ArrayList;

public class BinaryCount {
    public static void main(String[] argumento) {
        ArrayList<Character> str = new ArrayList<>();
        str.add('1');
        str.add('1');
        str.add('0');
        str.add('1');
        System.out.println(convertir(str));
    }

    public static int convertir(ArrayList<Character> str) {
        int res = 0;
        for (int i = 0; i < str.size(); i++) {
            res += (str.get(i) - '0') * Math.pow(2, i);
        }
        return res;
    }
}
