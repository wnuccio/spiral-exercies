package prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrefixTest {

    @Test
    void common_prefix_of_empty_string_is_empty() {
        assertEquals("", new Words("").commonPrefix());
    }
}
