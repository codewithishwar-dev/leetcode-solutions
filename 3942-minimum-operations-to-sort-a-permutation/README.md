# 3942. Minimum Operations to Sort a Permutation

**Difficulty:** Medium  
**Language:** Java  
**Topics:** Arrays, Permutations, Reversal, Rotation, Math

## Problem Statement

You are given an integer array `nums` of length `n`, which is a permutation of integers from `0` to `n - 1`.

You can perform two operations:

1. **Reverse the entire array.**
2. **Rotate left by one:** Move the first element to the end of the array.

Return the minimum number of operations required to sort the permutation in increasing order. If sorting is impossible, return `-1`.

## Examples

**Example 1**

```text
Input: nums = [0, 2, 1]
Output: 2
```

Explanation:

```text
[0, 2, 1]
[2, 1, 0]  // Rotate left
[0, 1, 2]  // Reverse
```

**Example 2**

```text
Input: nums = [1, 0, 2]
Output: 2
```

**Example 3**

```text
Input: nums = [2, 0, 1, 3]
Output: -1
```

## Approach

The allowed operations can only transform the array through rotations and reversals.

A permutation is sortable if either:

- It is a cyclic rotation of the sorted permutation.
- Reversing it produces a cyclic rotation of the sorted permutation.

For each valid configuration, calculate the minimum operation count and return the smallest result. If neither configuration works, return `-1`.

## Java Solution

```java
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;

        while (nums[zeroIndex] != 0) {
            zeroIndex++;
        }

        // Check whether nums is a rotation of sorted order.
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            if (nums[(zeroIndex + i) % n] != i) {
                possible = false;
                break;
            }
        }

        int answer = Integer.MAX_VALUE;

        if (possible) {
            answer = Math.min(
                zeroIndex,
                n - zeroIndex + 2
            );
        }

        // Reverse the array.
        int[] reversed = new int[n];

        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }

        int reversedZeroIndex = 0;

        while (reversed[reversedZeroIndex] != 0) {
            reversedZeroIndex++;
        }

        // Check whether the reversed array is sortable by rotation.
        boolean reversedPossible = true;

        for (int i = 0; i < n; i++) {
            if (reversed[(reversedZeroIndex + i) % n] != i) {
                reversedPossible = false;
                break;
            }
        }

        if (reversedPossible) {
            answer = Math.min(
                answer,
                1 + Math.min(
                    reversedZeroIndex,
                    n - reversedZeroIndex
                )
            );
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)` for the reversed array.

## Key Takeaway

Instead of exploring every possible permutation, use the structure of rotations and reversals to check whether the sorted permutation is reachable.

---

**Author:** CodeWithIshwar  
**Repository:** [CodeWithIshwar-dev](https://github.com/CodeWithIshwar-dev)
