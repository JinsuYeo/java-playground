package racingCar;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {
    CarGame carGame;
    CarGame carsGame;

    @BeforeEach
    void init() {
        this.carGame = new CarGame(Arrays.asList("pobi"));
        this.carsGame = new CarGame(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    @Description("차가 전진한 결과가 올바른지 테스트")
    void 차_전진_결과_테스트() {
        carGame.moveCar(4);
        assertThat(carGame.getMovingResult()).isEqualTo(Arrays.asList("--"));
        carsGame.moveCar(4);
        assertThat(carsGame.getMovingResult()).isEqualTo(Arrays.asList("--", "--", "--"));
    }

    @Test
    @Description("우승자가 올바르게 선택되는지 테스트")
    void 우승자_테스트() {
        carGame.moveCar(4);
        assertThat(carGame.getWinner()).isEqualTo(Arrays.asList("pobi"));
        carsGame.moveCar(4);
        assertThat(carsGame.getWinner()).isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }
}
