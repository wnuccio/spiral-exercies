package prefix;

public class Words {
    private final String[] words;

    public Words(String... words) {
        if (words.length == 0) throw new IllegalArgumentException();
        this.words = words;
    }

    private boolean haveSameCharAtIndex(String[] words, int index) {
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
        for (int i = 0; i < words[0].length() && sameChar; i++) {
            sameChar = haveSameCharAtIndex(words, i);
            if (sameChar)
                result += words[0].charAt(i);
        }
        return result;
    }
}
