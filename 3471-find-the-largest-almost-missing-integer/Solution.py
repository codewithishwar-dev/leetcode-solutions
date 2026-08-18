class Solution:
    def largestInteger(self, nums, k):
        count = {}

        for i in range(len(nums) - k + 1):
            seen = set(nums[i:i + k])

            for value in seen:
                count[value] = count.get(value, 0) + 1

        answer = -1

        for value, frequency in count.items():
            if frequency == 1:
                answer = max(answer, value)

        return answer
