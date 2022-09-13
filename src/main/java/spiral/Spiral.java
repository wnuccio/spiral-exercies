package spiral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Spiral {
    private final int[] row1;
    private final int[] row2;
    private final int[][] rows;

    public Spiral(int[][] rows) {
        assert(isSquare(rows));

        this.rows = rows;
        this.row1 = rows[0];
        this.row2 = rows[1];
    }

    private boolean isSquare(int[][] rows) {
        return true;
    }

    public String asString() {
        List<Integer> l = new ArrayList<>();
        for (int i=0; i < row1.length; i++) {
            l.add(row1[i]);
        }
        for (int i=row2.length -1; i >= 0; i--) {
            l.add(row2[i]);
        }

        String result = l.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result;
    }
}
