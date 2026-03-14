# 67. Add Binary

## Problem

Given two binary strings `a` and `b`, return their sum as a binary string.

---

## Approach

We simulate binary addition similar to decimal addition.

Steps:

- Traverse both strings from right to left
- Add digits along with carry
- Store the result digit
- Update the carry

Use a `StringBuilder` to build the result and reverse it at the end.

---

## Complexity

Time Complexity: O(max(n, m))

Space Complexity: O(max(n, m))

---

CodeWithIshwar  
Created by Ishwar Chandra Tiwari
