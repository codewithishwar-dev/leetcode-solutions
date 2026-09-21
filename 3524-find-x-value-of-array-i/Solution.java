class Solution {

    public long[] resultArray(int[] nums, int k) {
        long[] dp = new long[k];
        long[] result = new long[k];

        for (int num : nums) {
            int value = num % k;

            long[] newDp = new long[k];

            // Start a new subarray with the current element
            newDp[value]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (r * value) % k;
                    newDp[newRemainder] += dp[r];
                }
            }

            // Add subarrays ending at the current index
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}
