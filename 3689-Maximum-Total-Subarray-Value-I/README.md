# 3689. Maximum Total Subarray Value I

## Problem Summary

Given an integer array `nums` and an integer `k`, choose exactly `k` non-empty subarrays.

The value of a subarray is defined as:

`max(subarray) - min(subarray)`

Subarrays may overlap, and the same subarray can be chosen multiple times.

Return the maximum possible total value.

---

## Intuition

Since the same subarray can be selected more than once, the problem reduces to finding the maximum possible value of a single subarray.

Once that maximum value is known, we can simply choose that subarray `k` times.

For any subarray:

```text
value = max(subarray) - min(subarray)
```

The largest possible maximum is the global maximum element of the array, and the smallest possible minimum is the global minimum element.

Therefore, the maximum achievable subarray value is:

```text
max(nums) - min(nums)
```

A subarray containing both the global maximum and global minimum will achieve this value.

Thus, the answer becomes:

```text
k × (max(nums) - min(nums))
```

---

## Algorithm

1. Traverse the array and find the global maximum element.

2. Traverse the array and find the global minimum element.

3. Compute:

   ```text
   (max - min) * k
   ```

4. Return the result.

---

## Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

## Java Solution

```java
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = nums[0];
        long min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return (max - min) * k;
    }
}
```

---

## Example

### Input

```text
nums = [4,2,5,1]
k = 3
```

### Computation

```text
max(nums) = 5
min(nums) = 1

Maximum subarray value = 5 - 1 = 4

Answer = 4 × 3 = 12
```

### Output

```text
12
```
