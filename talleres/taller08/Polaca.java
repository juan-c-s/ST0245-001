import java.util.Stack;

public class Polaca {
    private Stack<String> expresion = new Stack<>();

    public Polaca(String s) {
        String sList[] = s.split(" ");
        for (int i = 0; i < sList.length; i++) {
            expresion.push(sList[sList.length - 1 - i]);
        }

    }

    public int answer() {
        char operator;
        int left;
        int right;
        int answer = -1;
        while (expresion.size() != 0) {
            if (answer == -1) {
                left = Integer.parseInt(expresion.pop());

            } else {
                left = answer;

            }

            right = Integer.parseInt(expresion.pop());

            operator = expresion.pop().charAt(0);

            answer = operator(operator, left, right);

        }

        return answer;
    }

    public int operator(char c, int a, int b) {
        if (c == '*') {
            return a * b;
        } else if (c == '/') {
            return a / b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '+') {
            return a + b;
        } else
            return a % b;
    }

    public boolean isOperator(String c) {
        if (c.equals("*")) {
            return true;
        } else if (c.equals("/")) {
            return true;
        } else if (c.equals("-")) {
            return true;
        } else if (c.equals("+")) {
            return true;
        } else
            return false;
    }

    public static void main(String args[]) {
        Polaca calc = new Polaca("6 5 - 4 +");

        System.out.println(calc.answer());
    }

}