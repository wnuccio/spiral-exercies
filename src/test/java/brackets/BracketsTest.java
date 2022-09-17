package brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BracketsTest {
    @Test
    void an_empty_string_is_valid() {
        assertEquals(true, new Brackets("").isValid());
    }

//    @Test
//    void a_couple_of_brackets_is_valid_or_not() {
//        assertTrue(new Brackets("()").isValid());
//        assertTrue(new Brackets("((").isNotValid());
//        assertTrue(new Brackets("))").isNotValid());
//        assertTrue(new Brackets(")(").isNotValid());
//    }

//    @Test
//    void a_couple_of_square_brackets_is_valid_or_not() {
//        assertTrue(new Brackets("[]").isValid());
//        assertTrue(new Brackets("]]").isNotValid());
//        assertTrue(new Brackets("[[").isNotValid());
//        assertTrue(new Brackets("][").isNotValid());
//    }
//
//    @Test
//    void a_double_round_bracket_string_is_valid() {
//        assertTrue(new Brackets("(())").isValid());
//        assertTrue(new Brackets("((()").isNotValid());
//        assertTrue(new Brackets(")(()").isNotValid());
//    }
//
//    @Test
//    void a_string_whose_length_is_odd_is_not_valid() {
//        assertTrue(new Brackets("(((").isNotValid());
//        assertTrue(new Brackets("(()").isNotValid());
//        assertTrue(new Brackets("()(").isNotValid());
//        assertTrue(new Brackets("())").isNotValid());
//        assertTrue(new Brackets(")((").isNotValid());
//        assertTrue(new Brackets(")()").isNotValid());
//        assertTrue(new Brackets("))(").isNotValid());
//        assertTrue(new Brackets(")))").isNotValid());
//        assertTrue(new Brackets("((())").isNotValid());
//    }
}
