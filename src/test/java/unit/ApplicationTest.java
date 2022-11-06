package unit;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static unit.BaseBallGame.*;
import static unit.ResultView.*;
import static unit.InputView.*;

public class ApplicationTest {
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
	
	@Test
	@DisplayName("userInputNumbers가 서로 다른 3자리 수인지 테스트")
	void userInputNumbersTest() {
		int input = 123;
		ArrayList<Integer> userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isTrue();
		assertThat(userInputNumbers.size() == 3).isTrue();
		
		input = 113;
		userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isFalse();
		assertThat(userInputNumbers.size() == 3).isTrue();
		
		input = 1023;
		userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isTrue();
		assertThat(userInputNumbers.size() == 3).isFalse();
	}
	
	@Test	
	@DisplayName("두 수 비교하여 stike 테스트")
	void  strikeTest() {
		assertThat(BaseBallGame.isStrike(1, 1)).isTrue();
		assertThat(BaseBallGame.isStrike(1, 2)).isFalse();
	}
	
	@Test	
	@DisplayName("두 수 비교하여 ball 테스트")
	void  ballTest() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(7); test.add(1); test.add(3);
		assertThat(BaseBallGame.isBall(test, 1)).isTrue();
		assertThat(BaseBallGame.isBall(test, 2)).isFalse();
	}
}
