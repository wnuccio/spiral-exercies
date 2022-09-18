package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        if (s.length == 0) throw new IllegalArgumentException();
        this.s = s;
    }

    private boolean endOfAnyWordReached(int index, String[] words) {
        for (String w : words) {
            if (index >= w.length()) return true;
        }
        return false;
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
        int i = 0;
        String result = "";
        while (true) {
            if (!sameCharAtIndex(i, s)) break;
            if (i >= s[0].length()) break;
            result += s[0].charAt(i);
            i++;
        }
        return result;
    }
}
