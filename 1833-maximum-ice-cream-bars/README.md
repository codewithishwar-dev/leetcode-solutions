# 1833. Maximum Ice Cream Bars

## Problem Statement

On a hot summer day, a boy wants to buy as many ice cream bars as possible.

You are given an integer array `costs` where `costs[i]` represents the cost of the `i-th` ice cream bar, and an integer `coins` representing the total number of coins available.

The boy can buy ice cream bars in any order. Return the maximum number of ice cream bars he can purchase.

**Constraint:** Solve the problem using **Counting Sort**.

---

## Example

### Example 1

```text
Input: costs = [1,3,2,4,1], coins = 7
Output: 4
```

### Example 2

```text
Input: costs = [10,6,8,7,7,8], coins = 5
Output: 0
```

### Example 3

```text
Input: costs = [1,6,3,1,2,5], coins = 20
Output: 6
```

---

## Approach

Since the problem explicitly requires a **Counting Sort** solution, we avoid sorting the array directly.

### Steps

1. Find the maximum cost in the array.
2. Create a frequency array where `freq[i]` stores the number of ice cream bars costing `i`.
3. Traverse costs from smallest to largest.
4. Buy as many bars as possible for each cost while coins are available.
5. Count the total bars purchased.

### Why This Works

To maximize the number of ice cream bars, we should always purchase the cheapest bars first. The frequency array allows us to process costs in ascending order efficiently without using a comparison-based sort.

---

## Java Solution

```java
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int cost = 1; cost <= maxCost && coins >= cost; cost++) {
            if (freq[cost] == 0) {
                continue;
            }

            int canBuy = Math.min(freq[cost], coins / cost);

            count += canBuy;
            coins -= canBuy * cost;
        }

        return count;
    }
}
```

---

## Complexity Analysis

* **Time Complexity:** `O(n + k)`

  * `n` = number of ice cream bars
  * `k` = maximum value in `costs`

* **Space Complexity:** `O(k)`

---

## Key Concepts

* Greedy Algorithm
* Counting Sort
* Frequency Array
* Array Traversal

---

## LeetCode

**Problem:** 1833. Maximum Ice Cream Bars
**Difficulty:** Medium
