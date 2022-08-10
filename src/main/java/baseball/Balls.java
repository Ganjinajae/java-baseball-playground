package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {
    private List<Ball> ballList;

    public Balls() {
        this.makeNumbers();
    }

    public Balls(List<Integer> numbers) {
        this.ballList = mapper(numbers);
    }

    private List<Ball> mapper(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public PlayResult compare(List<Integer> input) {
        PlayResult result = new PlayResult();
        Balls inputBalls = new Balls(input);
        for (Ball ball : ballList) {
            BallStatus status = inputBalls.compare(ball);
            result.report(status);
        }
        return result;
    }

    private BallStatus compare(Ball input) {
        return ballList.stream()
                .map(ball -> ball.compare(input))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public void makeNumbers() {
        clear();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = new Random().nextInt(9) + 1;
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        this.ballList = mapper(list);
        printNumbers();
    }

    private void printNumbers() {
        System.out.println(
                "(" +
                        this.ballList.get(0)
                        + ", "
                        + this.ballList.get(1)
                        + ", "
                        + this.ballList.get(2)
                        + ")");
    }

    private void clear() {
        if (ballList != null) {
            ballList.clear();
        }
    }

    public List<Ball> getBallList() {
        return ballList;
    }
}
