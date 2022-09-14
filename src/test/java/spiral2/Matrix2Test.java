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

    @Test
    void return_2_x_2_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1, 2},
                new int[]{4, 3},
        });

        assertEquals("1 2 3 4", matrix.toSpiral());
    }

    @Test
    void return_3_x_3_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1, 2, 3},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5},
        });

        assertEquals("1 2 3 4 5 6 7 8 9", matrix.toSpiral());
    }

}