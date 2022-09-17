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
            if (s.charAt(0) != '(') return false;
            return s.charAt(1) == ')';
        }
        if (s.length() == 3) {
            return false;
        }
        if (s.length() == 4) {
            if (s.charAt(0) != '(') return false;
            return true;
        }
        return false;
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
