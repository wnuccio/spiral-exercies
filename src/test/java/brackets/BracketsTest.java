package brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BracketsTest {
    @Test
    void an_empty_string_is_valid() {
        assertEquals(true, new Brackets("").isValid());
    }
}
