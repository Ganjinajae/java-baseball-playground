package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 원_스트라이크_원_볼() {
        PlayResult result = com.compare(Arrays.asList(1, 3, 4));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 쓰리_스트라이크() {
        PlayResult result = com.compare(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void 낫씽() {
        PlayResult result = com.compare(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isZero();
        assertThat(result.getBall()).isZero();
    }

//    @RepeatedTest(100)
    @Test
    void 서로_다른_세자리수_생성() {
        Balls balls = new Balls();
        List<Ball> ballList = balls.getBallList();
        assertThat(ballList.get(0)).isNotEqualTo(ballList.get(1))
                .isNotEqualTo(ballList.get(2));
        assertThat(ballList.get(1)).isNotEqualTo(ballList.get(2));
    }
}
