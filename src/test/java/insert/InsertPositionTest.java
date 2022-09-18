package insert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertPositionTest {
    @Test
    void position_in_an_empty_array_is_zero() {
        assertEquals(0, InsertPosition.search(new int[]{}, 8));
    }

    @Test
    void position_in_a_one_length_array() {
        assertEquals(0, InsertPosition.search(new int[]{2}, 1));
        assertEquals(0, InsertPosition.search(new int[]{2}, 2));
        assertEquals(1, InsertPosition.search(new int[]{2}, 3));
    }

    @Test
    void position_in_a_two_length_array() {
        assertEquals(0, InsertPosition.search(new int[]{2, 3}, 1));
        assertEquals(0, InsertPosition.search(new int[]{2, 3}, 2));
        assertEquals(1, InsertPosition.search(new int[]{2, 3}, 3));
        assertEquals(2, InsertPosition.search(new int[]{2, 3}, 4));
    }
}
