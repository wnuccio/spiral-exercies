package removal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovalTest {
//    @Test
//    void remove_all_3_in_two_occurrences() {
//        int[] numbers = new int[]{3, 2, 2, 3};
//        int length = Numbers.remove(numbers, 3);
//        assertEqualNumbers(new int[]{2, 2}, numbers,length);
//    }

    @Test
    void no_removal_in_one_number_array() {
        int[] numbers = new int[]{3};
        int length = Numbers.remove(numbers, 1);
        assertEqualNumbers(new int[]{3}, numbers,length);
    }

    @Test
    void one_removal_in_one_number_array() {
        int[] numbers = new int[]{3};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{}, numbers,length);
    }

    @Test
    void no_removal_in_two_numbers_array() {
        int[] numbers = new int[]{3, 4};
        int length = Numbers.remove(numbers, 1);
        assertEqualNumbers(new int[]{3, 4}, numbers,length);
    }

    @Test
    void one_removal_of_first_of_two_numbers() {
        int[] numbers = new int[]{3, 4};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{4}, numbers,length);
    }

    @Test
    void one_removal_of_second_of_two_numbers() {
        int[] numbers = new int[]{3, 4};
        int length = Numbers.remove(numbers, 4);
        assertEqualNumbers(new int[]{3}, numbers,length);
    }

    @Test
    void one_removal_of_both_of_two_numbers() {
        int[] numbers = new int[]{4, 4};
        int length = Numbers.remove(numbers, 4);
        assertEqualNumbers(new int[]{}, numbers,length);
    }

    @Test
    void no_removal_on_three_numbers() {
        int[] numbers = new int[]{3, 4, 5};
        int length = Numbers.remove(numbers, 1);
        assertEqualNumbers(new int[]{3, 4, 5}, numbers,length);
    }

    @Test
    void one_removal_on_three_numbers_first() {
        int[] numbers = new int[]{3, 4, 5};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{4, 5}, numbers,length);
    }

    @Test
    void one_removal_on_three_numbers_middle() {
        int[] numbers = new int[]{3, 4, 5};
        int length = Numbers.remove(numbers, 4);
        assertEqualNumbers(new int[]{3, 5}, numbers,length);
    }

    @Test
    void one_removal_on_three_numbers_last() {
        int[] numbers = new int[]{3, 4, 5};
        int length = Numbers.remove(numbers, 5);
        assertEqualNumbers(new int[]{3, 4}, numbers,length);
    }

    @Test
    void two_removal_on_three_numbers_first() {
        int[] numbers = new int[]{3, 3, 5};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{5}, numbers,length);
    }

    @Test
    void two_removal_on_three_numbers_last() {
        int[] numbers = new int[]{3, 5, 5};
        int length = Numbers.remove(numbers, 5);
        assertEqualNumbers(new int[]{3}, numbers,length);
    }

    @Test
    void two_removal_on_three_numbers_first_last() {
        int[] numbers = new int[]{3, 5, 3};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{5}, numbers,length);
    }

    @Test
    void three_removal_on_three_numbers() {
        int[] numbers = new int[]{3, 3, 3};
        int length = Numbers.remove(numbers, 3);
        assertEqualNumbers(new int[]{}, numbers,length);
    }

    @Test
    void removal_on_four_numbers() {
        int[] numbers = new int[]{4, 3, 4, 4, 3, 4};
        int length = Numbers.remove(numbers, 4);
        assertEqualNumbers(new int[]{3, 3}, numbers,length);
    }

    private void assertEqualNumbers(int[] expected, int[] nums, int length) {
        assertEquals(expected.length, length);
        for (int i = 0; i < length; i++)
            assertEquals(expected[i], nums[i]);
    }
}
