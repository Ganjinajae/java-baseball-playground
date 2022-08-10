package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 2);
    }

    @Test
    void 스트라이크_판정() {
        BallStatus status = com.compare(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼_판정() {
        BallStatus status = com.compare(new Ball(0, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱_판정() {
        BallStatus status = com.compare(new Ball(0, 1));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
