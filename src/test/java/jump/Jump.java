package jump;

public class Jump {
    public static int jump(int[] nums) {
        int i=0;
        if (i == nums.length-1)
            return 0;
        if (nums.length == 2 && nums[0] > 0)
            return 1;

        return -1;
    }
}
