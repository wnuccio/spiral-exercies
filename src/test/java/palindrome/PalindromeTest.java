package palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    @Test
    void negative_is_not_palindrome() {
        assertEquals(false, new Palindrome(-121).isPalindrome());
    }

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

    @Test
    void three_digits_is_palindrome_when_first_and_last_digits_are_equals() {
        assertEquals(true, new Palindrome(101).isPalindrome());
    }

    @Test
    void three_digits_is_not_palindrome_in_other_cases() {
        assertEquals(false, new Palindrome(110).isPalindrome());
    }

    @Test
    void four_digits_is_palindrome_here() {
        assertEquals(true, new Palindrome(1001).isPalindrome());
    }

    @Test
    void compute_is_palindrome_for_big_int() {
        assertEquals(true, new Palindrome(1410110141).isPalindrome());
    }
}
