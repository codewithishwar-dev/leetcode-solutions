from typing import List


class Solution:

    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)

        # Prefix sum array
        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]

        # dp[l][r] = maximum score Alice can obtain
        # from the subarray stoneValue[l...r]
        dp = [[0] * n for _ in range(n)]

        # Process intervals from smaller to larger
        for length in range(2, n + 1):

            for l in range(n - length + 1):
                r = l + length - 1

                # Try every possible split
                for k in range(l, r):

                    # Sum of stoneValue[l...k]
                    left_sum = prefix[k + 1] - prefix[l]

                    # Sum of stoneValue[k+1...r]
                    right_sum = prefix[r + 1] - prefix[k + 1]

                    if left_sum < right_sum:

                        # Bob removes the right part.
                        # Alice keeps the left part.
                        dp[l][r] = max(
                            dp[l][r],
                            left_sum + dp[l][k]
                        )

                    elif left_sum > right_sum:

                        # Bob removes the left part.
                        # Alice keeps the right part.
                        dp[l][r] = max(
                            dp[l][r],
                            right_sum + dp[k + 1][r]
                        )

                    else:

                        # Equal sums:
                        # Alice can choose either side.
                        dp[l][r] = max(
                            dp[l][r],
                            left_sum + max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        )

        return dp[0][n - 1]
