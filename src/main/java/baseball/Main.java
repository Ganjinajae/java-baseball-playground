package baseball;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Balls com = new Balls();
        boolean end = false;
        while (!end) {
            int input = InputView.show();
            int first = input / 100;
            int second = (input % 100) / 10;
            int third = input % 10;
            PlayResult result = com.compare(Arrays.asList(first, second, third));
            ResultView.show(result);
            end = ResultView.endGame(result, com);
        }
    }
}
