package baseball;

public class ResultView {

    static void show(PlayResult result) {
        if (result.getBall() > 0) {
            System.out.printf("%d볼 ", result.getBall());
        }
        if (result.getStrike() > 0) {
            System.out.printf("%d스트라이크", result.getStrike());
        }
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.print("낫씽");
        }
        System.out.println();
    }

    static boolean endGame(PlayResult result, Balls balls) {
        if (result.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            int option = InputView.showOptions();
            if (option == 2) {
                return true;
            }
            balls.makeNumbers();
        }
        return false;
    }
}
