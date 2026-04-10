# 🧠 13. Roman to Integer

Convert a Roman numeral to an integer.

---

## 📌 Problem Statement

Roman numerals are represented by seven symbols:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

### ⚠️ Special Cases (Subtraction Rule)

* IV → 4
* IX → 9
* XL → 40
* XC → 90
* CD → 400
* CM → 900

---

## 🚀 Approach

👉 Traverse from **right to left**

* If current value < previous → subtract
* Else → add

---

## 💻 Code (Java)

```java
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = value(s.charAt(i));

            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }

            prev = current;
        }

        return result;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
```

---

## 🧪 Example

Input:

```
MCMXCIV
```

Output:

```
1994
```

---

## ⏱ Complexity

* Time: O(n)
* Space: O(1)

---

## 🔥 Key Insight

> If a smaller value appears before a larger value → subtract it.

---

## 📣 Connect with Me

Follow for more:

* 💻 GitHub: CodeWithIshwar
* 🔗 LinkedIn: https://www.linkedin.com/in/ishwar-chandra-tiwari-51610b26/

---

⭐ Star this repo if it helped you!
