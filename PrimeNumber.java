import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);


        //입력
        System.out.print("n: ");

        int userInput = scanner.nextInt();


        //처리
        boolean isPrimeNumber = true;

        if (userInput < 2) {
            isPrimeNumber = false;
        }

        if (userInput >= 2) {
            for (int i = 2; i <= userInput - 1; i += 1) {
                if (userInput % i == 0) {
                    isPrimeNumber = false;

                    break;
                }
            }
        }


        //출력
        if (!isPrimeNumber) {
            System.out.println("소수 아님");
        }
        if (isPrimeNumber) {
            System.out.println("소수");
        }
    }
}
