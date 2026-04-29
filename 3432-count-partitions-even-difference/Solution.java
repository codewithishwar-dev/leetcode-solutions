class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // If total sum is odd → no valid partitions
        if (total % 2 != 0) {
            return 0;
        }

        // Otherwise, all partitions are valid
        return nums.length - 1;
    }
}
