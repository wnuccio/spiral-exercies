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

    @Test
    void a_double_round_bracket_string_is_valid() {
        assertTrue(new Brackets("(())").isValid());
        assertTrue(new Brackets("()()").isValid());
        assertTrue(new Brackets("((()").isNotValid());
        assertTrue(new Brackets(")())").isNotValid());
        assertTrue(new Brackets(")()(").isNotValid());
        assertTrue(new Brackets("))))").isNotValid());
    }

    @Test
    void a_string_whose_length_is_odd_is_not_valid() {
        assertTrue(new Brackets("(").isNotValid());
        assertTrue(new Brackets("())").isNotValid());
    }

    @Test
    void a_couple_of_square_brackets_is_valid_or_not() {
        assertTrue(new Brackets("[]").isValid());
        assertTrue(new Brackets("]]").isNotValid());
        assertTrue(new Brackets("[[").isNotValid());
        assertTrue(new Brackets("][").isNotValid());
    }

    @Test
    void a_mix_of_different_brackets_is_not_valid() {
        assertTrue(new Brackets("(]").isNotValid());
        assertTrue(new Brackets("[)").isNotValid());
        assertTrue(new Brackets(")]").isNotValid());
        assertTrue(new Brackets("([").isNotValid());
    }

    @Test
    void is_valid_only_if_the_closed_bracket_does_match_the_last_opened() {
        assertTrue(new Brackets("([])").isValid());
        assertTrue(new Brackets("[()]").isValid());
        assertTrue(new Brackets("((]())").isNotValid());
        assertTrue(new Brackets("([)())").isNotValid());
        assertTrue(new Brackets("((()()])").isNotValid());
    }

    @Test
    void manage_curly_brackets() {
        assertTrue(new Brackets("{").isNotValid());
        assertTrue(new Brackets("{}").isValid());
        assertTrue(new Brackets("({})").isValid());
        assertTrue(new Brackets("(){}").isValid());
        assertTrue(new Brackets("({)}").isNotValid());
    }
}
