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
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) return false;
                char lastOpened = stack.pop();
//                if (differentKind(ch, lastOpened)) return false;
            }
            else throw new IllegalArgumentException("Invalid char: " + ch);
        }
        return stack.isEmpty();
    }

//    private boolean differentKind(char ch, char lastOpened) {
//    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
