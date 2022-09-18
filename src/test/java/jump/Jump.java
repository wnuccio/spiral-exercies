package jump;

/*
    [1, 1, 1]
    [3, 2, 3, 2, .... ]

    [1, 1]
 */
public class Jump {

    private static int tryAllJumpLengths(int maxJumpLength, int currentJumps, int[] nums, int currentIndex) {
        int minRemainingJumps = -1;
        for (int i = maxJumpLength; i >= 1; i--) {
            int nextJumps = minJumps(currentJumps, nums, currentIndex + i);
            if (minRemainingJumps == 1) {
                minRemainingJumps = 1;
                break;
            }

            if (nextJumps == -1)
                continue;
            if (nextJumps < minRemainingJumps || minRemainingJumps == -1)
                minRemainingJumps = nextJumps;
        }
        return minRemainingJumps;
    }

    private static int minJumps(int currentJumps, int[] nums, int currentIndex) {
        int endIndex = nums.length - 1;

        if (currentIndex > endIndex)
            return -1;

        if (currentIndex == endIndex)
            return currentJumps + 0;

        int maxJumpLength = nums[currentIndex];

        if (maxJumpLength == 0)
            return -1;

        if (endIndex - currentIndex <= maxJumpLength)
            return currentJumps + 1;

        int minRemainingJumps = tryAllJumpLengths(maxJumpLength, currentJumps, nums, currentIndex);

        return (minRemainingJumps == -1) ? -1 : currentJumps + 1 + minRemainingJumps ;
    }

    public static int jump(int[] nums) {
        return minJumps(0, nums, 0);
    }
}
