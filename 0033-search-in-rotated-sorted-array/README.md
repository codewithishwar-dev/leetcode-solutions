# 33. Search in Rotated Sorted Array

## Problem Statement

There is an integer array `nums` sorted in ascending order with distinct values.

Before being passed to your function, the array may be rotated at an unknown pivot index `k` such that:

```text
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
```

Given the rotated array `nums` and an integer `target`, return the index of `target` if it exists in the array; otherwise return `-1`.

You must design an algorithm with **O(log n)** runtime complexity.

---

## Examples

### Example 1

```text
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

### Example 2

```text
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

### Example 3

```text
Input: nums = [1], target = 0
Output: -1
```

---

## Approach

Since the array was originally sorted and then rotated, at least one half of the array remains sorted at every step.

Using Binary Search:

1. Find the middle element.
2. If it matches the target, return its index.
3. Determine which half is sorted:
   - Left half sorted if `nums[left] <= nums[mid]`
   - Otherwise, the right half is sorted.
4. Check whether the target lies within the sorted half.
5. Continue searching only in the relevant half.

This reduces the search space by half on every iteration, achieving **O(log n)** time complexity.

---

## Algorithm

1. Initialize `left = 0` and `right = n - 1`.
2. While `left <= right`:
   - Compute `mid`.
   - If `nums[mid] == target`, return `mid`.
   - If left half is sorted:
     - If target lies in the left half, move `right`.
     - Otherwise move `left`.
   - Else:
     - Right half is sorted.
     - If target lies in the right half, move `left`.
     - Otherwise move `right`.
3. If target is not found, return `-1`.

---

## Java Solution

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

---

## Complexity Analysis

### Time Complexity

```text
O(log n)
```

Binary Search eliminates half of the search space in each iteration.

### Space Complexity

```text
O(1)
```

Only a few extra variables are used.

---

## Key Learning

- Modified Binary Search
- Identifying the sorted half in a rotated array
- Efficient searching in rotated sorted arrays
- Maintaining logarithmic time complexity
