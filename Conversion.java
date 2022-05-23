import java.text.DecimalFormat;
import java.util.Stack;
import java.util.Scanner;

public class Conversion {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#");
        Stack<Double> stack = new Stack<Double>();

        System.out.print("Input: ");

        double dividend = scanner.nextDouble();

        final int DIVISOR = 5;
        int answer = 0;

        while (dividend > 0) {
            double remainder = dividend % DIVISOR;
            dividend = Math.floor(dividend / DIVISOR);
            stack.push(remainder);
        }

        double multiplicand = Math.pow(10, (stack.size() - 1));

        while (!stack.empty()) {
            answer += stack.pop() * multiplicand;
            multiplicand /= 10;
        }

        System.out.println("5 진수: " + form.format(answer));
    }
}
