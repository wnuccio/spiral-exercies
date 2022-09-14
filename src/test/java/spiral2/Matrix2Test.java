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

    @Test
    void return_4_x_4_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1,  2,  3,  4},
                new int[]{12, 13, 14, 5},
                new int[]{11, 16, 15, 6},
                new int[]{10, 9,  8,  7}
        });

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16", matrix.toSpiral());
    }

    @Test
    void return_5_x_5_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1,  2,  3,  4,  5},
                new int[]{16, 17, 18, 19, 6},
                new int[]{15, 24, 25, 20, 7},
                new int[]{14, 23, 22, 21, 8},
                new int[]{13, 12, 11, 10, 9}
        });

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25", matrix.toSpiral());
    }

    @Test
    void return_6_x_6_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1,  2,  3,  4,  5,   6},
                new int[]{20, 21, 22, 23, 24,  7},
                new int[]{19, 32, 33, 34, 25,  8},
                new int[]{18, 31, 36, 35, 26,  9},
                new int[]{17, 30, 29, 28, 27, 10},
                new int[]{16, 15, 14, 13, 12, 11}
        });

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 " +
                "21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36", matrix.toSpiral());
    }

    @Test
    void return_7_x_7_spiral() {
        Matrix2 matrix = new Matrix2(new int[][] {
                new int[]{1,  2,  3,  4,  5,   6,  7},
                new int[]{24, 25, 26, 27, 28, 29,  8},
                new int[]{23, 40, 41, 42, 43, 30,  9},
                new int[]{22, 39, 48, 49, 44, 31, 10},
                new int[]{21, 38, 47, 46, 45, 32, 11},
                new int[]{20, 37, 36, 35, 34, 33, 12},
                new int[]{19, 18, 17, 16, 15, 14, 13}
        });

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 " +
                "21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 " +
                "37 38 39 40 41 42 43 44 45 46 47 48 49", matrix.toSpiral());
    }



}