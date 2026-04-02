class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Base case
        if (coins[0][0] >= 0) {
            for (int k = 0; k < 3; k++) {
                dp[0][0][k] = coins[0][0];
            }
        } else {
            dp[0][0][0] = coins[0][0];
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int bestPrev = Integer.MIN_VALUE;

                    if (i > 0) bestPrev = Math.max(bestPrev, dp[i - 1][j][k]);
                    if (j > 0) bestPrev = Math.max(bestPrev, dp[i][j - 1][k]);

                    if (bestPrev == Integer.MIN_VALUE) continue;

                    // Take value
                    dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + coins[i][j]);

                    // Neutralize if negative
                    if (coins[i][j] < 0 && k > 0) {
                        int bestPrevNeutral = Integer.MIN_VALUE;

                        if (i > 0) bestPrevNeutral = Math.max(bestPrevNeutral, dp[i - 1][j][k - 1]);
                        if (j > 0) bestPrevNeutral = Math.max(bestPrevNeutral, dp[i][j - 1][k - 1]);

                        if (bestPrevNeutral != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrevNeutral);
                        }
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int k = 0; k < 3; k++) {
            result = Math.max(result, dp[m - 1][n - 1][k]);
        }

        return result;
    }
}
