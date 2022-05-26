//요구사항: 자연수 n을 입력받아 해당 수가 소수인지 아닌지 출력한다.
//소수이기 위한 조건: 1 이상의 자연수들 중 약수로 1과 자기 자신만을 가져야 한다.
//이를 위해서는 n을 (2 ~ n-1)의 수로 나눴을 때 나머지가 0인, 즉 나누어떨어지는 경우가 발생하지 않아야 한다.
//즉 나누는 수를 2부터 n-1의 수까지 1씩 크기를 증가시켜 나가면서
//n을 나눴을 때 나머지가 0인 경우가 발생하는지 확인한다.
//모든 경우에서 나머지가 0인 경우가 발생하지 않는다면 주어진 수는 소수이다.
//예시: n으로 7이 주어졌을 때
// 7 % 2 = 1
// 7 % 3 = 1
// 7 % 4 = 3
// 7 % 5 = 2
// 7 % 6 = 1
//>> 7은 (2 ~ 6)의 수로 나눴을 때 나누어떨어지는 경우가 발생하지 않으므로 소수이다.

import java.util.Scanner;

public class PrimeNumberThu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");

        int dividend = scanner.nextInt();

        String isPrimeNumber = "소수";

        if (dividend == 1) {
            isPrimeNumber = "소수 아님";
        }

        for (int divisor = 2 ; divisor < dividend; divisor += 1) {
            if (dividend % divisor == 0) {
                isPrimeNumber = "소수 아님";

                break;
            }
        }

        System.out.println(isPrimeNumber);
    }
}
