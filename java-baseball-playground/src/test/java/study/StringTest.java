package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("replace 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    @DisplayName("split 테스트")
    void split() {
    	String actual = "1,2";
    	assertThat(actual.split(",")).containsExactly("1","2");
    	actual = "1";
    	assertThat(actual.split(",")).containsExactly("1");
    }
    
    @Test
    @DisplayName("substring 테스트")
    void substring() {
    	String actual = "(1,2)";
    	assertThat(actual.substring(1, actual.length() - 1));
    }
    
    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
    	String actual = "abc";
    	assertThatThrownBy(() -> {
    		actual.charAt(4);
    	}).isInstanceOf(IndexOutOfBoundsException.class)
    	.hasMessageContaining("4");
    }
}
