package zigzag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagTest {
    @Test
    void convert_single_letter() {
        String result = new ZigZag("A", 1).convert();

        assertEquals("A", result);
    }
}
