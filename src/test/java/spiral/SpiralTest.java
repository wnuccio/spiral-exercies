package spiral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SpiralTest {
    @Test
    void return_simple_2_x_2_spiral() {
        int[] row1 = new int[]{1, 2};
        int[] row2 = new int[]{4, 3};

        Spiral spiral = new Spiral(row1, row2);

        assertEquals("1 2 3 4", spiral.asString());
    }

    @Test
    void return_simple_2_x_2_spiral_inverting_last_row() {
        int[] row1 = new int[]{1, 2};
        int[] row2 = new int[]{3, 4};

        Spiral spiral = new Spiral(row1, row2);

        assertEquals("1 2 4 3", spiral.asString());
    }
}