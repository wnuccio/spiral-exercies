package spiral2;

public class Matrix2 {
    private final int[][] values;

    private int i, j;
    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }

    private void moveRight(int steps) {
        for (int k=0; k<steps; k++) {
            j++;
            if (i == 0 && j == 0) s.append(values[i][j]);
            else s.append(" " + values[i][j]);
        }
    }

    private void moveDown() {
        i++;
        s.append(" " + values[i][j]);
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
            moveRight(1);
        } else if (values.length == 2) {
            moveRight(2);
            moveDown();
            moveLeft();
        } else if (values.length == 3) {
            moveRight(3);
            moveDown();moveDown();
            moveLeft();moveLeft();
            moveUp();
            moveRight(1);
        } else if (values.length == 4) {
            moveRight(4);
            moveDown();moveDown();moveDown();
            moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();
            moveRight(2);
            moveDown();
            moveLeft();
        } else if (values.length == 5) {
            moveRight(5);
            moveDown();moveDown();moveDown();moveDown();
            moveLeft();moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();moveUp();
            moveRight(3);
            moveDown();moveDown();
            moveLeft();moveLeft();
            moveUp();
            moveRight(1);
        } else if (values.length == 6) {
            moveRight(6);
            moveDown();moveDown();moveDown();moveDown();moveDown();
            moveLeft();moveLeft();moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();moveUp();moveUp();
            moveRight(4);
            moveDown();moveDown();moveDown();
            moveLeft();moveLeft();moveLeft();
            moveUp();moveUp();
            moveRight(2);
            moveDown();
            moveLeft();
        }
        return s.toString();
    }
}
