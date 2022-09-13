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
        assert(isSquare(rows));

        this.rows = rows;
        this.row1 = rows[0];
        this.row2 = rows[1];
    }

    private boolean isSquare(int[][] rows) {
        return true;
    }

    enum Direction {
        LEFT_RIGHT, UP_DOWN, RIGHT_LEFT, DOWN_UP
    }

    public String asString() {
        List<Integer> l = new ArrayList<>();

        int iMin=0, jMin=0;
        int iMax = rows.length-1, jMax = rows.length-1;
        int i=iMin, j=jMin;
        Direction d = LEFT_RIGHT;
        boolean notEnd = i != iMax;

        boolean end = false;
        while(notEnd) {
            System.out.println(String.format("[%s, %s]", i, j));
            l.add(rows[i][j]);

            switch(d) {
                case LEFT_RIGHT:
                    if (j<jMax) { j++; break; }
                    iMin++;
                    d = UP_DOWN;

                case UP_DOWN:
                    if (i<iMax) { i++; break; }
                    jMax--;
                    d = RIGHT_LEFT;

                case RIGHT_LEFT:
                    if (j>jMin) { j--; break; }
                    iMax--;
                    d = DOWN_UP;

                case DOWN_UP:
                    if (i>iMin) { i--; break; }
                    jMin++;
                    d = LEFT_RIGHT;
                    if (j == jMax) { end = true; } else j++;
            }

            notEnd = !end;
        }


        String result = l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result;
    }
}
