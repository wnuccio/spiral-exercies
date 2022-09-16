package zigzag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZag {
    private final String s;
    private final int numRows;

    public ZigZag(String s, int numRows) {
        this.s = s;
        this.numRows = numRows;
    }

    private static class Row {
        List<Character> chars = new ArrayList<>();

        void add(Character ch) {
            chars.add(ch);
        }

        String asString() {
            return chars.stream().map(Object::toString).collect(Collectors.joining());
        }
    }

    /*
            "123456789
            r0:1   5  9
            r1:2 4 6 8
            r2:3   7

            r0:1     7
            r1:2   6 8
            r2:3 5   9
            r3:4
     */

    int row; // in [0, numRows-1]
    boolean down;
    Row[] rows;

    private void init() {
        row = 0;
        down = true;
        rows = new Row[numRows];
        for (int i=0; i<rows.length; i++) rows[i] = new Row();
    }

    private void moveOn() {
        if (numRows == 1) return;
        if (down && row < numRows-1) {
            row++;
        } else if (down && row == numRows-1) {
            down = false;
            row--;
        } else if ( ! down && row >= 1) {
            row--;
        } else if ( ! down && row == 0) {
            down = true;
            row++;
        } else {
            throw new RuntimeException("unreachable");
        }
    }

    public String convert() {
        if (s.length() <= numRows) return s;
        init();
        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            rows[row].add(ch);
            moveOn();
        }


        if (numRows == 1) return rows[0].asString();
        if (numRows == 2) return rows[0].asString() + rows[1].asString();
        if (numRows == 3) return rows[0].asString() + rows[1].asString() + rows[2].asString();
        return s;
    }
}
