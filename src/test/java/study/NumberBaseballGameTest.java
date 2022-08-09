package study;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    @Test
    void makeNumber() throws NoSuchAlgorithmException {
        String s = NumberBaseballGame.makeNumber();
        String[] stringArr = s.split("");
        assertThat(stringArr[0])
                .isNotEqualTo(stringArr[1])
                .isNotEqualTo(stringArr[2]);
        assertThat(stringArr[1]).isNotEqualTo(stringArr[2]);
    }
}
