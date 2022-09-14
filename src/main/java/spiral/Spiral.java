package spiral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static spiral.Spiral.Direction.*;


public class Spiral {
    private final int[] row1;
    private final int[] row2;
    private final int[][] rows;

    public Spiral(int[][] rows) {
        assert (isSquare(rows));

        this.rows = rows;
        this.row1 = rows[0];
        this.row2 = rows[1];
    }

    private boolean isSquare(int[][] rows) {
        return true;
    }

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    public String asString() {
        List<Integer> l = new ArrayList<>();

        int iMin = 0, jMin = 0;
        int iMax = rows.length - 1, jMax = rows.length - 1;
        int i = iMin, j = jMin;
        Direction d = RIGHT;

        boolean end = false;
        while (!end) {
            System.out.println(String.format("[%s, %s]", i, j));
            l.add(rows[i][j]);

            switch (d) {
                case RIGHT:
                    if (j < jMax) {j++;break;}
                    iMin++;
                    d = DOWN;

                case DOWN:
                    if (i < iMax) {i++;break;}
                    jMax--;
                    d = LEFT;

                case LEFT:
                    if (j > jMin) {j--;break;}
                    iMax--;
                    d = UP;

                case UP:
                    if (i > iMin) {i--;break;}
                    jMin++;
                    d = RIGHT;
                    if (j < jMax) j++; else iMin++;
            }
            end = iMin == iMax && jMin == jMax;
        }

        l.add(rows[i][j]);

        String result = l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result;
    }
}
