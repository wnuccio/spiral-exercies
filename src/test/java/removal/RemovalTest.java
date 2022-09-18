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

    private void assertEqualNumbers(int[] expected, int[] nums, int length) {
        assertEquals(expected.length, length);
        for (int i = 0; i < length; i++)
            assertEquals(expected[i], nums[i]);
    }
}
