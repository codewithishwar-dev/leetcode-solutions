# 2089. Find Target Indices After Sorting Array

- **Platform:** LeetCode
- **Difficulty:** Easy
- **Topics:** Array, Sorting, Counting
- **Problem Link:** https://leetcode.com/problems/find-target-indices-after-sorting-array/

## Problem Statement

Given a 0-indexed integer array `nums` and an integer `target`, return a list of indices where `target` appears after sorting `nums` in non-decreasing order.

## Example

**Input**
```text
nums = [1, 2, 5, 2, 3]
target = 2
```

**Output**
```text
[1, 2]
```

**Explanation**

After sorting, the array becomes `[1, 2, 2, 3, 5]`. The target appears at indices `1` and `2`.

## Approach: Counting

1. Count the elements smaller than `target`.
2. Count the elements equal to `target`.
3. Start from the count of smaller elements and generate consecutive indices for all occurrences of the target.

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Auxiliary Space Complexity:** `O(1)`, excluding the output list.

## Key Takeaway

A sorted array's target positions can be determined by counting smaller and equal elements, without actually sorting the array.

## Tags

`#Java` `#LeetCode` `#Array` `#ProblemSolving` `#CodeWithIshwar`
