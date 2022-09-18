package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        this.s = s;
    }

    private boolean endOfAnyWordReached(int index, String[] words) {
        for (String w : words) {
            if (index >= w.length()) return true;
        }
        return false;
    }

    private boolean sameCharAtIndex(int index, String[] words) {
        if (words.length <= 1) return true;
        for (int wordIndex = 0; wordIndex < words.length - 1; wordIndex++) {
            String word = words[wordIndex];
            String nextWord = words[wordIndex + 1];
            if (word.charAt(index) != nextWord.charAt(index)) return false;
        }
        return true;
    }

    public String commonPrefix() {
        int i = 0;
        String result = "";
        boolean sameChar = true;
        boolean endOfStrings = endOfAnyWordReached(i, s);
        while (!endOfStrings && sameChar) {
            sameChar = sameCharAtIndex(i, s);
            if (sameChar) {
                result += s[0].charAt(i);
            }
            i++;
            endOfStrings = endOfAnyWordReached(i, s);
        }
        return result;
    }
}
