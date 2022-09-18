package duplicates;

public class Numbers {
    public static int removeDuplicates(int[] nums) {
        int k = -1;
        if (nums.length == 1) {
            if (nums[0] == nums[0]) {
                k = 1;
            } else {
                k = -1;
            }
        } else if (nums.length == 2) {
            if (nums[0] == nums[1]) {
                k = 1;
            } else if (nums[0] != nums[1]) {
                k = 2;
            }
        } else if (nums.length == 3) { // [100, 101, 101]
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                k = 1;
            } else if (nums[0] == nums[1] && nums[1] != nums[2]) {
                nums[1] = nums[2];
                k = 2;
            } else if (nums[0] != nums[1] && nums[1] == nums[2]) {
                k = 2;
            } else if (nums[0] != nums[1] && nums[1] != nums[2]) {
                k = 3;
            }
        } else if (nums.length == 4) {
            return generalAlgorithm(nums);
        }
        return k;
    }

    /*         k         i
        [100, 100, 100, 101, 101, 102]
     */
    private static int generalAlgorithm(int[] nums) {
        int k = 1;
        for (int i=1; i<nums.length; i++) {
            int current = nums[i];
            int lastUnique = nums[k - 1];
            if (current == lastUnique) {
                continue;
            } else {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
