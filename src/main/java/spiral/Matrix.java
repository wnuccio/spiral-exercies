package spiral;

import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    private final int[][] rows;

    public Matrix(int[][] rows) {
        this.rows = rows;
    }

    public String toSpiral() {
        List<Integer> numberSpiral = new ComputeSpiral().compute(rows);
        return joinAsString(numberSpiral);
    }

    private String joinAsString(List<Integer> l) {
        return l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
