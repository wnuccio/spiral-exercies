package duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesTest {

    @Test
    void one_numbers_remains_the_same() {
        int[] nums = new int[]{100};
        int k = Numbers.removeDuplicates(nums);
        assertEquals(1, k);
        assertEquals(100, nums[0]);
    }
}
