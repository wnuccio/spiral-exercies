package palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @Test
    void one_digit_is_palindrome() {
        assertTrue(new Palindrome(1).isPalindrome());
    }

    @Test
    void two_digit_is_not_palindrome_when_digits_are_different() {
        assertEquals(new Palindrome(12).isPalindrome(), false);
    }

    @Test
    void two_digit_is_palindrome_when_digits_are_equals() {
        assertEquals(new Palindrome(11).isPalindrome(), true);
    }
}
