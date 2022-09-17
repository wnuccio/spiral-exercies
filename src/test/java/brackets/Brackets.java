package brackets;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;
        if (s.charAt(0) != '(') return false;
        int numOfOpenBrackets = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') numOfOpenBrackets++;
            else if (ch == ')') numOfOpenBrackets--;
            else throw new IllegalArgumentException("Invalid char: " + ch);
        }
        return numOfOpenBrackets == 0;
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
