import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalulatorTest {
    @Test
    void 숫자_테스트() {
        assertThat(Calculator.isInt("1")).isTrue();
        assertThatThrownBy(() -> Calculator.isInt("a")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_테스트() {
        assertThat(Calculator.isDelimeter(":")).isTrue();
        assertThat(Calculator.isDelimeter(",")).isTrue();
        assertThat(Calculator.isDelimeter(".")).isFalse();
    }

}
