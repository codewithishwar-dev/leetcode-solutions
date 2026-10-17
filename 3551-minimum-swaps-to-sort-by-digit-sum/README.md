# 3551. Minimum Swaps to Sort by Digit Sum

**Difficulty:** Medium  
**Topic:** Sorting, HashMap, Cycle Detection  
**Language:** Java

## Problem Statement

Given an array of distinct positive integers, sort the numbers in ascending order based on their digit sum. If two numbers have the same digit sum, the smaller number comes first.

Return the minimum number of swaps required to rearrange the array into the sorted order.

## Examples

### Example 1

**Input**
```text
nums = [37, 100]
```

**Output**
```text
1
```

**Explanation**

The digit sums are `[10, 1]`. The target order is `[100, 37]`, requiring one swap.

### Example 2

**Input**
```text
nums = [22, 14, 33, 7]
```

**Output**
```text
0
```

**Explanation**

The digit sums are `[4, 5, 6, 7]`. The array is already sorted.

### Example 3

**Input**
```text
nums = [18, 43, 34, 16]
```

**Output**
```text
2
```

**Explanation**

The target order is `[16, 34, 43, 18]`. Two swaps are sufficient.

## Approach: Sorting + Cycle Detection

1. Calculate the digit sum of every number.
2. Sort the numbers by digit sum, breaking ties by numerical value.
3. Map each number to its original index using a HashMap.
4. Build a permutation representing the original positions of the target elements.
5. Count cycles in the permutation. A cycle of length `k` requires `k - 1` swaps.

## Java Solution

See `Solution.java` for the complete implementation.

## Complexity Analysis

- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)`

## Key Learning

Cycle detection is a powerful technique for minimum-swap problems. Once the target arrangement is known, each permutation cycle can be resolved in exactly one fewer swap than its length.

---

**Practice. Learn. Build. Share.**  
*CodeWithIshwar — Building stronger problem-solving skills, one problem at a time.*
