package spiral2;

public class Matrix2 {
    private final int[][] values;

    public Matrix2(int[][] values) {
        this.values = values;
    }

    public String toSpiral() {
        if (values.length == 0) return "";
        if (values.length == 1) return "1";

        if (values.length == 2) {
            StringBuilder s = new StringBuilder();
            int i = 0, j = 0;
            s.append(values[i][j]);

            j++;
            s.append(" " + values[i][j]);

            i++;
            s.append(" " + values[i][j]);

            j--;
            s.append(" " + values[i][j]);

            return s.toString();
        }

        StringBuilder s = new StringBuilder();
        int i = 0, j = 0;
        s.append(values[i][j]);

        j++;
        s.append(" " + values[i][j]);
        j++;
        s.append(" " + values[i][j]);

        i++;
        s.append(" " + values[i][j]);
        i++;
        s.append(" " + values[i][j]);

        j--;
        s.append(" " + values[i][j]);
        j--;
        s.append(" " + values[i][j]);

        i--;
        s.append(" " + values[i][j]);

        j++;
        s.append(" " + values[i][j]);

        return s.toString();
    }
}
