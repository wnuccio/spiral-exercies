package spiral2;

import static spiral2.Matrix2.Direction.*;

public class Matrix2 {
    private final int[][] values;

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private int i, j;
    private int steps;
    private Direction direction;

    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }
    public String toSpiral() {
        initialize();

        while(steps > 0) {
            moveRight();
            moveDown();
            moveLeft();
            moveUp();
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
            if (i == 0 && j == 0) s.append(values[i][j]);
            else s.append(" ").append(values[i][j]);
        }
    }

    private void moveUp() {
        steps--;
        direction = UP;
        move(direction, steps);
    }

    private void moveLeft() {
        direction = LEFT;
        move(direction, steps);
    }

    private void moveDown() {
        steps--;
        direction = DOWN;
        move(direction, steps);
    }

    private void moveRight() {
        direction = RIGHT;
        move(direction, steps);
    }

    private void initialize() {
        s = new StringBuilder();
        i = 0;
        j = -1;
        steps = values.length;
    }
}
