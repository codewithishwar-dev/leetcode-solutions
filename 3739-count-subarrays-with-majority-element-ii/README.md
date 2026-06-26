# 3739. Count Subarrays With Majority Element II

**Difficulty:** Hard  
**Topics:** Array, Prefix Sum, Fenwick Tree, Coordinate Compression

## Problem

Given an integer array `nums` and an integer `target`, return the number of subarrays in which `target` is the **majority element**.

A majority element is one that appears **strictly more than half** of the times in the subarray.

---

## Examples

### Example 1

```text
Input: nums = [1,2,2,3], target = 2
Output: 5
```

### Example 2

```text
Input: nums = [1,1,1,1], target = 1
Output: 10
```

### Example 3

```text
Input: nums = [1,2,3], target = 4
Output: 0
```

---

## Intuition

Instead of directly counting the frequency of the target in every subarray, transform the array:

- `+1` if the element equals `target`
- `-1` otherwise

For any subarray:

```
sum = targetCount - otherCount
```

The target is the majority iff

```
targetCount > otherCount
```

which is equivalent to

```
sum > 0
```

The problem becomes counting subarrays with a **positive sum**.

---

## Approach

1. Convert the array into `+1` and `-1`.
2. Compute prefix sums.
3. A subarray is valid when:

```
prefix[j] > prefix[i]
```

4. Coordinate-compress the prefix sums.
5. Use a Fenwick Tree (Binary Indexed Tree) to count how many previous prefix sums are smaller than the current prefix.

---

## Algorithm

1. Build the transformed array.
2. Compute prefix sums.
3. Compress prefix values.
4. Traverse prefix sums:
   - Query Fenwick Tree for smaller prefix sums.
   - Add the result to the answer.
   - Insert the current prefix sum.

---

## Complexity

| Complexity | Value |
|------------|-------|
| Time | **O(n log n)** |
| Space | **O(n)** |

---

## Key Concepts

- Prefix Sum
- Binary Indexed Tree (Fenwick Tree)
- Coordinate Compression
- Range Query
- Mathematical Transformation

---

## Solution

See **Solution.java**.
