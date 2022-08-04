package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String numberString = "1,2";
        String[] numberArr = numberString.split(",");
        assertThat(numberArr[0]).isEqualTo("1");
        assertThat(numberArr[1]).isEqualTo("2");
        numberString = "1";
        numberArr = numberString.split(",");
        assertThat(numberArr).hasSize(1);
        assertThat(numberArr[0]).isEqualTo("1");
    }

    @Test
    void subString() {
        String numberStringInBracket = "(1,2)";
        String numberString = numberStringInBracket.substring(1, 4);
        assertThat(numberString).isEqualTo("1,2");
    }

    @DisplayName("특정 위치 문자 가져오기")
    @Test
    void charAt() {
        String given = "abc";
        char c = given.charAt(0);
        assertThat(c).isEqualTo('a');
        assertThatThrownBy(() -> {
            given.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
