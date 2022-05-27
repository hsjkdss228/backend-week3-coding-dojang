//요구사항: 10진수가 주어지면 16진수 형태로 변환하여 출력한다.
// - 16진수란? 10진수의 10~15에 해당하는 수를 A(10), B(11), C(12), D(13), E(14), F(15)로 나타낼 수 있다.
//
//Test Cases
// 0 >> 0
// 12 >> C
// 10 >> A
// 128 >> 80
// 918 >> 3D5
// 1028 >> 404
// 4893 >> 131D
// 19284 >> 4D54
// 183748 >> 2CDC4

import java.util.Scanner;

public class Hexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("10진수를 입력해주세요: ");

        int userInput = scanner.nextInt();

        String hexadecimalNumberReversed = "";
        final char[] HEXADECIMAL_NUMBER_CHARACTER = new char[]{ 'A', 'B', 'C', 'D', 'E', 'F' };
        final int DIVISOR = 16;

        if (userInput == 0) {
            hexadecimalNumberReversed += 0;
        }

        while (userInput > 0) {
            int remainder = userInput % DIVISOR;

            String remainderToHexadecimal = "";

            if (remainder <= 9) {
                remainderToHexadecimal += remainder;
            }
            if (remainder >= 10) {
                remainderToHexadecimal += HEXADECIMAL_NUMBER_CHARACTER[remainder - 10];
            }

            hexadecimalNumberReversed += remainderToHexadecimal;
            userInput /= DIVISOR;
        }

        String hexadecimalNumber = "";

        for (int i = hexadecimalNumberReversed.length() - 1; i >= 0; i -= 1) {
            hexadecimalNumber += hexadecimalNumberReversed.charAt(i);
        }

        System.out.println("16진수: " + hexadecimalNumber);
    }
}
