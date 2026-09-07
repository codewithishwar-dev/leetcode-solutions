class Solution:
    def distinctSubseqII(self, s: str) -> int:
        MOD = 10**9 + 7

        last = [0] * 26

        dp = 1  # Empty subsequence

        for ch in s:
            index = ord(ch) - ord('a')

            new_dp = (2 * dp - last[index]) % MOD

            last[index] = dp
            dp = new_dp

        # Remove the empty subsequence
        return (dp - 1) % MOD
