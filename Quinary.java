// 요구사항: 숫자가 주어지면 5진수로 변환한다. (출력은 10진수 스타일로 출력한다.)
// 주어진 10진수를 5진수로 변환하는 과정은?
//- 주어진 수를 5로 나눠 몫과 나머지를 구한다.
//- 나머지에 자릿수 위치를 지정해줄 수 있는 수를 곱한다. 곱한 결과는 최종 결과에서 10^(n-1)자릿수에 해당한다. (n: 최초의 수를 5로 나눈 횟수) 곱한 결과를 최종 결과에 더한다.
//- 구해진 몫을 또다시 5로 나눠 몫과 나머지를 구한다.
//- 나머지에 자릿수 위치를 지정해줄 수 있는 수를 또다시 곱해 그 결과를 최종 결과에 더한다.
//- 위의 과정을 구해지는 몫이 0이 도출될 때까지 반복한다.
//- 최종 결과를 출력한다.

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quinary {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#");

        boolean isValidInput = false;

        //최초 출력
        System.out.print("Input: ");

        //메인 루프
        do {
            //입력
            double dividend = scanner.nextDouble();            //나눠지는 수

            if (dividend <= 0 || dividend - Math.floor(dividend) != 0) {
                System.out.print("자연수를 입력하세요: ");
                continue;
            } else {
                isValidInput = true;
            }

            final double DIVISOR = 5;           //나누는 수

            double digit = 1;                   //각각의 나머지 값이 최종 결과에서 갖는 자릿수 위치
            double result = 0;                  //최종 결과

            //처리
            while (dividend != 0) {
                double quotient = Math.floor(dividend / DIVISOR);           //나눈 몫
                double remainder = dividend % DIVISOR;                      //나눈 몫의 나머지

                result += remainder * digit;            //최종 결과에 나머지 값에 자릿수를 지정한 값을 더함
                dividend = quotient;                    //나눠지는 수를 새로 구해진 몫으로 갱신
                digit *= 10;                            //지정할 자릿수에 10을 곱하여 자릿수를 갱신
            }

            //출력
            System.out.println("5 진수: " + form.format(result));
        } while (!isValidInput);
    }
}
