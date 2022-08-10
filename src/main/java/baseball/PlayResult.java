package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }


    public boolean isGameEnd() {
        return strike == 3;
    }
}