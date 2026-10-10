# 1541. Minimum Insertions to Balance a Parentheses String

- **LeetCode:** [1541. Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)
- **Difficulty:** Medium
- **Topics:** String, Greedy
- **Language:** Java

## Problem Statement

Given a string `s` containing only `(` and `)`, return the minimum number of insertions required to make it balanced.

Every opening parenthesis `(` must have two consecutive closing parentheses `))` as its matching pair.

## Approach: Greedy

Maintain two variables:

- `open`: Number of unmatched opening parentheses.
- `insertions`: Number of characters inserted to balance the string.

For each character:

1. If it is `(`, increment `open`.
2. If it is `)`, check whether the next character is also `)`.
3. If the next character is not `)`, insert one closing parenthesis.
4. Match the closing pair with an available opening parenthesis.
5. If no opening parenthesis exists, insert one.
6. At the end, each unmatched opening parenthesis requires two closing parentheses.

## Java Solution

See `Solution.java` in this directory.

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

Here, `n` is the length of the input string.

## Example

**Input**
```text
s = "(()))"
```

**Output**
```text
1
```

**Explanation:** One closing parenthesis must be inserted to balance the string.

## Key Takeaway

Greedy counting helps solve parentheses-balancing problems efficiently without using a stack.

**CodeWithIshwar | Ishwar Chandra Tiwari**
