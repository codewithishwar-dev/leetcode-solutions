# 2161. Partition Array According to Given Pivot

## Problem Link

https://leetcode.com/problems/partition-array-according-to-given-pivot/

## Difficulty

Medium

## Tags

- Array
- Two Pointers
- Simulation
- Stable Partition

## Problem Statement

Given an integer array `nums` and an integer `pivot`, rearrange the array such that:

- Every element less than `pivot` appears before every element greater than `pivot`.
- Every element equal to `pivot` appears between the smaller and greater elements.
- The relative order of elements less than `pivot` is preserved.
- The relative order of elements greater than `pivot` is preserved.

Return the rearranged array.

## Approach

Since the relative ordering of elements must remain unchanged, we perform a **stable partition**.

1. Traverse the array and collect all elements less than `pivot`.
2. Traverse again and collect all elements equal to `pivot`.
3. Traverse once more and collect all elements greater than `pivot`.
4. Combine these groups into the result array.

This guarantees that the original order within each group is preserved.

## Dry Run

### Input

```text
nums = [9,12,5,10,14,3,10]
pivot = 10
```

### Step 1: Elements < 10

```text
[9,5,3]
```

### Step 2: Elements = 10

```text
[10,10]
```

### Step 3: Elements > 10

```text
[12,14]
```

### Final Result

```text
[9,5,3,10,10,12,14]
```

## Solution

```java
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        return result;
    }
}
```

## Complexity Analysis

### Time Complexity

```text
O(n)
```

Three linear passes through the array.

### Space Complexity

```text
O(n)
```

Additional result array is used.

## Key Takeaway

The problem requires maintaining the relative order of elements, making a stable partition approach the simplest and most efficient solution.
