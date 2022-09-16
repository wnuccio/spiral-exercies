package palindrome;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }

    public boolean isPalindrome() {
        int[] digits = buildDigits(val);
        if (digits.length == 1) return true;
        if (digits.length == 2) return digits[0] == digits[1];
        return true;
    }

    private int[] buildDigits(int val) {
        int first = val % 10;
        int second = val / 10;
        int third = val / 100;
        if (second == 0 && third == 0) return new int[]{first};
        if (third == 0 ) return new int[]{first, second};
        return new int[]{first, second, third};
    }
}
