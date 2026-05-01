# 🚀 LeetCode Solutions

A collection of my solutions to LeetCode problems, focusing on clean code, optimal approaches, and interview-ready patterns.

---

## 📌 Problem: 1523. Count Odd Numbers in an Interval Range

### 🧠 Approach: Math (O(1))

Instead of iterating through the range, we use a mathematical formula to directly compute the number of odd integers between `low` and `high` (inclusive).

### ✅ Formula

```
count = (high + 1) / 2 - (low / 2)
```

---

### 💻 Java Solution

```java
class Solution {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }
}
```

---

### 🔍 Explanation

* `(x / 2)` → number of even numbers ≤ x
* `(x + 1) / 2` → number of odd numbers ≤ x
* So we calculate:

```
odds in range = odds ≤ high − odds < low
```

---

### ⏱ Complexity

* **Time:** O(1)
* **Space:** O(1)

---

## 📂 Repository Structure

```
leetcode-solutions/
 ├── easy/
 │    └── 1523-count-odd-numbers.java
 ├── medium/
 ├── hard/
 └── README.md
```

---

## 🎯 Goal

* Build strong problem-solving skills
* Master patterns for coding interviews
* Maintain consistent daily progress

---

## 🔥 Next Steps

More problems coming soon — stay tuned!

---

⭐ If you find this helpful, consider starring the repo!

## CodeWithIshwar | Ishwar Chandra Tiwari
