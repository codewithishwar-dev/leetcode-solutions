# 3120. Count the Number of Special Characters I

**Difficulty:** Easy

## Problem Statement

A letter is called special if it appears both in lowercase and uppercase in the given string.

Return the number of special letters in `word`.

### Example 1

Input:
```text
word = "aaAbcBC"
```

Output:
```text
3
```

Explanation:

The special characters are `a`, `b`, and `c`.

### Example 2

Input:
```text
word = "abc"
```

Output:
```text
0
```

### Example 3

Input:
```text
word = "abBCab"
```

Output:
```text
1
```

## Approach

- Store lowercase letters in a set.
- Store uppercase letters in another set after converting them to lowercase.
- Count the characters present in both sets.

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Solution

```java
import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(Character.toLowerCase(ch));
            }
        }

        int count = 0;
        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
```
