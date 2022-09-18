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
         }
        return k;
    }
}
