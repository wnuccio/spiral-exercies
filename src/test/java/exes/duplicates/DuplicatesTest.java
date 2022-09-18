package exes.duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesTest {

    @Test
    void one_numbers_remains_the_same() {
        int[] nums = new int[]{100};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100}, nums, k);
    }

    @Test
    void two_equals_numbers() {
        int[] nums = new int[]{100, 100};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100}, nums, k);
    }

    @Test
    void two_different_numbers() {
        int[] nums = new int[]{100, 101};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101}, nums, k);
    }

    @Test
    void three_equal_numbers() {
        int[] nums = new int[]{100, 100, 100};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100}, nums, k);
    }

    @Test
    void three_numbers_first_two_equals() {
        int[] nums = new int[]{100, 100, 101};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101}, nums, k);
    }

    @Test
    void three_numbers_last_two_equals() {
        int[] nums = new int[]{100, 101, 101};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101}, nums, k);
    }

    @Test
    void three_numbers_all_different() {
        int[] nums = new int[]{100, 101, 102};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101, 102}, nums, k);
    }

    @Test
    void four_numbers_all_equals() {
        int[] nums = new int[]{100, 100, 100, 100};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100}, nums, k);
    }

    @Test
    void four_numbers_first_three_equals() {
        int[] nums = new int[]{100, 100, 100, 101};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101}, nums, k);
    }

    @Test
    void four_numbers_last_three_equals() {
        int[] nums = new int[]{100, 101, 101, 101};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101}, nums, k);
    }

    @Test
    void four_numbers_first_two_equals() {
        int[] nums = new int[]{100, 100, 101, 102};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101, 102}, nums, k);
    }

    @Test
    void four_numbers_middle_two_equals() {
        int[] nums = new int[]{100, 101, 101, 102};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101, 102}, nums, k);
    }

    @Test
    void four_numbers_last_two_equals() {
        int[] nums = new int[]{100, 101, 102, 102};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101, 102}, nums, k);
    }

    @Test
    void four_numbers_all_different() {
        int[] nums = new int[]{100, 101, 102, 103};
        int k = Numbers.removeDuplicates(nums);

        assertEqualNumbers(new int[]{100, 101, 102, 103}, nums, k);
    }

    private void assertEqualNumbers(int[] expected, int[] nums, int k) {
        assertEquals(expected.length, k);
        for (int i = 0; i < k; i++)
            assertEquals(expected[i], nums[i]);
    }
}
