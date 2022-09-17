package phonenumber;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {
    @Test
    void the_map_returns_letters_for_any_digit() {
        Map<Character, char[]> map = new PhoneNumber().map;
        assertEquals('a', map.get('2')[0]);
        assertEquals('b', map.get('2')[1]);
        assertEquals('c', map.get('2')[2]);
    }
}
