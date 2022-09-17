package brackets;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;
        return false;
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
