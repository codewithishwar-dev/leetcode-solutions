# 1848. Minimum Distance to the Target Element

## 🧩 Problem

Given an integer array `nums` (0-indexed) and two integers `target` and `start`, find an index `i` such that:

* `nums[i] == target`
* `abs(i - start)` is minimized

Return the minimum distance.

---

## 💡 Approach

* Traverse the array
* Check all indices where `nums[i] == target`
* Calculate `abs(i - start)`
* Keep track of minimum distance

---

## ⚡ Optimized Approach

* Start from `start`
* Expand left and right
* Return as soon as target is found

---

## 🧠 Complexity

* Time: O(n)
* Space: O(1)

---

## 📌 Example

```
Input: nums = [1,2,3,4,5], target = 5, start = 3  
Output: 1
```
