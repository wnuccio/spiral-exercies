package spiral2;

import static spiral2.Matrix2.Direction.*;

public class Matrix2 {
    private final int[][] values;

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private int i, j;

    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }
    public String toSpiral() {
        int steps = initialize();

        while(steps > 0) {
            steps = move(RIGHT, steps);
            steps = move(DOWN, steps);
            steps = move(LEFT, steps);
            steps = move(UP, steps);
        }

        return s.toString();
    }

    private int move(Direction direction, int steps) {
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

        if (direction == RIGHT || direction == LEFT) steps--;
        return steps;
    }

    private boolean onFirstElement() {
        return i == 0 && j == 0;
    }

    private int initialize() {
        s = new StringBuilder();
        i = 0;
        j = -1;
        return values.length;
    }
}
