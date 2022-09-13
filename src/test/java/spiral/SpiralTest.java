package spiral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SpiralTest {
    @Test
    void return_simple_2_x_2_spiral() {
        Spiral spiral = new Spiral(rows(
                row(1, 2),
                row(4, 3)));

        assertEquals("1 2 3 4", spiral.asString());
    }

    @Test
    void return_simple_2_x_2_spiral_inverting_last_row() {
        Spiral spiral = new Spiral(rows(
                row(1, 2),
                row(3, 4)));

        assertEquals("1 2 4 3", spiral.asString());
    }

    private int[] row(int i, int i1) {
        return new int[]{i, i1};
    }

    private int[][] rows(int[] row1, int[] row2) {
        return new int[][]{row1, row2};
    }
}