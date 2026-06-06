# 2574. Left and Right Sum Differences

## Problem
Given an integer array `nums`, return an array `answer` where:

answer[i] = |leftSum[i] - rightSum[i]|

- leftSum[i] = sum of elements to the left of index i.
- rightSum[i] = sum of elements to the right of index i.

## Approach
Use a running prefix sum and the total array sum.

1. Compute total sum of the array.
2. Maintain `leftSum`.
3. For each index:
   - Subtract current element from total sum to get `rightSum`.
   - Compute absolute difference.
   - Update `leftSum`.

## Complexity
- Time: O(n)
- Space: O(1) extra space

## Java Solution

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i];
            answer[i] = Math.abs(leftSum - totalSum);
            leftSum += nums[i];
        }

        return answer;
    }
}
