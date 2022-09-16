package zigzag;

public class ZigZag {
    private final String s;
    private final int numRows;

    public ZigZag(String s, int numRows) {
        this.s = s;
        this.numRows = numRows;
    }

    private class Row {
        private final char[] chars;
        private int i;
        public Row() {
            this.chars = new char[s.length()];
            this.i = 0;
        }

        void add(char ch) {
            if (i >= chars.length) throw new IndexOutOfBoundsException();
            chars[i++] = ch;
        }

        String asString() {
            StringBuilder str = new StringBuilder();
            for (int j=0; j<i; j++) str.append(chars[j]);
            return str.toString();
        }
    }

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

        StringBuilder build = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            build.append(rows[i].asString());
        }
        return build.toString();
    }
}
