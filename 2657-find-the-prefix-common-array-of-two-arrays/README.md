# 2657. Find the Prefix Common Array of Two Arrays

## Problem Statement

You are given two 0-indexed integer permutations `A` and `B` of length `n`.

A prefix common array of `A` and `B` is an array `C` such that:

- `C[i]` represents the count of numbers present in both arrays from index `0` to `i`.

Return the prefix common array of `A` and `B`.

---

## Example

### Input

```text
A = [1,3,2,4]
B = [3,1,2,4]
```

### Output

```text
[0,2,3,4]
```

### Explanation

| i | Prefix A | Prefix B | Common Elements | C[i] |
|---|----------|----------|------------------|------|
| 0 | [1] | [3] | {} | 0 |
| 1 | [1,3] | [3,1] | {1,3} | 2 |
| 2 | [1,3,2] | [3,1,2] | {1,2,3} | 3 |
| 3 | [1,3,2,4] | [3,1,2,4] | {1,2,3,4} | 4 |

---

## Approach

We use a boolean array `seen[]` to track numbers already encountered while traversing both arrays simultaneously.

### Key Idea

- If `A[i]` is already seen, it means it appeared earlier in `B`.
- If `B[i]` is already seen, it means it appeared earlier in `A`.

Each such occurrence increases the common count.

---

## Java Solution

```java
class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] result = new int[n];

        boolean[] seen = new boolean[n + 1];

        int commonCount = 0;

        for (int i = 0; i < n; i++) {

            // Process A[i]
            if (seen[A[i]]) {
                commonCount++;
            } else {
                seen[A[i]] = true;
            }

            // Process B[i]
            if (seen[B[i]]) {
                commonCount++;
            } else {
                seen[B[i]] = true;
            }

            result[i] = commonCount;
        }

        return result;
    }
}
```

---

## Complexity Analysis

### Time Complexity

O(n)

### Space Complexity

O(n)

---

## Tags

- Array
- Hashing
- Prefix
- Simulation

---

## LeetCode Link

https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
