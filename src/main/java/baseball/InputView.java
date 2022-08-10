package baseball;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int show() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }

    public static int showOptions() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}
