package spiral;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MatrixTest {
    @Test
    void return_simple_2_x_2_spiral() {
        Matrix matrix = new Matrix(rows(
                row(1, 2),
                row(4, 3)));

        assertEquals("1 2 3 4", matrix.asString());
    }

    @Test
    void return_simple_2_x_2_spiral_inverting_last_row() {
        Matrix matrix = new Matrix(rows(
                row(1, 2),
                row(3, 4)));

        assertEquals("1 2 4 3", matrix.asString());
    }

    @Test
    void return_3_x_3_spiral() {
        Matrix matrix = new Matrix(new int[][] {
                new int[]{1, 2, 3},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5},
        });

        assertEquals("1 2 3 4 5 6 7 8 9", matrix.asString());
    }

    @Test
    void return_complex_spiral() {
        Matrix matrix = new Matrix(new int[][] {
                new int[]{1, 2, 3, 4, 5},
                new int[]{16, 17, 18, 19, 6},
                new int[]{15, 24, 25, 20, 7},
                new int[]{14, 23, 22, 21, 8},
                new int[]{13, 12, 11, 10, 9}
        });

        List<Integer> l = new ArrayList<>();
        for (int i=1; i<=25; i++) l.add(i);
        String str = l.stream().map(String::valueOf).collect(Collectors.joining(" "));
        assertEquals(str, matrix.asString());
    }

    private int[] row(int i, int i1) {
        return new int[]{i, i1};
    }

    private int[][] rows(int[] row1, int[] row2) {
        return new int[][]{row1, row2};
    }
}