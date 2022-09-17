package zigzag;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZigZag {
    private final String s;
    private final int numRows;

    public ZigZag(String s, int numRows) {
        this.s = s;
        this.numRows = numRows;
    }

    private static class Row {
        private final char[] chars;
        private int i;

        Row(int size) {
            this.chars = new char[size];
            this.i = 0;
        }

        void add(char ch) {
            chars[i++] = ch;
        }

        String asString() {
            return String.valueOf(Arrays.copyOf(chars, i));
        }
    }

    private int row; // in [0, numRows-1]
    private boolean down;
    private Row[] rows;

    private void init() {
        row = 0;
        down = true;
        rows = new Row[numRows];
        for (int i=0; i<rows.length; i++) rows[i] = new Row(s.length());
    }

    private void moveOn() {
        if (numRows == 1) return;
        boolean continueGoingDown = down && row < numRows - 1;
        boolean switchToDown = !down && row == 0;
        down = continueGoingDown || switchToDown;
        if (down) row++; else row--;
    }

    public String convert() {
        if (s.length() <= numRows) return s;
        init();
        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            rows[row].add(ch);
            moveOn();
        }

        return Stream.of(rows)
                .map(Row::asString)
                .collect(Collectors.joining());
    }
}
