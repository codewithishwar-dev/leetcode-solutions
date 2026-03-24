class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;

        int[] arr = new int[size];
        int idx = 0;

        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val % MOD;
            }
        }

        int[] prefix = new int[size];
        prefix[0] = 1;

        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        int[] result = new int[size];
        int suffix = 1;

        for (int i = size - 1; i >= 0; i--) {
            result[i] = (prefix[i] * suffix) % MOD;
            suffix = (suffix * arr[i]) % MOD;
        }

        int[][] ans = new int[n][m];
        idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = result[idx++];
            }
        }

        return ans;
    }
}
