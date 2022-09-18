package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        this.s = s;
    }

    // abc
    // ade
    public String commonPrefix() {
        if (s.length == 2) {
            int i=0;
            String result = "";
            boolean sameChar = true;
            boolean endOfStrings = false;
            while(! endOfStrings && sameChar) {
                char ch1 = s[0].charAt(i);
                char ch2 = s[1].charAt(i);
                sameChar = ch1 == ch2;
                if (sameChar) {
                    result += ch1;
                }
                i++;
                endOfStrings = i >= s[0].length();
            }
            return result;
        }
        return s[0];
    }
}
