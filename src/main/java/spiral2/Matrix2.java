package spiral2;

public class Matrix2 {
    private final int[][] values;

    private int i, j;
    private StringBuilder s;

    public Matrix2(int[][] values) {
        this.values = values;
    }

    private void moveRight() {
        j++;
        s.append(" " + values[i][j]);
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
        if (values.length == 0) return "";
        if (values.length == 1) return "1";

        s = new StringBuilder();
        i = 0;
        j = 0;

        if (values.length == 2) {
            s.append(values[i][j]);

            moveRight();
            moveDown();
            moveLeft();

            return s.toString();
        }

        s.append(values[i][j]);

        moveRight();
        moveRight();
        moveDown();
        moveDown();
        moveLeft();
        moveLeft();
        moveUp();
        moveRight();

        return s.toString();
    }
}
