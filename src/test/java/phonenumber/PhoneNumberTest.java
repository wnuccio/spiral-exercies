package phonenumber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {
    @Test
    void for_empty_string_return_no_combination() {
        assertEquals(Collections.emptyList(), new PhoneNumber("").combinations());
    }

    @Test
    void for_one_digit_string_returns_all_chars() {
        assertEquals(Arrays.asList("a", "b", "c"), new PhoneNumber("2").combinations());
        assertEquals(Arrays.asList("d", "e", "f"), new PhoneNumber("3").combinations());
        assertEquals(Arrays.asList("g", "h", "i"), new PhoneNumber("4").combinations());
        assertEquals(Arrays.asList("p", "q", "r", "s"), new PhoneNumber("7").combinations());
    }
}
