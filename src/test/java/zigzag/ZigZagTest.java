package zigzag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagTest {
    @Test
    void convert_single_letter() {
        String result = new ZigZag("A", 1).convert();

        assertEquals("A", result);
    }

    @Test
    void convert_two_letters_on_one_row() {
        String result = new ZigZag("AB", 1).convert();

        assertEquals("AB", result);
    }

    @Test
    void convert_two_letters_on_two_rows() {
        String result = new ZigZag("AB", 2).convert();

        assertEquals("AB", result);
    }

}
