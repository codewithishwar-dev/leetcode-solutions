from functools import lru_cache

class Solution:
    def PredictTheWinner(self, nums):
        @lru_cache(None)
        def dfs(left, right):
            if left == right:
                return nums[left]

            take_left = nums[left] - dfs(left + 1, right)
            take_right = nums[right] - dfs(left, right - 1)

            return max(take_left, take_right)

        return dfs(0, len(nums) - 1) >= 0
