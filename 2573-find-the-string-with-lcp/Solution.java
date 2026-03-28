# 2573. Find the String with LCP

**Difficulty:** Hard  
**Topic:** Greedy, Dynamic Programming, Strings, Matrix

---

## Problem Statement

We are given an `n x n` **LCP matrix**, where:

- `lcp[i][j]` represents the length of the **longest common prefix**
  between suffixes `word[i..n-1]` and `word[j..n-1]`

Return the **lexicographically smallest string** that matches this matrix.

If no valid string exists, return an empty string.

---

## Key Insight

For any valid string:

\[
lcp[i][j] =
\begin{cases}
1 + lcp[i+1][j+1], & \text{if } word[i]=word[j] \\
0, & \text{otherwise}
\end{cases}
\]

This means:

- If `lcp[i][j] > 0`, then `word[i] == word[j]`
- If `lcp[i][j] == 0`, then `word[i] != word[j]`

So the matrix itself tells us which positions must contain the same character.

---

## Approach

### Step 1: Construct Lexicographically Smallest String

We greedily assign characters from `'a'` to `'z'`.

For each unassigned index:

- assign the current smallest character
- assign the same character to every index `j`
  where `lcp[i][j] > 0`

This ensures lexicographically smallest construction.

---

### Step 2: Validate Using DP

Construction alone is not enough.

We rebuild the LCP matrix using:

\[
dp[i][j] =
\begin{cases}
1 + dp[i+1][j+1], & s[i]=s[j] \\
0, & otherwise
\end{cases}
\]

If the rebuilt matrix differs from the input matrix,
return `""`.

---

## Java Solution

```java
class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        Arrays.fill(word, '#');

        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (word[i] != '#') continue;

            if (ch > 'z') return "";

            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) {
                    word[j] = ch;
                }
            }
            ch++;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }

                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}
```

---

## Complexity Analysis

- Construction: `O(n²)`
- Validation: `O(n²)`

### Total Complexity

`O(n²)`

---

## Key Learning

This problem combines:

- Greedy
- String grouping
- Lexicographical ordering
- Dynamic Programming validation

A great hard-level problem for pattern recognition.
