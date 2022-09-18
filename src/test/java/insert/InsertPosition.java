package insert;


public class InsertPosition {

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    /*
            [2] start = 0; end = 1
            target: 3
     */
    public static int search(int[] nums, int target, int start, int end) {
        if (start >= end)
            return start;

        // start < end
        int middle = (end - start) / 2;

        int middleVal = nums[middle];

        if (target == middleVal)
            return middle;
        else if (target < middleVal)
            return search(nums, target, start, middle);
        else // (target > middleVal)
            return search(nums, target, middle + 1, end);
    }
}
