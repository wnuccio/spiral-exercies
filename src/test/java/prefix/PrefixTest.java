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
}
