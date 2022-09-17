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

    static class Bracket {
        char ch;

        public Bracket(char ch) {
            this.ch = ch;
            kind();
        }

        public char kind() {
            if (ch == '(' || ch == ')') return 'R';
            if (ch == '[' || ch == ']') return 'S';
            if (ch == '{' || ch == '}') return 'C';
            throw new IllegalArgumentException("Invalid char: " + ch);
        }

        boolean isOpened() {
            return ch == '(' || ch == '[' || ch == '{';
        }

        boolean isClosed() {
            return ch == ')' || ch == ']' || ch == '}';
        }


    }

    public boolean isValid() {
        if (s.isEmpty()) return true;

        Stack stack = new Stack(s.length());

        for (char ch : s.toCharArray()) {
            Bracket bracket = new Bracket(ch);

            if (bracket.isOpened()) {
                stack.push(ch);
            }
            else if (bracket.isClosed()) {
                if (stack.isEmpty()) return false;
                char lastOpened = stack.pop();
                if (new Bracket(lastOpened).kind() != bracket.kind()) return false;
            }
            else throw new IllegalArgumentException("Invalid char: " + ch);
        }
        return stack.isEmpty();
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
