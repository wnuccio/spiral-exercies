package spiral2;

import static spiral2.Matrix2.Direction.*;

public class Matrix2 {
    private final int[][] values;

    private int i, j;
    int steps;
    Direction direction;
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
        steps = values.length;

        direction = RIGHT;
        move(direction, steps);

        steps--;
        direction = DOWN;
        move(direction, steps);

        direction = LEFT;
        move(direction, steps);

        steps--;
        direction = UP;
        move(direction, steps);

        direction = RIGHT;
        move(direction, steps);

        steps--;
        direction = DOWN;
        move(direction, steps);

        direction = LEFT;
        move(direction, steps);

        steps--;
        direction = UP;
        move(direction, steps);

        direction = RIGHT;
        move(direction, steps);

        steps--;
        direction = DOWN;
        move(direction, steps);

        direction = LEFT;
        move(direction, steps);

        steps--;
        direction = UP;
        move(direction, steps);

        direction = RIGHT;
        move(direction, steps);

        return s.toString();
    }
}
