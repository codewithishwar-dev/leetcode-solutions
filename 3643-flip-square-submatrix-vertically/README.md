# 🔁 3643. Flip Square Submatrix Vertically

---

## 🧩 Problem Statement

You are given an `m x n` integer matrix `grid`, and three integers `x`, `y`, and `k`.

* `(x, y)` represents the **top-left corner** of a square submatrix
* `k` represents the **size** of the square

👉 Your task is to **flip the submatrix vertically**, i.e., reverse the order of its rows.

---

## 🧠 Intuition

A vertical flip means:

* First row becomes last
* Second row becomes second last
* And so on...

✅ Important:
Only the **k × k submatrix** should be modified — not the entire grid.

---

## 🔍 Example

### Input:

```
grid =
[
 [1,  2,  3,  4],
 [5,  6,  7,  8],
 [9, 10, 11, 12],
 [13,14,15,16]
]

x = 1, y = 0, k = 3
```

### Submatrix:

```
[
 [5,  6,  7],
 [9, 10, 11],
 [13,14,15]
]
```

### After Flip:

```
[
 [13,14,15],
 [9, 10,11],
 [5,  6, 7]
]
```

---

## 🚀 Approach

1. Iterate through **half of the rows** → `k / 2`
2. For each row:

   * Swap elements with the corresponding row from the bottom
3. Only iterate columns inside the submatrix → `0 to k-1`

---

## ✅ Java Solution

```java
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                int temp = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
                grid[x + k - 1 - i][y + j] = temp;
            }
        }
        return grid;
    }
}
```

---

## ⏱ Complexity Analysis

* **Time Complexity:** `O(k²)`
  → We traverse the k × k submatrix

* **Space Complexity:** `O(1)`
  → In-place swapping, no extra space used

---

## ⚠️ Common Mistakes

* ❌ Swapping entire rows of the grid
* ❌ Going beyond submatrix boundaries
* ❌ Iterating full `k` rows instead of `k / 2`

---

## 🎯 Key Takeaway

> Vertical flip in a matrix = **row swapping within boundaries**

Mastering index manipulation is key for solving matrix problems efficiently.

---

## 🚀 Author

**Ishwar Chandra Tiwari**
💻 CodeWithIshwar
🔗 Building consistency through daily problem solving

---

## ⭐ Support

If you found this helpful, consider giving this repo a ⭐
