class Solution:
    def missingMultiple(self, nums, k):
        present = set(nums)

        multiple = k

        while multiple in present:
            multiple += k

        return multiple
