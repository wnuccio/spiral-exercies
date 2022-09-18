package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        if (s.length == 0) throw new IllegalArgumentException();
        this.s = s;
    }

    private boolean sameCharAtIndex(int index, String[] words) {
        if (words.length == 1) return true;

        for (int wordIndex = 0; wordIndex < words.length - 1; wordIndex++) {
            String word = words[wordIndex];
            String nextWord = words[wordIndex + 1];
            if (index >= word.length() || index >= nextWord.length())
                return false;
            if (word.charAt(index) != nextWord.charAt(index))
                return false;
        }
        return true;
    }

    public String commonPrefix() {
        String result = "";

        boolean sameChar = true;
        for (int i = 0; i < s[0].length() && sameChar; i++) {
            sameChar = sameCharAtIndex(i, s);
            if (sameChar)
                result += s[0].charAt(i);
        }
        return result;
    }
}
