import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalulatorTest {
    @Test
    void 숫자_테스트() {
        assertThat(Calculator.isInt("1")).isTrue();
        assertThatThrownBy(() -> Calculator.isInt("a")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> Calculator.isInt(" ")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_테스트() {
        assertThat(Calculator.isDelimeter(":")).isTrue();
        assertThat(Calculator.isDelimeter(",")).isTrue();
        assertThat(Calculator.isDelimeter(".")).isFalse();
    }

    @Test
    void 양수_테스트() {
        assertThat(Calculator.isPositive("1")).isTrue();
        assertThatThrownBy(() -> Calculator.isPositive("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_테스트() {
        assertThat(Calculator.splitAndSum("1")).isEqualTo(1);
        assertThat(Calculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(Calculator.splitAndSum("1,2:3")).isEqualTo(6);
        assertThat(Calculator.splitAndSum("//;\n1,2:3;4")).isEqualTo(10);
    }
}
