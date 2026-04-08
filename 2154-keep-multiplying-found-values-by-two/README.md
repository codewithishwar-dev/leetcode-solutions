# 2154. Keep Multiplying Found Values by Two

## 🧩 Problem Statement

You are given an array of integers `nums` and an integer `original`.

If `original` exists in `nums`, multiply it by 2. Repeat this process until the number no longer exists in the array.

Return the final value.

---

## 🚀 Approach

* Store all elements in a **HashSet** for O(1) lookup
* Keep doubling `original` until it is no longer found

---

## 💻 Code

```java
import java.util.*;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
```

---

## ⏱ Complexity

* Time: **O(n)**
* Space: **O(n)**

---

## 🧠 Key Insight

Using a HashSet avoids repeated scanning of the array and makes lookup efficient.

---

## 🔥 Example

Input:

```
nums = [5,3,6,1,12], original = 3
```

Output:

```
24
```

---

## 📌 Tags

`Array` `Hashing` `Easy`

---

## 👨‍💻 Author

**Ishwar Chandra Tiwari| codewithishwar**
