class Solution:
    def resultArray(self, nums: list[int], k: int) -> list[int]:
        # dp[r] = number of subarrays ending at the previous index
        # whose product % k == r
        dp = [0] * k

        # result[r] = total number of subarrays
        # whose product % k == r
        result = [0] * k

        for num in nums:
            value = num % k

            new_dp = [0] * k

            # Start a new subarray with the current element
            new_dp[value] += 1

            # Extend all previous subarrays
            for r in range(k):
                if dp[r] > 0:
                    new_remainder = (r * value) % k
                    new_dp[new_remainder] += dp[r]

            # Add subarrays ending at the current index
            for r in range(k):
                result[r] += new_dp[r]

            dp = new_dp

        return result
