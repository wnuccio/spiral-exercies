package prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrefixTest {

    @Test
    void common_prefix_of_one_word_is_the_word() {
        assertEquals("", new Words("").commonPrefix());
        assertEquals("h", new Words("h").commonPrefix());
        assertEquals("house", new Words("house").commonPrefix());
    }

    @Test
    void common_prefix_of_more_equals_word_is_the_word() {
        assertEquals("one", new Words("one", "one").commonPrefix());
        assertEquals("one", new Words("one", "one", "one").commonPrefix());
    }

    @Test
    void common_prefix_of_two_same_length_words() {
        assertEquals("", new Words("", "").commonPrefix());
        assertEquals("", new Words("a", "b").commonPrefix());
        assertEquals("a", new Words("a", "a").commonPrefix());
        assertEquals("a", new Words("ab", "ac").commonPrefix());
        assertEquals("ab", new Words("ab", "ab").commonPrefix());
        assertEquals("a", new Words("abc", "ade").commonPrefix());
        assertEquals("ab", new Words("abc", "abe").commonPrefix());
        assertEquals("abc", new Words("abc", "abc").commonPrefix());
    }

    @Test
    void common_prefix_of_two_different_length_words() {
//        assertEquals("a", new Words("abc", "ade").commonPrefix());
    }
}
