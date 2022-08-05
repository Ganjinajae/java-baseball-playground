package study;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    Scanner scanner = new Scanner("2 + 3 * 4 / 2");

    @Test
    void calculator() {
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        int result = calculate(values);
        assertThat(result).isEqualTo(10);
    }

    int calculate(String[] values) {
        int total = Integer.parseInt(values[0]);
        for (int i=1; i<values.length; i++) {
            String value = values[i];
            if(isOperator(value)) {
                if(value.equals("+")) {
                    total += Integer.parseInt(values[++i]);
                } else if(value.equals("-")) {
                    total -= Integer.parseInt(values[++i]);
                } else if(value.equals("*")) {
                    total *= Integer.parseInt(values[++i]);
                } else if(value.equals("/")) {
                    total /= Integer.parseInt(values[++i]);
                }
            }
        }
        return total;
    }

    boolean isOperator(String value) {
        if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
            return true;
        }
        return false;
    }
}
