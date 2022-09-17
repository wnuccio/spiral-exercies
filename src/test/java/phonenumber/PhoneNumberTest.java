package phonenumber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberTest {
    @Test
    void the_map_returns_letters_for_any_digit() {
        assertTrue(Arrays.equals(new Phone().charsOf('2'), new char[]{'a', 'b', 'c'}));
        assertTrue(Arrays.equals(new Phone().charsOf('3'), new char[]{'d', 'e', 'f'}));
    }
}
