class Solution {

    private int[] arr;
    private int[] dp;
    private int d;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;

        int n = arr.length;
        dp = new int[n];

        int answer = 1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i));
        }

        return answer;
    }

    private int dfs(int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        int best = 1;

        // Explore left
        for (int i = index - 1; i >= Math.max(0, index - d); i--) {
            if (arr[i] >= arr[index]) {
                break;
            }
            best = Math.max(best, 1 + dfs(i));
        }

        // Explore right
        for (int i = index + 1; i <= Math.min(arr.length - 1, index + d); i++) {
            if (arr[i] >= arr[index]) {
                break;
            }
            best = Math.max(best, 1 + dfs(i));
        }

        return dp[index] = best;
    }
}
