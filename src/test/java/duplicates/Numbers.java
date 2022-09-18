package duplicates;

public class Numbers {
    public static int removeDuplicates(int[] nums) {
        int k;
        if (nums.length == 2) {
            if (nums[0] == nums[1]) return 1;
            else return 2;
         }
        if (nums.length == 3) { // [100, 101, 101]
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return 1;
            } else if (nums[0] == nums[1] && nums[1] != nums[2]) {
                nums[1] = nums[2];
                return 2;
            } else if (nums[0] != nums[1] && nums[1] == nums[2]) {
                return 2;
            } else if (nums[0] != nums[1] && nums[1] != nums[2]) {
                return 3;
            }
         }
        return 1;
    }
}
