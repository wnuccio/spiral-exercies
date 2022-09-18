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
    void common_prefix_of_btwo_words() {
        assertEquals("a", new Words("abc", "ade").commonPrefix());
        assertEquals("ab", new Words("abc", "abe").commonPrefix());
        assertEquals("abc", new Words("abc", "abc").commonPrefix());
    }
}
