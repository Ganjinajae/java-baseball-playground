package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        } else if (ball.matchBallNo(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNumber) {
        return this.number == ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
