package zigzag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagTest {

    @Test
    void convert_on_one_row() {
        assertZigZag("A", 1, "A");
        assertZigZag("AB", 1, "AB");
        assertZigZag("ABC", 1, "ABC");
        assertZigZag("ABCD", 1, "ABCD");
    }

    @Test
    void convert_on_two_rows() {
        assertZigZag("A", 2, "A");
        assertZigZag("AB", 2, "AB");
        assertZigZag("ABC", 2, "ACB");
        assertZigZag("ABCD", 2, "ACBD");
        assertZigZag("ABCDE", 2, "ACEBD");
    }

    /*
        A   E
        B D
        C
     */

    @Test
    void convert_on_three_rows() {
        assertZigZag("A", 3, "A");
        assertZigZag("AB", 3, "AB");
        assertZigZag("ABC", 3, "ABC");
        assertZigZag("ABCD", 3, "ABDC");
        assertZigZag("ABCDE", 3, "AEBDC");
    }

    @Test
    void convert_on_four_rows() {
        assertZigZag("A", 4, "A");
        assertZigZag("AB", 4, "AB");
        assertZigZag("ABC", 4, "ABC");
        assertZigZag("ABCD", 4, "ABCD");
    }

    private void assertZigZag(String string, int numRows, String expected) {
        assertEquals(expected, new ZigZag(string, numRows).convert());
    }
}
