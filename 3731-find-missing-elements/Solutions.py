class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        min_num = min(nums)
        max_num = max(nums)

        num_set = set(nums)
        ans = []

        for num in range(min_num, max_num + 1):
            if num not in num_set:
                ans.append(num)

        return ans
