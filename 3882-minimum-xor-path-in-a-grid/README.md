# 3882. Minimum XOR Path in a Grid

**Difficulty:** Medium  
**Topics:** Dynamic Programming, Bit Manipulation, Grid Traversal  
**Language:** Java

## Problem Statement

Given an `m × n` integer grid, start at the top-left cell `(0, 0)` and reach the bottom-right cell `(m - 1, n - 1)`.

You can move only right or down. The cost of a path is the bitwise XOR of all cell values along that path.

Return the minimum possible XOR value among all valid paths.

## Approach: Dynamic Programming + Bit Manipulation

Since each grid value is at most `1023`, every possible path XOR also lies between `0` and `1023`.

Define:

`dp[i][j][x] = true`

if a path from the starting cell to `(i, j)` can produce XOR value `x`.

For each cell:
1. Consider all reachable XOR values from the cell above.
2. Consider all reachable XOR values from the cell to the left.
3. XOR each value with the current cell's value.
4. Return the smallest reachable XOR value at the destination.

Tracking all reachable XOR values is necessary because XOR is not monotonic. Keeping only the minimum intermediate value can produce an incorrect answer.

## Complexity Analysis

Let `K = 1024`, the number of possible XOR values.

- **Time Complexity:** `O(m × n × K)`
- **Space Complexity:** `O(m × n × K)`

## Example

**Input:**
```text
grid = [[1, 2],
        [3, 4]]
```

**Output:**
```text
6
```

Explanation:

- Right, then down: `1 ^ 2 ^ 4 = 7`
- Down, then right: `1 ^ 3 ^ 4 = 6`

The minimum XOR value is `6`.

## Key Learning

XOR-based path problems often require tracking multiple states rather than just the smallest value at each cell.

---

Part of the CodeWithIshwar LeetCode Solutions collection.
CodeWithIshwar | Ishwar Chandra Tiwari
