package brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracketsTest {
    @Test
    void an_empty_string_is_valid() {
        assertEquals(true, new Brackets("").isValid());
    }

    @Test
    void a_couple_of_brackets_is_valid_or_not() {
        assertTrue(new Brackets("()").isValid());
        assertTrue(new Brackets("((").isNotValid());
        assertTrue(new Brackets("))").isNotValid());
        assertTrue(new Brackets(")(").isNotValid());
    }
}
