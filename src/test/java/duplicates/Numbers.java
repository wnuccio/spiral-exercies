package duplicates;

public class Numbers {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i< nums.length; i++) {
            int current = nums[i];
            int lastUnique = nums[k - 1];
            if (current != lastUnique) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
