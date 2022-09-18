package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        this.s = s;
    }

    private boolean endOfAnyWordReached(int index, String s1, String s2) {
        return index >= s1.length() || index >= s2.length();
    }

    private boolean sameCharAtIndex(int index, String s1, String s2) {
        char ch1 = s1.charAt(index);
        char ch2 = s2.charAt(index);
        return ch1 == ch2;
    }

    // abc
    // ad
    public String commonPrefix() {
        if (s.length == 2) {
            int i=0;
            String result = "";
            boolean sameChar = true;
            boolean endOfStrings = endOfAnyWordReached(i, s[0], s[1]);
            while(! endOfStrings && sameChar) {
                sameChar = sameCharAtIndex(i, s[0], s[1]);
                if (sameChar) {
                    result += s[0].charAt(i);
                }
                i++;
                endOfStrings = endOfAnyWordReached(i, s[0], s[1]);
            }
            return result;
        }
        return s[0];
    }
}
