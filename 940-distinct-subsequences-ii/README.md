# 940. Distinct Subsequences II

[LeetCode Problem](https://leetcode.com/problems/distinct-subsequences-ii/)

**Difficulty:** Hard

**Topics:** String, Dynamic Programming

---

## Problem

Given a string `s`, return the number of **distinct non-empty subsequences** of `s`.

Since the answer can be very large, return the result modulo:

```text
10^9 + 7
```

A subsequence is formed by deleting zero or more characters without changing the relative order of the remaining characters.

### Example 1

```text
Input: s = "abc"
Output: 7
```

Distinct subsequences:

```text
"a"
"b"
"c"
"ab"
"ac"
"bc"
"abc"
```

### Example 2

```text
Input: s = "aba"
Output: 6
```

Distinct subsequences:

```text
"a"
"b"
"ab"
"aa"
"ba"
"aba"
```

### Example 3

```text
Input: s = "aaa"
Output: 3
```

Distinct subsequences:

```text
"a"
"aa"
"aaa"
```

---

## Approach

The main challenge is handling **duplicate subsequences**.

Suppose we already have `dp` distinct subsequences, including the empty subsequence.

When we process a new character:

```text
c
```

we can append `c` to every existing subsequence.

Therefore, the number of subsequences would normally become:

```text
2 * dp
```

However, if `c` appeared previously, some of the newly created subsequences are duplicates of subsequences that were already created using the previous occurrence of `c`.

To remove these duplicates, maintain:

```text
last[c]
```

where `last[c]` stores the value of `dp` from before the previous occurrence of character `c`.

The recurrence is:

```text
newDp = 2 * dp - last[c]
```

We use modulo `10^9 + 7` to keep the values within range.

---

## Algorithm

1. Initialize `dp = 1`.

   * The empty subsequence is counted initially.

2. Create an array:

```text
last[26]
```

to store information about the last occurrence of each lowercase character.

3. For every character `ch` in the string:

   * Find its index.
   * Calculate:

```text
newDp = 2 * dp - last[index]
```

* Update `last[index]` with the old value of `dp`.
* Set `dp = newDp`.

4. At the end, subtract `1` to remove the empty subsequence.

---

## Dry Run

Consider:

```text
s = "aba"
```

Initially:

```text
dp = 1
```

### Process `'a'`

```text
newDp = 2 * 1 - 0
      = 2
```

Now:

```text
dp = 2
last[a] = 1
```

Subsequences:

```text
""
"a"
```

### Process `'b'`

```text
newDp = 2 * 2 - 0
      = 4
```

Now:

```text
dp = 4
last[b] = 2
```

Subsequences:

```text
""
"a"
"b"
"ab"
```

### Process second `'a'`

Before processing:

```text
dp = 4
last[a] = 1
```

Calculate:

```text
newDp = 2 * 4 - 1
      = 7
```

So:

```text
dp = 7
```

Remove the empty subsequence:

```text
answer = 7 - 1
       = 6
```

Therefore:

```text
Output = 6
```

---

## Complexity

Let `n` be the length of the string.

### Time Complexity

```text
O(n)
```

Each character is processed once.

### Space Complexity

```text
O(26)
```

We only store information for the 26 lowercase English letters.

Therefore, the auxiliary space is effectively:

```text
O(1)
```

---

## Key Insight

The important idea is:

> Every new character can double the number of subsequences, but repeated characters create duplicate subsequences.

So we use:

```text
newDp = 2 * dp - last[character]
```

This allows us to count **distinct** subsequences in linear time.

---

## Solutions

* [Solution.java](./Solution.java)
* [solution.py](./solution.py)

---

## Tags

```text
Dynamic Programming
String
Distinct Subsequences
```
