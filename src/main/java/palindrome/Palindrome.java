package palindrome;

public class Palindrome {
    final private int val;

    public Palindrome(int val) {
        this.val = val;
    }


    // 12344321
    public boolean isPalindrome() {
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

    private int[] buildDigits(int val) {
        /** 25346
         * 1  10 => 2534
         * 2  100 => 253
         * 3  1000 => 25
         * 4  10000 => 2
         * 5  100000 => 0
         */
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

        int divisor = (int) Math.pow(10, numOfDigits-1);
        for (int i=0; i<numOfDigits; i++) {
            result[i] = (val / divisor) % 10;
            divisor = divisor / 10;
        }

        return result;
    }
}
