package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int ints) {
		assertThat(numbers.contains(ints)).isTrue();
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsValueIsTrueOrFalse(int input, boolean expected) {
		boolean actualValue = numbers.contains(input);
		assertEquals(expected, actualValue);
	}
}
