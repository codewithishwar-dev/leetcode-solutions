/**
 * LeetCode 1871 - Jump Game VII
 *
 * Approach:
 * Dynamic Programming + Sliding Window
 *
 * dp[i] indicates whether index i is reachable.
 * For each position i, we need at least one reachable index in
 * the range [i - maxJump, i - minJump].
 *
 * A sliding window count tracks how many reachable indices
 * currently exist in the valid range, allowing O(1) transitions.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            if (i - minJump >= 0 && dp[i - minJump]) {
                reachableCount++;
            }

            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            dp[i] = s.charAt(i) == '0' && reachableCount > 0;
        }

        return dp[n - 1];
    }
}
