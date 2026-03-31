# 3474. Lexicographically Smallest Generated String

## 🧠 Problem Summary

You are given two strings:

* `str1` of length `n` consisting of `'T'` and `'F'`
* `str2` of length `m`

You need to construct a string `word` of length `n + m - 1` such that:

* If `str1[i] == 'T'` → `word[i..i+m-1] == str2`
* If `str1[i] == 'F'` → `word[i..i+m-1] != str2`

👉 Return the **lexicographically smallest** valid string
👉 If impossible, return `""`

---

## 💡 Key Insights

### 1. `'T'` = Hard Constraint

* Must strictly match `str2`
* Cannot be changed later

### 2. `'F'` = Soft Constraint

* Must ensure substring is NOT equal to `str2`

### 3. ⚠️ Critical Edge Case

If `'T'` constraints **force a substring equal to `str2` at an `'F'` index**, then:

```text
❌ No valid string exists
```

---

## 🚀 Approach

### Step 1: Initialize

* Create result array filled with `'?'`

### Step 2: Apply `'T'` Constraints

* Force match with `str2`
* If conflict → return `""`

### Step 3: Early Conflict Detection (IMPORTANT)

* Check all `'F'`
* If already matching `str2` → return `""`

### Step 4: Greedy Fill

* Replace `'?'` with smallest possible character (`'a' → 'z'`)
* Ensure no `'F'` condition is violated

---

## ✅ Java Solution

```java
import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] res = new char[n + m - 1];
        Arrays.fill(res, '?');

        // Step 1: Apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                        res[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: Early conflict detection for 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) return "";
            }
        }

        // Step 3: Fill remaining positions greedily
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    res[i] = c;

                    if (validAt(res, str1, str2, i)) {
                        break;
                    }
                }
            }
        }

        return new String(res);
    }

    private boolean validAt(char[] res, String str1, String str2, int idx) {
        int n = str1.length();
        int m = str2.length();

        int start = Math.max(0, idx - m + 1);
        int end = Math.min(n - 1, idx);

        for (int i = start; i <= end; i++) {
            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (res[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (str1.charAt(i) == 'T' && !match) return false;
            if (str1.charAt(i) == 'F' && match) return false;
        }

        return true;
    }
}
```

---

## ⏱ Complexity

* **Time:** `O(n * m * 26)`
* **Space:** `O(n + m)`

---

## 🔥 Example

```text
Input:
str1 = "TFTF"
str2 = "ab"

Output:
ababa
```

---

## 🎯 Takeaway

> Don’t fix invalid states later —
> build the string while maintaining all constraints.

---

## 🚀 Follow

If this helped you:

* ⭐ Star the repo
* 🔥 Follow for more DSA + System Design

**#CodeWithIshwar** | Ishwar Chandra Tiwari
