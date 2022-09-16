package palindrome;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }

    // 12344321
    public boolean isPalindrome() {
        if (val < 0) return false;
        int[] digits = buildDigits(val);
        int left = 0;
        int right = digits.length - 1;

        boolean endOfSearch = left >= right;
        while(! endOfSearch) {
            if (digits[left] != digits[right]) return false;
            endOfSearch = left >= right;
            left++;
            right--;
        }
        return true;
    }

    /*
            2463
           3 - 246
           6 - 24
           4 - 2
           2 - 0
     */

    private int[] buildDigits(int val) {
        boolean areThereDigits = true;
        int numOfDigits = 1;
        int pow10 = 10;
        while(areThereDigits) {
            int division = val / pow10;
            if (division != 0) {
                areThereDigits = true;
                pow10 = pow10 * 10;
                numOfDigits++;
            } else areThereDigits = false;
        }
        int[] result = new int[numOfDigits];

        int currVal = val;
        for(int i=0; i < numOfDigits; i++) {
            result[i] = (currVal % 10);
            currVal = currVal / 10;
        }

        return result;
    }
}
