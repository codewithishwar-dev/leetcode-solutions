# 717. 1-bit and 2-bit Characters

## 🧩 Problem

We have two types of characters:

* `0` → one-bit character
* `10` or `11` → two-bit character

Given a binary array ending with `0`, determine if the last character is a one-bit character.

---

## 💡 Approach (Greedy)

* Traverse the array using a pointer.
* If `0` → move 1 step.
* If `1` → move 2 steps.
* Stop before the last index.

👉 If pointer lands exactly on last index → return `true`

---

## 🚀 Code

```java
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;

        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }

        return i == bits.length - 1;
    }
}
```

---

## ⏱ Complexity

* Time: O(n)
* Space: O(1)

---

## 🔥 Key Insight

This is a greedy pointer jumping problem — no need to actually decode the string.
