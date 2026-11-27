# 3946. Maximum Number of Items From Sale I

**Difficulty:** Medium  
**Topics:** Array, Dynamic Programming, Knapsack  
**Language:** Java  
**Platform:** [LeetCode](https://leetcode.com/problems/maximum-number-of-items-from-sale-i/)

## Problem Statement

You are given a 2D integer array `items`, where `items[i] = [factor_i, price_i]` represents an item's factor and price.

You are also given an integer `budget`.

There are unlimited copies of each item available.

When you purchase at least one copy of item `i`, you receive one free copy of every other item `j` whose factor is divisible by `factor_i`.

Buying multiple copies of the same item does not generate additional free copies.

**Objective:** Return the maximum total number of items you can obtain, including purchased and free copies, without exceeding the given budget.

## Approach

The problem involves two separate decisions:

1. Whether to purchase an item type at least once to activate its free-item rewards.
2. How many additional copies to purchase within the remaining budget.

### 1. Calculate Free Rewards

For every item `i`, iterate through all other items `j`.

If:

```java
items[j][0] % items[i][0] == 0
```

then purchasing item `i` provides one free copy of item `j`.

### 2. Group Items by Price

Group items according to their purchase price to process possible activation choices efficiently.

### 3. Dynamic Programming

Use knapsack-style DP to track the maximum reward achievable for different spending amounts.

The DP must distinguish between selecting an item type for the first time and purchasing additional copies.

## Java Solution

See `Solution.java` for the implementation.

## Complexity Analysis

Let:
- `n` = number of item types
- `B` = available budget

| Operation | Complexity |
|---|---|
| Calculate free rewards | O(n²) |
| Group items by price | O(n + B) |
| Knapsack DP | O(nB) |
| Additional-copy evaluation | O(B²) |

**Overall Time Complexity:** O(n² + nB + B²)

**Space Complexity:** O(n + B)

## Key Learning

- Knapsack Dynamic Programming
- One-time activation rewards
- Unlimited purchases
- Divisibility relationships
- Separating activation cost from additional purchases

---

**Ishwar Chandra Tiwari | CodeWithIshwar**

Consistency. Patterns. Real Engineering Thinking.
