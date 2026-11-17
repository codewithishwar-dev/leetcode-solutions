# 1524. Number of Sub-arrays With Odd Sum

**Platform:** LeetCode  
**Difficulty:** Medium  
**Topics:** Array, Prefix Sum, Counting, Parity  
**Language:** Java

## Problem

Given an integer array `arr`, return the number of subarrays with an odd sum.

Return the answer modulo `10^9 + 7`.

## Approach: Prefix Sum + Parity

Instead of calculating every subarray sum, maintain the parity (even or odd) of the running prefix sum.

A subarray has an odd sum when its two prefix sums have different parity.

- If the current prefix sum is even, add the number of previous odd prefix sums.
- If the current prefix sum is odd, add the number of previous even prefix sums.

Initially, `even = 1` because the empty prefix has a sum of zero.

## Java Solution

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        int even = 1;
        int odd = 0;

        int prefixSum = 0;
        long result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result += odd;
                even++;
            } else {
                result += even;
                odd++;
            }

            result %= MOD;
        }

        return (int) result;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) — Single traversal of the array.
- **Space Complexity:** O(1) — Constant extra space.

## Example

**Input:**
```text
arr = [1, 3, 5]
```

**Output:**
```text
4
```

**Explanation:**

The odd-sum subarrays are `[1]`, `[1,3,5]`, `[3]`, and `[5]`.

Total = 4.

## Key Takeaway

Prefix Sum Parity helps optimize subarray problems by tracking only whether the running sum is even or odd instead of calculating every possible subarray sum.

This reduces the solution from O(n²) to O(n).

---

**LeetCode:** https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

**#LeetCode #Java #DSA #Arrays #PrefixSum #ProblemSolving #CodeWithIshwar**

**CodeWithIshwar| Ishwar Chandra Tiwari**
