# 🚀 3546. Equal Sum Grid Partition I

## 🧩 Problem

Given an `m x n` grid of positive integers, determine if you can make **exactly one cut**:

* Horizontal OR Vertical
* Both resulting parts must be **non-empty**
* Both parts must have **equal sum**

---

## 🧠 Intuition

This is a **prefix sum problem in disguise**.

* Compute total sum
* If it's odd → ❌ impossible
* Otherwise → find a prefix (row/column) equal to `total / 2`

---

## ⚙️ Approach

### 1. Compute Total Sum

If `total % 2 != 0`, return `false`

### 2. Try Horizontal Cuts

* Add row sums progressively
* Stop at `m - 1` (to keep bottom non-empty)
* If prefix == half → ✅ return true

### 3. Try Vertical Cuts

* Precompute column sums
* Add column-wise prefix
* Stop at `n - 1`
* If prefix == half → ✅ return true

---

## 💻 Code

```java
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        if (total % 2 != 0) return false;

        long half = total / 2;

        long prefix = 0;

        // Horizontal cut
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                prefix += grid[i][j];
            }
            if (prefix == half) return true;
        }

        // Vertical cut
        long[] colSum = new long[n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[j] += grid[i][j];
            }
        }

        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            prefix += colSum[j];
            if (prefix == half) return true;
        }

        return false;
    }
}
```

---

## ⏱ Complexity

* Time: `O(m × n)`
* Space: `O(n)`

---

## ⚠️ Edge Cases

* Single row → only vertical cut possible
* Single column → only horizontal cut possible
* Use `long` to avoid overflow

---

## 🔥 Key Insight

> The problem is not about splitting — it's about finding a prefix equal to half.

---

## 🏷 Tags

`Prefix Sum` `Matrix` `Greedy`

---

## ✍️ Author

**CodeWithIshwar** | 
Ishwar Chandra Tiwari 
