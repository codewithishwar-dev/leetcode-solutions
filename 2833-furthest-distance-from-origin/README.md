# 2833. Furthest Point From Origin

## 🧩 Problem

You are given a string `moves` consisting of:

* `'L'` → move left
* `'R'` → move right
* `'_'` → can move either left or right

Return the **maximum distance from origin (0)** after all moves.

---

## 💡 Approach

* Count:

  * `L` → left moves
  * `R` → right moves
  * `_` → flexible moves

* Use `_` to maximize distance in one direction.

### Formula:

```
abs(R - L) + _
```

---

## ⏱️ Complexity

* Time: `O(n)`
* Space: `O(1)`

---

## 💻 Java Solution

```java
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0, countR = 0, countUnderscore = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') countL++;
            else if (ch == 'R') countR++;
            else countUnderscore++;
        }

        return Math.abs(countR - countL) + countUnderscore;
    }
}
```

---

## 🚀 Example

Input: `"L_RL__R"`
Output: `3`

---

## 🧠 Key Insight

Flexible moves (`_`) always help you go further in the direction where you already have advantage.
