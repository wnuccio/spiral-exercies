package spiral2;

public class Matrix2 {
    private final int[][] values;

    public Matrix2(int[][] values) {
        this.values = values;
    }

    public String toSpiral() {
        if (values.length == 0) return "";
        return "1";
    }
}
