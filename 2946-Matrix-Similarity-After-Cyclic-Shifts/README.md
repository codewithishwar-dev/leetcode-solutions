# 2946. Matrix Similarity After Cyclic Shifts

## 🧩 Problem Statement

You are given an `m x n` integer matrix `mat` and an integer `k`.

The following process happens `k` times:

* Even-indexed rows (0, 2, 4, ...) are cyclically shifted **left**
* Odd-indexed rows (1, 3, 5, ...) are cyclically shifted **right**

Return `true` if the final matrix is identical to the original matrix, otherwise return `false`.

---

## 💡 Intuition

Instead of actually performing `k` shifts:

* Observe that shifting a row `n` times brings it back to the original state
* So, effective shifts = `k % n`

Now we just check if each element remains in the same position after applying the shift logic.

---

## 🔄 Approach

Let `shift = k % n`

For each row:

* **Even row (left shift)**
  Check:

  ```
  mat[i][j] == mat[i][(j + shift) % n]
  ```

* **Odd row (right shift)**
  Check:

  ```
  mat[i][j] == mat[i][(j - shift + n) % n]
  ```

If all elements satisfy the condition → return `true`

---

## 🚀 Code

```java
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int shift = k % n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i % 2 == 0) {
                    // even row → left shift
                    if (mat[i][j] != mat[i][(j + shift) % n]) {
                        return false;
                    }
                } else {
                    // odd row → right shift
                    if (mat[i][j] != mat[i][(j - shift + n) % n]) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
```

---

## ⏱️ Complexity

* **Time Complexity:** `O(m × n)`
* **Space Complexity:** `O(1)`

---

## 🎯 Key Takeaways

* Repeated operations → reduce using **modulo**
* Avoid simulation when direct mapping is possible
* Focus on **index transformation**

---

## 🔗 Tags

`Matrix` `Simulation` `Math` `Array`

---

## 👨‍💻 Author

**Ishwar | codewithishwar**
