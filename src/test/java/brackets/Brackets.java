package brackets;

import java.util.*;

public class Brackets {
    private final String s;

    public Brackets(String s) {
        this.s = s;
    }

    private static Map<Character, Bracket> instances = new HashMap<>();
    {
        instances.put('(', new Bracket('(', 'R', true));
        instances.put(')', new Bracket(')', 'R', false));
        instances.put('[', new Bracket('[', 'S', true));
        instances.put(']', new Bracket(']', 'S', false));
        instances.put('{', new Bracket('{', 'C', true));
        instances.put('}', new Bracket('}', 'C', false));
    }

    private Bracket bracketOf(char c) {
        return Optional.ofNullable(instances.get(c)).orElseThrow();
    }

    static class Bracket {
        private final char ch;
        private final char kind;
        private final boolean open;

        @Override
        public String toString() {
            return "" + ch;
        }

        public Bracket(char ch, char kind, boolean open) {
            this.ch = ch;
            this.kind = kind;
            this.open = open;
        }

        public boolean sameKindOf(Bracket bracket) {
            return this.kind == bracket.kind;
        }

        boolean isOpen() {
            return open;
        }

        boolean isClosed() {
            return ! isOpen();
        }
    }

    public boolean isValid() {
        if (s.isEmpty()) return true;
        Stack<Bracket> stack = new Stack<>();

        for (Bracket bracket : toBracketList()) {
            if (bracket.isOpen()) {
                stack.push(bracket);

            } else if (bracket.isClosed()) {
                if (stack.isEmpty()) return false;
                Bracket lastOpened = stack.pop();
                if (!bracket.sameKindOf(lastOpened)) return false;

            } else
                throw new IllegalStateException("Invalid state, not opened nor closed bracket, for: " + bracket);
        }
        return stack.isEmpty();
    }

    private List<Bracket> toBracketList() {
        List<Bracket> brackets = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            brackets.add(bracketOf(ch));
        }

        return brackets;
    }

    public boolean isNotValid() {
        return !isValid();
    }
}
