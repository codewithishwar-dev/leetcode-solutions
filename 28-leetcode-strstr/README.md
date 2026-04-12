# 🔍 LeetCode 28 - Find the Index of the First Occurrence in a String

## 🧠 Problem

Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if it is not part of `haystack`.

---

## 🚀 Approaches

### 1️⃣ Brute Force

* Compare every substring
* Time Complexity: **O(n * m)**

### 2️⃣ KMP Algorithm (Optimized)

* Uses LPS (Longest Prefix Suffix)
* Avoids redundant comparisons
* Time Complexity: **O(n + m)**

---

## 💻 Code (Java)

### ✅ Brute Force

```java
public int strStr(String haystack, String needle) {
    int n = haystack.length();
    int m = needle.length();

    for (int i = 0; i <= n - m; i++) {
        int j = 0;

        while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
            j++;
        }

        if (j == m) return i;
    }

    return -1;
}
```

---

### ⚡ KMP (Optimal)

```java
class Solution {

    public int strStr(String haystack, String needle) {
        int[] lps = buildLPS(needle);

        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                return i - j;
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }

        return lps;
    }
}
```

---

## 📌 Example

```
Input:  haystack = "sadbutsad", needle = "sad"
Output: 0
```

---

## 🧑‍💻 Author

**CodeWithIshwar | Ishwar Chandra Tiwari** 🚀
Backend Developer | Problem Solver

---

## ⭐ If this helped, give it a star!
