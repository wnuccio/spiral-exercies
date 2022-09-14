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
        if (i==0 && j==0) s.append(values[i][j]);
        else s.append(" " + values[i][j]);
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
        j = -1;

        if (values.length == 2) {
            moveRight();
            moveRight();
            moveDown();
            moveLeft();
        } else { // values.length == 3
            moveRight();
            moveRight();
            moveRight();
            moveDown();
            moveDown();
            moveLeft();
            moveLeft();
            moveUp();
            moveRight();
        }
        return s.toString();
    }
}
