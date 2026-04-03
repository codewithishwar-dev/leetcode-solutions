# 🧮 2169. Count Operations to Obtain Zero

![LeetCode](https://img.shields.io/badge/LeetCode-Easy-green)
![Java](https://img.shields.io/badge/Language-Java-blue)
![Math](https://img.shields.io/badge/Topic-Math-orange)

---

## 🧠 Problem Summary

Given two non-negative integers `num1` and `num2`, perform operations until one becomes `0`.

### 🔁 Operation Rule:
- If `num1 >= num2` → `num1 = num1 - num2`
- Else → `num2 = num2 - num1`

👉 Return total number of operations.

---

## ✨ Examples

### Example 1:
Input: num1 = 2, num2 = 3
Output: 3

### Example 2:
Input: num1 = 10, num2 = 10
Output: 1

---

## ⚡ Optimized Approach (Euclidean Insight)

Instead of subtracting repeatedly, we can **batch operations using division**.

### 🔍 Key Idea:
- Subtraction multiple times = Division once
- This mirrors the **Euclidean Algorithm (GCD)**

---

## 🧩 Algorithm

1. Initialize `count = 0`
2. While both numbers are non-zero:
   - If `num1 >= num2`
     - Add `num1 / num2` to count
     - Update `num1 %= num2`
   - Else:
     - Add `num2 / num1` to count
     - Update `num2 %= num1`
3. Return `count`

---

## 📊 Complexity Analysis

| Type  | Complexity |
|-------|----------|
| Time  | `O(log(max(num1, num2)))` |
| Space | `O(1)` |

---

## 🧠 Dry Run
num1 = 2, num2 = 3

Step 1: 3 / 2 = 1 → num2 = 1 → count = 1
Step 2: 2 / 1 = 2 → num1 = 0 → count = 3

✅ Answer = 3

---

## 💻 Java Solution

```java
class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 %= num2;
            } else {
                count += num2 / num1;
                num2 %= num1;
            }
        }

        return count;
    }
}


## CodeWithIshwar | Ishwar Chandra Tiwari
