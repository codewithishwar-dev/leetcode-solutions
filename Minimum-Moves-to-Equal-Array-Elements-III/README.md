# 3736. Minimum Moves to Equal Array Elements III

**Difficulty:** Easy  
**Topics:** Array, Math  
**Language:** Java

## Problem Summary

Given an integer array `nums`, you can increase any element by 1 in one move.

Find the minimum number of moves required to make all array elements equal.

## Approach: Maximum Element + Greedy

Since we can only increase elements, the optimal target is the maximum element in the array.

1. Find the maximum element.
2. Calculate the difference between the maximum and every array element.
3. Sum all differences to get the minimum moves.

### Java Solution

```java
class Solution {
    public int minMoves(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += max - num;
        }

        return moves;
    }
}
```

## Example

**Input:**
```text
nums = [2, 1, 3]
```

**Output:**
```text
3
```

**Explanation:**

- Increase 2 to 3 → 1 move.
- Increase 1 to 3 → 2 moves.
- Total = 3 moves.

## Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(n) |
| Space | O(1) |

## Key Takeaway

When an array can only be increased to make all elements equal, choosing the maximum element as the target guarantees the minimum number of moves.

---

**#CodeWithIshwar #LeetCode #Java #DSA #ProblemSolving**
**CodeWithIshwar | Ishwar Chandra Tiwari**
