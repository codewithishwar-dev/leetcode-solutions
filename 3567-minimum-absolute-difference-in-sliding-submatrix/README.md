# 3567. Minimum Absolute Difference in Sliding Submatrix

## 🧩 Problem
Given an `m x n` matrix and an integer `k`, for every `k x k` submatrix, find the minimum absolute difference between any two distinct values.

---

## 💡 Approach

For each `k x k` submatrix:

1. Collect all elements
2. Remove duplicates using a HashSet
3. Sort the elements
4. Compute minimum difference between adjacent elements

👉 If only one unique element → answer = 0

---

## 🚀 Algorithm

- Iterate over all possible top-left positions
- Extract elements of submatrix
- Sort unique values
- Compute minimum adjacent difference

---

## ⏱️ Complexity

- Time: `O(m * n * k^2 log k)`
- Space: `O(k^2)`

---

## 🧠 Key Insight

Sorting helps reduce comparisons from `O(n^2)` to `O(n)` by only checking adjacent elements.

---

## 📌 Example

Input:
grid = [[1,-2,3],[2,3,5]], k = 2
Output:
[[1,2]]


---

## 🏷️ Tags
`Array` `Matrix` `Sorting` `Sliding Window`

---

## 👨‍💻 Author
Ishwar Chandra Tiwari  
#CodeWithIshwar 🚀
