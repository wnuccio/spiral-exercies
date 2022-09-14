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
            move(RIGHT);
            move(DOWN);
            move(LEFT);
            move(UP);
        }

        return s.toString();
    }

    private void move(Direction direction) {
        for (int k=0; k<this.steps; k++) {
            switch (direction) {
                case RIGHT: j++; break;
                case DOWN: i++; break;
                case LEFT: j--; break;
                case UP: i--; break;
            }

            if ( ! onFirstElement()) s.append(" ");
            s.append(values[i][j]);
        }

        if (direction == RIGHT || direction == LEFT) this.steps--;
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
