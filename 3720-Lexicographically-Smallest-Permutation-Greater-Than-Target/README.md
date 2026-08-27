# 3720. Lexicographically Smallest Permutation Greater Than Target

**LeetCode:** 3720
**Difficulty:** Medium
**Topics:** String, Greedy, Counting, Permutation, Backtracking

---

## Problem

You are given two strings `s` and `target`, both of length `n`, consisting of lowercase English letters.

Return the **lexicographically smallest permutation of `s` that is strictly greater than `target`**.

If no such permutation exists, return an empty string.

A string `a` is lexicographically greater than a string `b` if, at the first position where they differ, `a` contains a character that comes later in the alphabet.

### Example 1

```text
Input:
s = "abc"
target = "bba"

Output:
"bca"
```

### Example 2

```text
Input:
s = "leet"
target = "code"

Output:
"eelt"
```

### Example 3

```text
Input:
s = "baba"
target = "bbaa"

Output:
""
```

---

## Approach

The important observation is that we do **not** need to generate all permutations.

There can be up to `300!` permutations, so brute force is impossible.

Instead, maintain a frequency array of the 26 lowercase English letters.

### Step 1 — Match `target`

Start from the left and try to use exactly the same character as `target[i]`.

For every matched character:

```text
freq[target[i]]--
```

This keeps the constructed prefix equal to `target`.

---

### Step 2 — When matching fails

Suppose we cannot use `target[i]`.

There are two possibilities:

1. Use a character greater than `target[i]`.
2. If that is impossible, backtrack to an earlier position.

If a greater character is available, choose the **smallest possible greater character**.

Why?

Because we want the final answer to be lexicographically as small as possible.

---

### Step 3 — Sort the remaining characters

Once the constructed prefix becomes greater than `target`, the remaining characters should be placed in ascending order.

For example:

```text
prefix = "bc"
remaining = "a"

answer = "bca"
```

This gives the smallest possible suffix.

---

### Step 4 — Backtracking

If we cannot make the current position greater, move backwards.

For example:

```text
target = "bbaa"
```

We may have matched:

```text
b b a
```

but cannot make the next position greater.

So we return one position at a time and ask:

> Can this position be replaced with a slightly larger character?

The **rightmost position** that can be increased gives the smallest possible answer.

---

## Why Greedy Works

Lexicographical comparison is decided by the first position where two strings differ.

Therefore, to get the smallest string greater than `target`:

1. Keep the prefix equal to `target` for as long as possible.
2. At the first position where we decide to become greater, choose the smallest character greater than the target character.
3. Arrange everything after that position in sorted order.

This guarantees the lexicographically smallest valid permutation.

---

## Complexity

There are only 26 possible lowercase letters.

For every position, we may scan at most 26 characters.

### Time Complexity

```text
O(26 × n)
```

Since 26 is constant:

```text
O(n)
```

### Space Complexity

```text
O(n + 26)
```

The frequency array uses constant space, while the result uses `O(n)` space.

---

## Key Pattern

This problem is a variation of:

> **Next Lexicographical Permutation with Duplicate Characters**

The general pattern is:

```text
Match target
     ↓
Need to become greater
     ↓
Choose smallest available greater character
     ↓
Sort remaining characters
     ↓
If impossible → backtrack
```

---

## Important Edge Cases

### 1. `s` has no permutation greater than `target`

```text
s = "baba"
target = "bbaa"

answer = ""
```

---

### 2. `target` itself is a permutation of `s`

In this case, we cannot return `target` because the answer must be **strictly greater**.

We therefore find the next lexicographical permutation.

---

### 3. Duplicate characters

Example:

```text
s = "leet"
```

The frequency array naturally handles duplicates:

```text
e → 2
l → 1
t → 1
```

No duplicate permutations need to be generated.

---

## Files

```text
├── README.md
├── Solution.java
└── Solution.py
```

---

## Tags

`Greedy` `String` `Permutation` `Counting` `Backtracking` `Lexicographical Order`

---

## LeetCode

Problem: **3720. Lexicographically Smallest Permutation Greater Than Target**
