package palindrome;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }

    public boolean isPalindrome() {
        int[] digits = buildDigits(val);
        if (digits.length == 1) return true;
        return digits[0] == digits[1];
    }

    private int[] buildDigits(int val) {
        int first = val % 10;
        int second = val / 10;
        if (second == 0) return new int[]{first};
        return new int[]{first, second};
    }
}
