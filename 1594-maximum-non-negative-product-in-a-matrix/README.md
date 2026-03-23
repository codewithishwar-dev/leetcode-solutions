# 1594. Maximum Non-Negative Product in a Matrix

## 🟡 Difficulty: Medium

## 🧩 Problem Summary

You are given an `m x n` grid. You start at the top-left cell `(0,0)` and can only move **right** or **down**.

Find the path that gives the **maximum non-negative product**.

If no such product exists → return `-1`.

---

## 💡 Key Insight

Tracking only the maximum product is **not enough**.

Because:
- Negative × Negative = Positive
- A **minimum (negative)** value can become the **maximum later**

👉 So we track:
- `max[i][j]` → max product till cell
- `min[i][j]` → min product till cell

---

## ⚙️ Approach (DP)

At each cell:
max = max(
top_max * val,
top_min * val,
left_max * val,
left_min * val
)

min = min(
top_max * val,
top_min * val,
left_max * val,
left_min * val
)


---

## 🚨 Edge Case

- If final result is negative → return `-1`
- Else return result % (1e9 + 7)

---

## ⏱ Complexity

- Time: `O(m * n)`
- Space: `O(m * n)`

---

## 🧠 Interview Insight

> Sometimes your **worst path becomes your best path**.

---

## ✍️ Author

**Ishwar Chandra Tiwari**  
🚀 CodeWithIshwar
