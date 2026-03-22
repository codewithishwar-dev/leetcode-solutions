> "You don’t debug code — you debug your thinking."
# 1886. Determine Whether Matrix Can Be Obtained By Rotation

## 🧩 Problem
Given two `n x n` binary matrices `mat` and `target`, return `true` if `mat` can become `target` after rotating it in 90° increments.

---

## 💡 Approach

Instead of trying complex transformations, we simulate all possible rotations:

- 0° (original)
- 90°
- 180°
- 270°

After each rotation:
→ Compare with target

If any match → return `true`

---

## 🔁 Rotation Logic

For 90° clockwise rotation:
mat[i][j] → rotated[j][n - 1 - i]


---

## ⏱ Complexity

- Time: `O(n²)`
- Space: `O(n²)`
---

## ⏱ Complexity

- Time: `O(n²)`
- Space: `O(n²)`

✍️ Author

Ishwar Chandra Tiwari
🚀 CodeWithIshwar
