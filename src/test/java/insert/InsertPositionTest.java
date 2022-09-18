package insert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertPositionTest {
    @Test
    void position_in_an_empty_array_is_zero() {
        assertEquals(0, InsertPosition.search(new int[]{}, 8));
    }
}
