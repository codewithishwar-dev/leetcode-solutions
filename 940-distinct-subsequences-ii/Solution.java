class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long[] last = new long[26];

        long dp = 1; // Empty subsequence

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            long newDp = (2 * dp - last[index] + MOD) % MOD;

            last[index] = dp;
            dp = newDp;
        }

        // Remove the empty subsequence
        return (int) ((dp - 1 + MOD) % MOD);
    }
}
