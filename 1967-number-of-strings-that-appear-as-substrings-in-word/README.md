# 1967. Number of Strings That Appear as Substrings in Word

## Problem Statement

Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns` that exist as a substring in `word`.

A substring is a contiguous sequence of characters within a string.

**LeetCode Link:** https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

---

## Approach

Since the constraints are small, we can iterate through every string in `patterns` and check whether it exists as a substring of `word` using Java's built-in `String.contains()` method.

### Algorithm

1. Initialize a counter `count` to `0`.
2. Traverse each string in `patterns`.
3. If `word.contains(pattern)` returns `true`, increment the counter.
4. Return the final count.

---

## Complexity Analysis

* **Time Complexity:** `O(n × m)`

  * `n` = number of patterns
  * `m` = length of `word` (substring search)

* **Space Complexity:** `O(1)`

---

## Java Solution

```java
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}
```

---

## Example

### Input

```text
patterns = ["a","abc","bc","d"]
word = "abc"
```

### Output

```text
3
```

### Explanation

* `"a"` is a substring of `"abc"`.
* `"abc"` is a substring of `"abc"`.
* `"bc"` is a substring of `"abc"`.
* `"d"` is not a substring of `"abc"`.

Therefore, the answer is **3**.

---

## Key Takeaways

* Java's `String.contains()` provides a simple way to check substring existence.
* Duplicate patterns are counted individually if they appear in `word`.
* Given the small constraints, this straightforward approach is efficient enough.

---

**Language:** Java
**Difficulty:** Easy
**Tags:** String, Simulation
