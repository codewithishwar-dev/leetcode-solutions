class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] power(long[][] base, long exp) {
        int n = base.length;

        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return result;
    }

    private long[] multiplyMatVec(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[][] A = new long[m][m];

        for (int v = 1; v <= m; v++) {
            for (int w = 1; w <= m; w++) {
                if (v + w > m + 1) {
                    A[v - 1][w - 1] = 1;
                }
            }
        }

        long[] f2 = new long[m];

        for (int v = 1; v <= m; v++) {
            f2[v - 1] = v - 1;
        }

        long[][] P = power(A, n - 2L);

        long[] fn = multiplyMatVec(P, f2);

        long ans = 0;

        for (long x : fn) {
            ans = (ans + x) % MOD;
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }
}
