package racingCar;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    Car car;

    @BeforeEach
    void init() {
        this.car = new Car("pobi");
    }

    @Test
    @Description("생성된 수가 4 이상일 경우에만 전진하는지 테스트")
    void 차_전진_조건_테스트() {
        assertFalse(car.isMoved(0));
        assertTrue(car.isMoved(4));
        assertTrue(car.isMoved(5));
    }

    @Test
    @Description("차 전진 횟수 올바른지 테스트")
    void 차_전진_테스트() {
        car.move(4);
        car.move(4);
        car.move(4);
        assertThat(car.countMoving()).isEqualTo(3);
    }
}
