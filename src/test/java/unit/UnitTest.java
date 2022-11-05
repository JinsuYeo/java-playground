package unit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class UnitTest {
	@Nested
	class StringCalculatorTest {
		StringCalculator stringCalculator;
		
		@BeforeEach
		void init() {
			String input = "2 + 3 * 4 / 2";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			stringCalculator = new StringCalculator();
			stringCalculator.init();
		}
		
		@Test
		void calc() {
			int result = 10;
			assertEquals(stringCalculator.calc(), result);
		}
	}

	
}
