package insert;

public class InsertPosition {

    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return target <= nums[0] ? 0 :1;

        return -1;
    }
}
