package spiral2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Matrix2Test {
    @Test
    void return_empty_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
        });

        assertEquals("", matrix.toSpiral());
    }

    @Test
    void return_1_x_1_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1}
        });

        assertEquals("1", matrix.toSpiral());
    }
}