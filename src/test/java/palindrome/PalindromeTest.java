package palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    @Test
    void one_digit_is_palindrome() {
        assertEquals(true, new Palindrome(1).isPalindrome());
    }

    @Test
    void two_digit_is_not_palindrome_when_digits_are_different() {
        assertEquals(false, new Palindrome(12).isPalindrome());
    }

    @Test
    void two_digit_is_palindrome_when_digits_are_equals() {
        assertEquals(true, new Palindrome(11).isPalindrome());
    }

    @Test
    void three_digits_is_palindrome_when_digits_are_equals() {
        assertEquals(true, new Palindrome(111).isPalindrome());
    }
}
