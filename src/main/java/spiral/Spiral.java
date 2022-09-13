package spiral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Spiral {
    private final int[] row1;
    private final int[] row2;

    public Spiral(int[] row1, int[] row2) {
        this.row1 = row1;
        this.row2 = row2;
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
