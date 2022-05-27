//요구사항: 로마 숫자를 그에 맞는 10진수로 변환한다.
//조건
// - I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000
// - 나열된 로마자 숫자들을 봤을 때
//   - 이전 숫자가 다음 숫자보다 작은 경우에는, 큰 숫자에서 작은 숫자를 뺀다.
//   - 이전 숫자가 다음 숫자보다 크거나 같은 경우에는, 두 숫자를 더한다.
//Test Cases
// I            1 >> 1 >> 1
// II           1,1 >> 1+1 >> 2
// III          1,1,1, >> 1+1+1 >> 3
// IV           1,5 >> -1+5 >> 4
// VII          5,1,1, >> 5+1=1 >> 7
// X            10 >> 10 >> 10
// XIV          10,1,5 >> 10-1+5 >> 14
// XXXIX        10,10,10,1,10 >> 10+10+10-1+10 >> 39
// LX           50,10 >> 50+10 >> 60
// CCXLVI       100,100,10,50,5,1 >> 100+100-10+50+5+1 >> 246
// CCVII        100,100,5,1,1 >> 100+100+5+1+1 >> 207
// DLIII        500,50,1,1,1 >> 500+50+1+1+1 >> 553
// MLXVI        1000,50,10,5,1 >> 1066
// MDCCLXXVI    1000,500,100,100,50,10,10,5,1 >> 1000+500+100+100+50+10+10+5+1 >> 1776
// MCMLIV       1000,100,1000,50,1,5 >> 1000-100+1000+50-1+5 >> 1954
//
// 반복문으로 전체 문자를 순차적으로 확인한다.
// 이때 특정 숫자를 전체 결과에 더해줄지 뺄지는 그 다음 숫자에 달려 있으므로,
// 특정 숫자를 확인할 때 그 다음 숫자의 크기를 확인하여 어떤 연산을 수행해줄지 결정한다.


import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("로마 숫자: ");
        String userInput = scanner.nextLine();

        final char[] ROMAN_NUMBER_ALPHABET = new char[]{ 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        final int[] ROMAN_NUMBER_SIZE = new int[]{ 1, 5, 10, 50, 100, 500, 1000 };

        int decimalNumberResult = 0;

        //String의 길이는 String.length()
        for (int i = 0; i < userInput.length(); i += 1) {
            //String 각각의 문자에 인덱스로 접근하려면 userInput.charAt(인덱스)
            char currentAlphabet = userInput.charAt(i);
            char nextAlphabet = ' ';
            int currentAlphabetSize = 0;
            int nextAlphabetSize = 0;

            if (i < userInput.length() - 1) {
                nextAlphabet = userInput.charAt(i + 1);
            }

            for (int j = 0; j < ROMAN_NUMBER_ALPHABET.length; j += 1) {
                if (currentAlphabet == ROMAN_NUMBER_ALPHABET[j]) {
                    currentAlphabetSize = ROMAN_NUMBER_SIZE[j];
                }

                if (nextAlphabet == ROMAN_NUMBER_ALPHABET[j]) {
                    nextAlphabetSize = ROMAN_NUMBER_SIZE[j];
                }
            }

            //String의 특정 index의 문자의 숫자 크기값이 index + 1의 문자의 숫자 크기값보다 크면
            //최종 결과에 index의 숫자 크기값을 더해줌

            if (i == userInput.length() - 1) {
                decimalNumberResult += currentAlphabetSize;
                break;
            }

            if (currentAlphabetSize >= nextAlphabetSize) {
                decimalNumberResult += currentAlphabetSize;
            }

            if (currentAlphabetSize < nextAlphabetSize) {
                decimalNumberResult -= currentAlphabetSize;
            }
        }

        System.out.println("아라비아 숫자: " + decimalNumberResult);
    }
}
