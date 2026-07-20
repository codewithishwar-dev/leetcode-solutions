# 1260. Shift 2D Grid

**Difficulty:** Easy  
**Language:** Java

## Problem Statement

Given an `m x n` 2D grid and an integer `k`, shift the grid `k` times.

In one shift operation:

- `grid[i][j]` moves to `grid[i][j + 1]`
- `grid[i][n - 1]` moves to `grid[i + 1][0]`
- `grid[m - 1][n - 1]` moves to `grid[0][0]`

Return the grid after applying the shift operation `k` times.

---

## Approach

Instead of performing `k` shifts one by one, treat the 2D grid as a **circular 1D array**.

### Steps

1. Calculate the current 1D index:
   ```
   index = row * cols + col
   ```
2. Compute the new position after shifting:
   ```
   newIndex = (index + k) % (rows * cols)
   ```
3. Convert the new index back to 2D coordinates:
   ```
   newRow = newIndex / cols
   newCol = newIndex % cols
   ```
4. Place the element in its new position.

This avoids repeated shifting and runs in linear time.

---

## Complexity Analysis

- **Time Complexity:** O(m × n)
- **Space Complexity:** O(m × n)

---

## Java Solution

```java
import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentIndex = i * n + j;
                int newIndex = (currentIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                result[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(result[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}
```

---

## Key Takeaways

- Convert a 2D matrix to a virtual 1D array.
- Use modular arithmetic for circular shifts.
- Convert the new 1D index back to 2D coordinates.
- Eliminates unnecessary repeated shifting.

**Tags:** `Array` `Matrix` `Simulation`
