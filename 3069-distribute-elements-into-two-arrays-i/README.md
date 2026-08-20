# 3069. Distribute Elements Into Two Arrays I

[LeetCode Problem](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

## Problem Statement

You are given a 1-indexed array of distinct integers `nums`.

You need to distribute all elements of `nums` between two arrays `arr1` and `arr2` using the following rules:

- In the first operation, append `nums[0]` to `arr1`.
- In the second operation, append `nums[1]` to `arr2`.
- For every remaining element:
  - If the last element of `arr1` is greater than the last element of `arr2`, append the current element to `arr1`.
  - Otherwise, append it to `arr2`.

Finally, concatenate `arr1` and `arr2` and return the resulting array.

## Example 1

### Input

```text
nums = [2,1,3]
