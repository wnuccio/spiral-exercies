package palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @Test
    void one_digit_is_palindrome() {
        assertTrue(new Palindrome(1).isPalindrome());
    }

    @Test
    void two_digit_is_palindrome_when_equals_digits() {
        assertFalse(new Palindrome(12).isPalindrome());
    }
}
