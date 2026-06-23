class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int j = 0; j < m; j++) {
            up[j] = j;
            down[j] = m - 1 - j;
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixDown = new long[m + 1];
            long[] prefixUp = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixDown[i + 1] = (prefixDown[i] + down[i]) % MOD;
                prefixUp[i + 1] = (prefixUp[i] + up[i]) % MOD;
            }

            long totalUp = prefixUp[m];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int x = 0; x < m; x++) {
                newUp[x] = prefixDown[x];
                newDown[x] =
                    (totalUp - prefixUp[x + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
