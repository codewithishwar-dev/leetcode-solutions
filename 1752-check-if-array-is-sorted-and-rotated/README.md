# 1752. Check if Array Is Sorted and Rotated

## Problem Statement
Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order and then rotated some number of positions (including zero). Otherwise, return `false`.

## Approach
A sorted and rotated array can have **at most one inversion (drop)** where:

```java
nums[i] > nums[(i + 1) % n]
```

The modulo operation handles the circular comparison between the last and first elements.

- Count the number of drops in the array.
- If the count exceeds `1`, the array cannot be sorted and rotated.
- Otherwise, return `true`.

## Solution

```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Example

### Input
```
nums = [3,4,5,1,2]
```

### Output
```
true
```

### Explanation
The array `[1,2,3,4,5]` is sorted and can be rotated by 2 positions to obtain `[3,4,5,1,2]`.
