# 3838. Weighted Word Mapping

## Problem Statement

You are given:

* An array of strings `words`
* An integer array `weights` of length `26`, where `weights[i]` represents the weight of the `i-th` lowercase English letter.

For each word:

1. Calculate the sum of the weights of all its characters.
2. Compute `sum % 26`.
3. Map the result using reverse alphabetical order:

   * `0 → z`
   * `1 → y`
   * `2 → x`
   * ...
   * `25 → a`

Return the concatenation of all mapped characters.

---

## Intuition

Each character contributes a predefined weight. By summing the weights of all characters in a word, we obtain the word's total weight.

The modulo operation restricts the value to the range `[0, 25]`, allowing it to be mapped directly to a lowercase letter in reverse alphabetical order.

---

## Approach

1. Iterate through each word.
2. Calculate the total weight of the word.
3. Compute `totalWeight % 26`.
4. Convert the modulo value to a character using:

```java
(char) ('z' - mod)
```

5. Append the character to the result string.

---

## Solution

```java
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            ans.append((char) ('z' - (sum % 26)));
        }

        return ans.toString();
    }
}
```

---

## Dry Run

### Input

```text
words = ["abcd", "def", "xyz"]
```

### Computation

```text
"abcd" = 5 + 3 + 12 + 14 = 34
34 % 26 = 8
8 → r

"def" = 14 + 1 + 2 = 17
17 % 26 = 17
17 → i

"xyz" = 7 + 7 + 2 = 16
16 % 26 = 16
16 → j
```

### Output

```text
"rij"
```

---

## Complexity Analysis

### Time Complexity

```text
O(N × M)
```

Where:

* `N` = number of words
* `M` = average length of a word

### Space Complexity

```text
O(1)
```

Excluding the output string.

---

## Key Takeaway

The reverse alphabet mapping can be performed efficiently without any lookup table:

```java
(char) ('z' - (sum % 26))
```

This keeps the solution simple, clean, and optimal.

---

### Author

**Ishwar Chandra Tiwari** | 
**Code With Ishwar 🚀**
