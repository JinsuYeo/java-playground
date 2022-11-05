package unit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static unit.BaseBallGame.*;

public class ApplicationTest {
	@BeforeEach
	void init() {
		String input = "123";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
	@Test
	@DisplayName("randomNumbers가 서로 다른 3자리 수인지 테스트")
	void makerandomNumbersTest() {
		ArrayList<Integer> randomNumbers = makeRandomNumbers(); 
		assertThat(randomNumbers.size() == randomNumbers.stream().distinct().count()).isTrue();
		assertThat(randomNumbers.size() == 3).isTrue();
	}
	
	@Test
	@DisplayName("randomNumbers가 1~9 사이의 수인지 테스트")
	void randomNumbersRangeTest() {
		ArrayList<Integer> randomNumbers = makeRandomNumbers(); 
		for(int num : randomNumbers) {
			assertThat(num < 10 &&  num > 0).isTrue();
		}
	}
	
}
