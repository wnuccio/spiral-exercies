package exes.palindrome;

import java.util.ArrayList;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }

    public boolean isPalindrome() {
        if (val < 0) return false;
        ArrayList<Integer> digits = buildDigits(val);
        return isPalindromeRecursive(digits, 0, digits.size()-1);
    }

    private boolean isPalindromeRecursive(ArrayList<Integer> digits, int left, int right) {
        if (left >= right) return true;
        return digits.get(left).equals(digits.get(right)) && isPalindromeRecursive(digits, ++left, --right) ;
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
