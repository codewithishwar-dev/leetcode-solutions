# 🤖 657. Robot Return to Origin

🔗 Problem Link: https://leetcode.com/problems/robot-return-to-origin/  
🟢 Difficulty: Easy  

---

## 🧠 Problem Summary

A robot starts at position (0, 0) on a 2D plane.

Given a string `moves` consisting of:
- 'U' (up)
- 'D' (down)
- 'L' (left)
- 'R' (right)

Determine whether the robot returns to the origin after completing all moves.

---

## 💡 Approach

- Initialize two variables:
  - `x` for horizontal movement
  - `y` for vertical movement

- Traverse the string:
  - 'U' → y++
  - 'D' → y--
  - 'R' → x++
  - 'L' → x--

- At the end:
  - If `(x == 0 && y == 0)` → return true
  - Else → return false

---

## ⏱ Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

---

## 📌 Key Insight

Equal number of:
- 'U' and 'D'
- 'L' and 'R'

👉 means robot returns to origin.

---

## 💻 Code

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
            }
        }

        return x == 0 && y == 0;
    }
}
