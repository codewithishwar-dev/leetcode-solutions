class Solution {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        /*
         * dp[l][r] = maximum score Alice can obtain
         * from the subarray stoneValue[l...r].
         */
        int[][] dp = new int[n][n];

        /*
         * Process intervals from smaller to larger.
         * An interval of length 1 has score 0 because
         * it cannot be split.
         */
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                // Try every possible split point.
                for (int k = l; k < r; k++) {

                    // Sum of stoneValue[l...k]
                    int leftSum = prefix[k + 1] - prefix[l];

                    // Sum of stoneValue[k+1...r]
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {

                        /*
                         * Right part has the larger sum,
                         * so Bob removes it.
                         *
                         * Alice keeps the left part and
                         * receives leftSum.
                         */
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    } else if (leftSum > rightSum) {

                        /*
                         * Left part has the larger sum,
                         * so Bob removes it.
                         *
                         * Alice keeps the right part and
                         * receives rightSum.
                         */
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    } else {

                        /*
                         * Both parts have equal sums.
                         *
                         * Alice can choose which part to keep,
                         * so choose the one with the better
                         * future score.
                         */
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
