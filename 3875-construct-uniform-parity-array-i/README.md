# 3875. Construct Uniform Parity Array I

**LeetCode:** [3875. Construct Uniform Parity Array I](https://leetcode.com/problems/construct-uniform-parity-array-i/)

**Difficulty:** Easy

## Problem Statement

You are given an array `nums1` of `n` distinct integers.

You need to construct another array `nums2` of the same length such that all elements in `nums2` have the same parity:

* All elements are **odd**, or
* All elements are **even**.

For every index `i`, you can choose exactly one of:

* `nums2[i] = nums1[i]`
* `nums2[i] = nums1[i] - nums1[j]`, where `j != i`

Return `true` if it is possible to construct such an array.

## Approach

The answer is always `true`.

There are two cases:

### Case 1: All numbers are even

We can simply choose every element as-is.

For example:

```text
nums1 = [2, 4, 6]

nums2 = [2, 4, 6]
```

All elements are even.

### Case 2: There is at least one odd number

Keep every odd number unchanged.

For every even number, subtract an odd number:

```text
even - odd = odd
```

Therefore, every element can be made odd.

For example:

```text
nums1 = [2, 3]

2 - 3 = -1   → odd
3             → odd

nums2 = [-1, 3]
```

All elements are odd.

Since `nums1` contains distinct integers and `n >= 1`, an appropriate choice is always possible.

## Java Solution

```java
class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
```

## Python Solution

```python
class Solution:
    def uniformArray(self, nums1):
        return True
```

## Complexity Analysis

Since we don't need to inspect the array:

* **Time Complexity:** `O(1)`
* **Space Complexity:** `O(1)`

## Key Takeaway

The important observation is:

> If all numbers are even, keep them unchanged. Otherwise, use an odd number to turn every even number into an odd number.

Hence, the result is always:

```text
true
```
