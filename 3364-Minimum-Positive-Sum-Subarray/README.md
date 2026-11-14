# 3364. Minimum Positive Sum Subarray

**Difficulty:** Easy  
**Topics:** Array, Brute Force, Subarray  
**Language:** Java

## Problem

Given an integer array `nums` and two integers `l` and `r`, find the minimum sum of a contiguous subarray whose length is between `l` and `r` (inclusive) and whose sum is strictly positive.

Return `-1` if no such subarray exists.

## Approach: Brute Force

We iterate through every possible starting index and calculate subarray sums incrementally.

### Algorithm

1. Initialize `minSum` with `Integer.MAX_VALUE`.
2. Iterate through the array using a starting index.
3. Expand the subarray while its length does not exceed `r`.
4. Maintain the running sum.
5. If the subarray length is at least `l` and its sum is positive, update the minimum.
6. Return `-1` if no valid subarray is found.

## Java Solution

```java
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n && j - i + 1 <= r; j++) {
                sum += nums.get(j);

                int length = j - i + 1;

                if (length >= l && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n × r) — Each starting index explores at most `r` elements.
- **Space Complexity:** O(1) — Only a few variables are used.

## Example

**Input:**
```text
nums = [3, -2, 1, 4]
l = 2
r = 3
```

**Output:**
```text
1
```

**Explanation:**

The subarray `[3, -2]` has length 2 and sum 1, which is the minimum positive sum.

## Key Takeaway

Incremental sum calculation avoids repeatedly calculating the sum of each subarray.

When constraints are small, a simple brute-force approach can be both readable and efficient.

---

**#LeetCode #Java #DSA #Array #ProblemSolving #CodeWithIshwar**
