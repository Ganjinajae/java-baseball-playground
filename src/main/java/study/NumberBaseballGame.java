package study;

import java.util.Random;
import java.util.Scanner;

/**
 * 숫자 야구 게임 구현
 */
public class NumberBaseballGame {

    static Scanner scanner = new Scanner(System.in);
    static String number;
    static int strike = 0;
    static int ball = 0;
    static boolean end = false;

    public static void main(String[] args) {
        number = makeNumber();
        while (!end) {
            strike = 0;
            ball = 0;
            System.out.print("숫자를 입력해 주세요 : ");
            String input = scanner.nextLine();
            compareNumber(input);
            printResult();
            check3Strikes();
        }
    }

    static void checkEnd(String input) {
        if (input.equals("1")) {
            number = makeNumber();
        }
        if (input.equals("2")) {
            end = true;
        }
    }

    static void check3Strikes() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = scanner.nextLine();
            checkEnd(s);
        }
    }

    static void printResult() {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("포볼");
        }
        System.out.println();
    }

    static void compareNumber(String input) {
        for (int i=0; i<3; i++) {
            char actualNumber = number.charAt(i);
            for (int j=0; j<3; j++) {
                char inputNumber = input.charAt(j);
                if (actualNumber == inputNumber) {
                    if (i == j) {
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }
    }

    static String makeNumber() {
        String number = "";
        number += new Random().nextInt(9) + 1;
        while(number.length() < 3) {
            int randomNumber = new Random().nextInt(9) + 1;
            if (number.contains(String.valueOf(randomNumber))) {
                continue;
            }
            number += randomNumber;
        }
        System.out.println("만들어진 숫자: " + number);
        return number;
    }

}
