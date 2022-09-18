package duplicates;

public class Numbers {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 2) {
            if (nums[0] == nums[1]) return 1;
            else return 2;
         }
        return 1;
    }
}
