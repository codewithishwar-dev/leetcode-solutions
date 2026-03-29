# 🔁 2839. Check if Strings Can be Made Equal With Operations I

## 🟢 Problem Level

**Easy**

## 🧩 Problem Summary

You are given two strings `s1` and `s2`, both of length **4**.

You can perform the following operation any number of times on either string:

* Choose indices `i` and `j` such that `j - i = 2`
* Swap characters at those indices

👉 Return `true` if you can make `s1` equal to `s2`, otherwise return `false`.

---

## 🔍 Key Insight

Only the following swaps are allowed:

* Index `0 ↔ 2`
* Index `1 ↔ 3`

### 💡 Important Observation

This creates **two independent groups**:

* **Even indices** → `[0, 2]`
* **Odd indices** → `[1, 3]`

👉 Characters can only move *within their group*, not across groups.

---

## 🧠 Approach

1. Extract characters at:

   * Even indices (0, 2)
   * Odd indices (1, 3)

2. Do this for both `s1` and `s2`

3. Sort both groups

4. Compare:

   * Even groups must match
   * Odd groups must match

---

## ✨ Example

### ✅ Example 1

```
Input:  s1 = "abcd", s2 = "cdab"
```

Split:

```
s1 → even: [a, c], odd: [b, d]
s2 → even: [c, a], odd: [d, b]
```

After sorting:

```
even → [a, c] == [a, c]
odd  → [b, d] == [b, d]
```

✔️ Output: `true`

---

### ❌ Example 2

```
Input:  s1 = "abcd", s2 = "dacb"
```

Split:

```
s1 → even: [a, c], odd: [b, d]
s2 → even: [d, c], odd: [a, b]
```

After sorting:

```
even → [a, c] ≠ [c, d]
```

❌ Output: `false`

---

## 💻 Java Solution

```java
import java.util.Arrays;

class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] s1Even = new char[]{s1.charAt(0), s1.charAt(2)};
        char[] s1Odd  = new char[]{s1.charAt(1), s1.charAt(3)};
        
        char[] s2Even = new char[]{s2.charAt(0), s2.charAt(2)};
        char[] s2Odd  = new char[]{s2.charAt(1), s2.charAt(3)};
        
        Arrays.sort(s1Even);
        Arrays.sort(s1Odd);
        Arrays.sort(s2Even);
        Arrays.sort(s2Odd);
        
        return Arrays.equals(s1Even, s2Even) &&
               Arrays.equals(s1Odd, s2Odd);
    }
}
```

---

## ⏱️ Complexity Analysis

| Operation               | Complexity |
| ----------------------- | ---------- |
| Sorting (constant size) | O(1)       |
| Overall                 | **O(1)**   |

---

## 🚀 Pattern Recognition

This problem is a classic example of:

* **Index grouping**
* **Restricted swaps**
* **Independent components**

👉 Whenever swaps are limited, think:

> “Which indices can actually interact?”

---

## 📌 Key Takeaways

* Not all permutations are possible → only **within groups**
* Split problem into **independent buckets**
* Compare sorted groups for equality

---

## 🏷️ Tags

`String` `Sorting` `Greedy` `Simulation` `Pattern Recognition`

---

## 🔗 Suggested Practice

Try similar patterns:

* Group-based swaps
* Parity-based transformations
* Connected components in arrays

---

## ✨ Author

**Ishwar | codewithishwar**

> Consistency + Pattern Recognition = Cracking DSA 🚀
