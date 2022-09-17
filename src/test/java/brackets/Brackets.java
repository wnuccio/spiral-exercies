package brackets;

import java.util.ArrayList;
import java.util.List;

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

        public void push(Bracket b) {
            brackets[i] = b.toChar();
            i++;
        }

        public boolean isEmpty() {
            return i==0;
        }

        public Bracket pop() {
            if (isEmpty()) throw new IllegalStateException();
            i--;
            return new Bracket(brackets[i]);
        }
    }

    static class Bracket {
        private char ch;

        @Override
        public String toString() {
            return ""+ch;
        }

        char toChar() {
            return ch;
        }

        public Bracket(char ch) {
            this.ch = ch;
            kind();
        }

        public boolean sameKindOf(Bracket bracket) {
            return this.kind() == bracket.kind();
        }

        private char kind() {
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

        for (Bracket bracket: toBracketList()) {

            if (bracket.isOpened()) {
                stack.push(bracket);
            }
            else if (bracket.isClosed()) {
                if (stack.isEmpty()) return false;
                Bracket lastOpened = stack.pop();
                if (! bracket.sameKindOf(lastOpened)) return false;
            }
            else throw new IllegalStateException("Invalid state, not opened nor closed bracket, for: " + bracket);
        }
        return stack.isEmpty();
    }

    private List<Bracket> toBracketList() {
        List<Bracket> brackets = new ArrayList<>();
        for (char ch: s.toCharArray()) {
            brackets.add(new Bracket(ch));
        }

        return brackets;
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
