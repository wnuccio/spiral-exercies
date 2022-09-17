package brackets;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    static class Stack {
        int i;
        char[] brackets;

        public Stack(int length) {
            brackets = new char[length];
            i = 0;
        }

        public void push(char c) {
            brackets[i] = c;
            i++;
        }

        public boolean isEmpty() {
            return i==0;
        }

        public char pop() {
            if (isEmpty()) throw new IllegalStateException();
            i--;
            return brackets[i];
        }
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;

        Stack stack = new Stack(s.length());
        Stack stack2 = new Stack(s.length()); // R S C
        for (char ch : s.toCharArray()) {
            if (isOpenedBracket(ch)) {
                stack.push(ch);
                stack2.push(kindOfBracket(ch));
            }
            else if (isClosedBracket(ch)) {
                if (stack.isEmpty()) return false;
                char lastOpened = stack.pop();
                if (kindOfBracket(lastOpened) != kindOfBracket(ch)) return false;
            }
            else throw new IllegalArgumentException("Invalid char: " + ch);
        }
        return stack.isEmpty();
    }

    private boolean isClosedBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private boolean isOpenedBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private char kindOfBracket(char ch) {
        if (ch == '(' || ch == ')') return 'R';
        if (ch == '[' || ch == ']') return 'S';
        if (ch == '{' || ch == '}') return 'C';
        throw new IllegalArgumentException("Invalid char: " + ch);
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
