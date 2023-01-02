package racingCar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {
    String validDelimeterNames = "pobi,crong,honux";
    String notValidDelimeterNames = "pobi,crong,honux,jinsoo";

    @Test
    void 자동차_이름_길이_테스트() {
        String validCarName = "pobi";
        assertThat(InputView.isValidLength(validCarName)).isTrue();
        String notValidCarName = "jinsoo";
        assertThat(InputView.isValidLength(notValidCarName)).isFalse();
    }

    @Test
    @Description("입력된 문자열을 쉼표 기준으로 구분할 수 있는지 테스트")
    void 입력_문자열_split_테스트() {
        assertThat(InputView.splitNames(validDelimeterNames)).isEqualTo(Arrays.asList("pobi","crong","honux"));
    }

    @Test
    @Description("입력된 문자열이 유효할 때, 자동차 이름 배열로 변환되는지 테스트(아닐 경우 예외 발생)")
    void 자동차_이름_배열_생성_테스트() {
        assertThat(InputView.createCarNames(validDelimeterNames)).isEqualTo(Arrays.asList("pobi","crong","honux"));
        assertThatThrownBy(() -> {
            InputView.createCarNames(notValidDelimeterNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("배열의 자동차 이름 길이가 5자 이내가 아니면 예외 발생하는지 테스트")
    void 배열_자동차_이름_길이_테스트() {
        assertThatThrownBy(() -> {
            InputView.checkCarNames(Arrays.asList("pobi", "honux", "jinsoo"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
