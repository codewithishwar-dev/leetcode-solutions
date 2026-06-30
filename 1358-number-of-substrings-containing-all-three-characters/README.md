# 1358. Number of Substrings Containing All Three Characters

**Difficulty:** Medium

## Problem

Given a string `s` consisting only of the characters `'a'`, `'b'`, and `'c'`.

Return the number of substrings containing at least one occurrence of all three characters.

### Example 1

```text
Input: s = "abcabc"
Output: 10
```

### Example 2

```text
Input: s = "aaacb"
Output: 3
```

### Example 3

```text
Input: s = "abc"
Output: 1
```

---

## Approach 1: Sliding Window

### Intuition

We need to count every substring that contains at least one `'a'`, `'b'`, and `'c'`.

Instead of checking every possible substring (`O(n²)`), we maintain a sliding window.

Whenever the current window contains all three characters:

- Every substring starting at `left` and ending from `right` to `n - 1` is also valid.
- Therefore, we add:

```text
n - right
```

to the answer.

Then we shrink the window from the left to discover more valid windows.

---

## Algorithm

1. Initialize two pointers (`left` and `right`).
2. Expand the window by moving `right`.
3. Count occurrences of `'a'`, `'b'`, and `'c'`.
4. While all three characters are present:
   - Add `n - right` to the answer.
   - Remove the left character.
   - Move `left`.
5. Continue until the end of the string.

---

## Dry Run

```text
s = "abcabc"

right = 0 -> a
Window = "a"
Not valid

right = 1 -> b
Window = "ab"
Not valid

right = 2 -> c
Window = "abc"

Valid

Add:
6 - 2 = 4

Substrings:
abc
abca
abcab
abcabc

Shrink window

right = 3

Window = "bca"

Valid

Add:
6 - 3 = 3

Total = 7

right = 4

Window = "cab"

Valid

Add:
6 - 4 = 2

Total = 9

right = 5

Window = "abc"

Valid

Add:
6 - 5 = 1

Total = 10
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Alternative Approach: Last Seen Indices

Maintain the last occurrence of `'a'`, `'b'`, and `'c'`.

For every index:

```
answer += min(lastA, lastB, lastC) + 1
```

This also runs in:

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Learning

- Sliding Window
- Two Pointers
- Counting Valid Substrings
- Constant Space Optimization

---

## Tags

- Sliding Window
- Two Pointers
- Strings
- Hashing
- LeetCode Medium
