# 1340. Jump Game V

**Difficulty:** Hard

## Problem Statement

Given an integer array `arr` and an integer `d`, you can jump from index `i` to:

- `i + x` where `0 < x <= d`
- `i - x` where `0 < x <= d`

A jump from `i` to `j` is valid only if:

- `arr[i] > arr[j]`
- Every element between `i` and `j` is also smaller than `arr[i]`

Return the maximum number of indices that can be visited starting from any index.

---

## Approach: DFS + Memoization

Treat each index as a node in a directed graph.

Let:

`dp[i]` = maximum number of indices that can be visited starting from index `i`.

For every index:

1. Explore up to `d` positions to the left.
2. Explore up to `d` positions to the right.
3. Stop exploring in a direction once an element greater than or equal to the current value is encountered.
4. Store the result in `dp[i]` to avoid recomputation.

### Recurrence

```text
dp[i] = 1 + max(dp[j])
```

where `j` is a valid jump destination.

---

## Example

Input:

```text
arr = [6,4,14,6,8,13,9,7,10,6,12]
d = 2
```

Output:

```text
4
```

Path:

```text
10 → 8 → 6 → 7
```

---

## Complexity Analysis

### Time Complexity

```text
O(n × d)
```

Each index is computed once and explores at most `d` positions on both sides.

### Space Complexity

```text
O(n)
```

For memoization and recursion stack.

---

## Java Solution

```java
class Solution {
    ...
}
```

---

## Tags

- Dynamic Programming
- DFS
- Memoization
- Graph
