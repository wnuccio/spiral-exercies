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

        public void pop() {
            i--;
        }
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;
        if (s.charAt(0) != '(') return false;

        Stack stack = new Stack(s.length());
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            }
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            else throw new IllegalArgumentException("Invalid char: " + ch);
        }
        return stack.isEmpty();
    }

    public boolean isNotValid() {
        return ! isValid();
    }
}
