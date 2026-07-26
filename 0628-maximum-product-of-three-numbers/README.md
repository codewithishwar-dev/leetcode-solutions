# 628. Maximum Product of Three Numbers

**Difficulty:** Easy  
**LeetCode:** https://leetcode.com/problems/maximum-product-of-three-numbers/

---

## Problem Statement

Given an integer array `nums`, find three numbers whose product is maximum and return the maximum product.

### Example 1

```text
Input: nums = [1,2,3]
Output: 6
```

### Example 2

```text
Input: nums = [1,2,3,4]
Output: 24
```

### Example 3

```text
Input: nums = [-1,-2,-3]
Output: -6
```

---

## Approach

The maximum product can come from one of two possibilities:

1. Product of the **three largest numbers**.
2. Product of the **two smallest (most negative) numbers** and the **largest number**.

Since the product of two negative numbers becomes positive, the second case can produce a larger result.

---

## Algorithm

1. Track the three largest numbers.
2. Track the two smallest numbers.
3. Return:

```text
max(
    max1 × max2 × max3,
    min1 × min2 × max1
)
```

---

## Dry Run

Input

```text
[-10, -10, 5, 2]
```

Largest numbers

```text
5, 2, -10
```

Smallest numbers

```text
-10, -10
```

Products

```text
5 × 2 × -10 = -100

-10 × -10 × 5 = 500
```

Answer

```text
500
```

---

## Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n³) | O(1) |
| Sorting | O(n log n) | O(1) |
| One Pass (Optimal) | **O(n)** | **O(1)** |

---

## Key Takeaways

- Don't always multiply the three largest numbers.
- Two negative numbers can produce a larger positive product.
- Tracking extremes in one pass gives an optimal solution.

---

## Tags

- Array
- Greedy
- Math
- One Pass
