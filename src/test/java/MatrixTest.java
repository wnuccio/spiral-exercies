import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
Matrix zig-zag unravelling

Given an m x n matrix of characters, write a method that returns a String which contains the concatenation of all the matrix’s diagonals, from top to bottom, right to left.
For example, input

1 A 5 7 B N
2 B 6 8 K R
5 Q N 3 B 1

Output has to be: 1 A2 5B5 76Q B8N NK3 RB 1 as a result (with or without spaces, doesn’t matter)
 */
public class MatrixTest {
    @Test
    void one_x_one_matrix() {
        Matrix matrix = new Matrix(new String[][]{{"1"}});
        assertEquals(Collections.singletonList("1"), matrix.diagonals());
    }

    @Test
    void one_x_matrix() {
        Matrix matrix = new Matrix(new String[][]{
                {"1", "2", "3", "4"}
        });
        assertEquals(Arrays.asList("1", "2", "3", "4"), matrix.diagonals());
    }

    @Test
    void two_rows_matrix() {
        Matrix matrix = new Matrix(new String[][]{
                {"1", "2", "4", "6"},
                {"3", "5", "7", "8"}
        });
        assertEquals(Arrays.asList("1", "23", "45", "67", "8"), matrix.diagonals());
    }
}
