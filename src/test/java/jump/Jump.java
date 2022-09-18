package jump;

/*
    [1, 1, 1]
    [3, 2, 3, 2, .... ]

    [1, 1]
 */
public class Jump {

    private static int minJumps(int currentJumps, int[] nums, int currentIndex) {
        if (currentIndex > nums.length - 1)
            return -1;

        if (currentIndex == nums.length - 1)
            return currentJumps + 0;

        int maxJumpLength = nums[currentIndex];

        if (maxJumpLength == 0)
            return -1;

        int minRemainingJumps = -1;
        for (int i = 1; i <= maxJumpLength; i++) {
            int nextCandidate = minJumps(currentJumps, nums, currentIndex + i);
            if (nextCandidate == -1)
                continue;
            if (nextCandidate < minRemainingJumps || minRemainingJumps == -1)
                minRemainingJumps = nextCandidate + 1;
        }
        return (minRemainingJumps == -1) ? -1 : currentJumps + minRemainingJumps;
    }

    public static int jump(int[] nums) {
        return minJumps(0, nums, 0);
    }
}
