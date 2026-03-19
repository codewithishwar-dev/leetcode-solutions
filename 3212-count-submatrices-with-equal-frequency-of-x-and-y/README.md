# 3212. Count Submatrices With Equal Frequency of X and Y

## 🧠 Problem

Given a 2D grid consisting of characters:
- 'X'
- 'Y'
- '.'

Return the number of submatrices starting from (0,0) such that:
- Count of 'X' == Count of 'Y'
- At least one 'X' is present

---

## 💡 Approach

This is a **prefix sum problem (2D)**.

We only consider submatrices from:
(0,0) → (i,j)

### Steps:
1. Maintain two prefix matrices:
   - prefixX → count of 'X'
   - prefixY → count of 'Y'

2. For each cell (i, j):
   - Compute prefix sums
   - Check:
     - prefixX == prefixY
     - prefixX > 0

3. Count valid cells

---

## ⚡ Complexity

- Time: O(m × n)
- Space: O(m × n)

---

## 🧩 Pattern Used

- 2D Prefix Sum
- Matrix Traversal

---

## 🚀 Key Insight

This is NOT a general submatrix problem.

It only considers submatrices **anchored at (0,0)**.

---

## 🔥 Example

Input:
X X
X Y

Output: 0 

---

## ✨ Author

Ishwar Chandra Tiwari  
#CodeWithIshwar 🚀
