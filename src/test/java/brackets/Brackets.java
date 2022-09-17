package brackets;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;
        if (s.length() == 1) {
            return false;
        }
        if (s.length() == 2) {
            return s.charAt(0) == '(' && s.charAt(1) == ')';
        }
        return false;
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
