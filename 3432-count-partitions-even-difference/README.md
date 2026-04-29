# 3432. Count Partitions with Even Sum Difference

## 🧠 Problem
Given an integer array, count the number of partitions such that the difference between left and right subarray sums is even.

## 💡 Key Insight
Let:
- total = sum(nums)
- left = prefix sum

Condition:
(left - right) is even

→ (2 * left - total) is even

Since `2 * left` is always even, the result depends only on `total`.

## ✅ Conclusion
- If total is odd → 0
- If total is even → n - 1

## 🚀 Approach
1. Compute total sum
2. Check parity
3. Return result accordingly

## ⏱ Complexity
- Time: O(n)
- Space: O(1)

## 💻 Code
```java
class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        return (total % 2 == 0) ? nums.length - 1 : 0;
    }
}
```
## CodeWithIshwar | Ishwar Chandra Tiwari
