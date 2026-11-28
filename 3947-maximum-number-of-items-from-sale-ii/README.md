# 3947. Maximum Number of Items From Sale II

**Difficulty:** Medium  
**Platform:** LeetCode  
**Topics:** Greedy, Sorting, Number Theory, Divisors, Mathematics

## Problem Statement

You are given a 2D integer array `items`, where `items[i] = [factor[i], price[i]]` represents an item type and its price.

You are also given an integer `budget`.

There are unlimited copies of each item available. Every purchased copy can provide at most one free copy of another item type whose factor is divisible by the purchased item's factor.

Each ordered pair of item types can generate a free copy only once.

Return the maximum number of total items you can obtain while staying within the budget.

## Approach

- Count the frequency of each factor.
- Calculate the number of eligible item types for every factor using multiples.
- Sort items by price.
- Prioritize purchases that unlock free copies.
- Spend the remaining budget on the cheapest available items.

## Java Solution

See `Solution.java` for the implementation.

## Complexity Analysis

| Metric | Complexity |
|---|---|
| Frequency calculation | O(n) |
| Divisor/multiple processing | O(n log n) |
| Sorting | O(n log n) |
| Greedy processing | O(n) |
| Space | O(n) |

**Overall Time Complexity:** O(n log n)  
**Space Complexity:** O(n)

## Example

**Input:**
```text
items = [[1,6],[2,4],[3,5]]
budget = 19
```

**Output:**
```text
5
```

## Key Learning

This problem demonstrates how greedy optimization, divisibility relationships, and frequency counting can be combined to solve a large-scale optimization problem.

---

**Ishwar Chandra Tiwari | CodeWithIshwar**

Consistency. Patterns. Real Engineering Thinking.
