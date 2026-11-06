# 3505. Minimum Operations to Make Elements Within K Subarrays Equal

**Difficulty:** Hard  
**Topics:** Sliding Window, Fenwick Tree (BIT), Coordinate Compression, Dynamic Programming  
**Language:** Java

## Problem Statement

Given an integer array `nums` and two integers `x` and `k`, we can increase or decrease any element by 1 in one operation.

Return the minimum number of operations required to make all elements equal within at least `k` non-overlapping subarrays, each having exactly `x` elements.

## Approach: Sliding Window + Fenwick Tree + Dynamic Programming

### 1. Sliding Window

Calculate the minimum cost of making every window of size `x` equal.

The optimal target is the median of the window because the median minimizes the sum of absolute differences.

### 2. Fenwick Tree

Use two Fenwick Trees:

- **Count BIT:** Maintains element frequencies.
- **Sum BIT:** Maintains the sum of elements.

Coordinate compression allows efficient indexing.

The median and cost of each window can be calculated in `O(log n)`.

### 3. Dynamic Programming

Define:

`dp[j][i]` = Minimum cost of selecting exactly `j` non-overlapping subarrays from the first `i` elements.

Transition:

```text
dp[j][i] = min(
    dp[j][i - 1],
    dp[j - 1][i - x] + cost[i - x]
)
```

Rolling arrays optimize the space complexity.

## Complexity Analysis

| Metric | Complexity |
|---|---|
| Time | O(n log n + n × k) |
| Space | O(n) |

## Example

**Input:**
```text
nums = [5,-2,1,3,7,3,6,4,-1]
x = 3
k = 2
```

**Output:**
```text
8
```

## Key Learnings

- Median-based optimization
- Sliding Window technique
- Fenwick Tree for frequency and prefix sums
- Coordinate Compression
- DP with non-overlapping intervals
- Space optimization using rolling arrays

## Author

**CodeWithIshwar**

Building problem-solving skills through consistent DSA practice.

GitHub: https://github.com/CodeWithIshwar-dev
**CodeWithIshwar | Ishwar Chandra Tiwari**
