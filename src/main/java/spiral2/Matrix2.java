package spiral2;

import static spiral2.Matrix2.Direction.DOWN;
import static spiral2.Matrix2.Direction.RIGHT;

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
            }
            if (i == 0 && j == 0) s.append(values[i][j]);
            else s.append(" " + values[i][j]);
        }
    }

    private void moveLeft() {
        j--;
        s.append(" " + values[i][j]);
    }

    private void moveUp() {
        i--;
        s.append(" " + values[i][j]);
    }

    public String toSpiral() {
        s = new StringBuilder();
        i = 0;
        j = -1;

        if (values.length == 0) {

        } else if (values.length == 1) {
            move(RIGHT, 1);
        } else if (values.length == 2) {
            move(RIGHT, 2);
            move(DOWN, 1);
            moveLeft();
        } else if (values.length == 3) {
            move(RIGHT, 3);
            move(DOWN, 2);
            moveLeft();moveLeft();
            moveUp();
            move(RIGHT, 1);
        } else if (values.length == 4) {
            move(RIGHT, 4);
            move(DOWN, 3);
            moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();
            move(RIGHT, 2);
            move(DOWN, 1);
            moveLeft();
        } else if (values.length == 5) {
            move(RIGHT, 5);
            move(DOWN, 4);
            moveLeft();moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();moveUp();
            move(RIGHT, 3);
            move(DOWN, 2);
            moveLeft();moveLeft();
            moveUp();
            move(RIGHT, 1);
        } else if (values.length == 6) {
            move(RIGHT, 6);
            move(DOWN, 5);
            moveLeft();moveLeft();moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();moveUp();moveUp();
            move(RIGHT, 4);
            move(DOWN, 3);
            moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();
            move(RIGHT, 2);
            move(DOWN, 1);
            moveLeft();
        }
        return s.toString();
    }
}
