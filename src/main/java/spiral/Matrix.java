package spiral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static spiral.ComputeSpiral.Direction.*;

class ComputeSpiral {
    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private int i, iMin, iMax, j, jMin, jMax;
    private Direction d;
    private boolean end;
    private List<Integer> numbers;

    private void initialize(int[][] rows) {
        iMin = 0;
        jMin = 0;
        iMax = rows.length - 1;
        jMax = rows.length - 1;
        i = iMin;
        j = jMin;
        d = RIGHT;
        end = false;
        numbers = new ArrayList<>();
    }

    public List<Integer> compute(int[][] rows) {
        initialize(rows);

        while (!end) {
            numbers.add(rows[i][j]);
            moveOn();
            end = iMin == iMax && jMin == jMax;
        }

        numbers.add(rows[i][j]);
        return numbers;

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
}

public class Matrix {
    private final int[][] rows;

    public Matrix(int[][] rows) {
        this.rows = rows;
    }

    public String toSpiral() {
        List<Integer> numberSpiral = new ComputeSpiral().compute(rows);
        return joinAsString(numberSpiral);
    }

    private String joinAsString(List<Integer> l) {
        return l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
