package palindrome;

import java.util.ArrayList;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }

    public boolean isPalindrome() {
        if (val < 0) return false;
        ArrayList<Integer> digits = buildDigits(val);
        int left = 0;
        int right = digits.size() - 1;

        boolean endOfSearch = left >= right;
        while(! endOfSearch) {
            if ( ! digits.get(left).equals(digits.get(right))) return false;
            endOfSearch = left >= right;
            left++;
            right--;
        }
        return true;
    }

    private ArrayList<Integer> buildDigits(int val) {
        int currVal = val;
        ArrayList<Integer> digits = new ArrayList<>();
        while(currVal != 0) {
            digits.add(currVal % 10);
            currVal = currVal / 10;
        }

        return digits;
    }
}
