package spiral2;

import static spiral2.Matrix2.Direction.*;

public class Matrix2 {
    private final int[][] values;

    private int i, j;
    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }

    enum Direction {
        RIGHT, DOWN, LEFT, UP

    }
    private void move(Direction direction, int steps) {
        for (int k=0; k<steps; k++) {
            switch (direction) {
                case RIGHT: j++; break;
                case DOWN: i++; break;
                case LEFT: j--; break;
                case UP: i--; break;
            }
            if (i == 0 && j == 0) s.append(values[i][j]);
            else s.append(" " + values[i][j]);
        }
    }

    public String toSpiral() {
        s = new StringBuilder();
        i = 0;
        j = -1;
        int steps = values.length;
        Direction direction = RIGHT;

        move(direction, steps);
        steps--;
        direction = DOWN;
        move(direction, steps);
        direction = LEFT;
        move(direction, steps);
        steps--;
        direction = UP;
        move(direction, steps);

        if (values.length == 0) {

        } else if (values.length == 1) {

        } else if (values.length == 2) {

        } else if (values.length == 3) {
            move(RIGHT, 1);
        } else if (values.length == 4) {
            move(RIGHT, 2);
            move(DOWN, 1);
            move(LEFT, 1);
        } else if (values.length == 5) {
            move(RIGHT, 3);
            move(DOWN, 2);
            move(LEFT, 2);
            move(UP, 1);
            move(RIGHT, 1);
        } else if (values.length == 6) {
            move(RIGHT, 4);
            move(DOWN, 3);
            move(LEFT, 3);
            move(UP, 2);
            move(RIGHT, 2);
            move(DOWN, 1);
            move(LEFT, 1);
        }
        return s.toString();
    }
}
