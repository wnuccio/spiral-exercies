package spiral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static spiral.Spiral.Direction.*;


public class Spiral {
    private final int[][] rows;

    private int i, iMin, iMax, j, jMin, jMax;
    private Direction d;
    private boolean end;
    private List<Integer> numbers;


    public Spiral(int[][] rows) {
        this.rows = rows;
    }

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    public String asString() {

        initialize();

        boolean end = false;
        while (!end) {
            numbers.add(rows[i][j]);
            moveOn();
            end = iMin == iMax && jMin == jMax;
        }

        numbers.add(rows[i][j]);
        return joinAsString(numbers);
    }

    private void moveOn() {
        switch (d) {
            case RIGHT:
                if (j < jMax) {
                    j++;
                    break;
                }
                iMin++;
                d = DOWN;

            case DOWN:
                if (i < iMax) {
                    i++;
                    break;
                }
                jMax--;
                d = LEFT;

            case LEFT:
                if (j > jMin) {
                    j--;
                    break;
                }
                iMax--;
                d = UP;

            case UP:
                if (i > iMin) {
                    i--;
                    break;
                }
                jMin++;
                d = RIGHT;
                if (j < jMax) j++;
                else iMin++;
        }
    }

    private void initialize() {
        iMin = 0;
        jMin = 0;
        iMax = rows.length - 1;
        jMax = rows.length - 1;
        i = iMin;
        j = jMin;
        d = RIGHT;
        numbers = new ArrayList<>();
    }

    private String joinAsString(List<Integer> l) {
        return l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
