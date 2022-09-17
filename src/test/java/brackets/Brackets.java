package brackets;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    /*
        ""          0,0
        "()"        0,1
        "(())"      0,3
        "((()))"    0,5
        "(()" => no, only even length;
     */
    private boolean isValid(String str, int start, int end) {
        if (start > end) return true; // empty string

        boolean isOddLength = (end - start) % 2 != 1;
        if(isOddLength) return false;

        if (str.charAt(start) != '(' || str.charAt(end) != ')') return false;

        return isValid(str, ++start, --end);
    }

    public boolean isValid() {
        return isValid(s, 0, s.length()-1);
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
