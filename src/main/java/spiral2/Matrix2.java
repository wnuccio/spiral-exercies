package spiral2;

import static spiral2.Matrix2.Direction.*;

public class Matrix2 {
    private final int[][] values;

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private int i, j;
    private int steps;

    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }
    public String toSpiral() {
        initialize();

        while(steps > 0) {
            move(RIGHT, steps);
            steps--;
            move(DOWN, steps);
            move(LEFT, steps);
            steps--;
            move(UP, steps);
        }

        return s.toString();
    }

    private void move(Direction direction, int steps) {
        for (int k=0; k<steps; k++) {
            switch (direction) {
                case RIGHT: j++; break;
                case DOWN: i++; break;
                case LEFT: j--; break;
                case UP: i--; break;
            }

            if ( ! onFirstElement()) s.append(" ");
            s.append(values[i][j]);
        }
    }

    private boolean onFirstElement() {
        return i == 0 && j == 0;
    }

    private void initialize() {
        s = new StringBuilder();
        i = 0;
        j = -1;
        steps = values.length;
    }
}
