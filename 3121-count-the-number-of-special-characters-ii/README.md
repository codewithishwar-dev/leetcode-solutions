# 3121. Count the Number of Special Characters II

**Difficulty:** Medium

## Problem Statement

A letter `c` is called special if:

1. It appears in both lowercase and uppercase forms.
2. Every lowercase occurrence of `c` appears before the first uppercase occurrence of `c`.

Return the number of special letters in the given string.

## Approach

- Store the last occurrence index of each lowercase letter.
- Store the first occurrence index of each uppercase letter.
- For each letter from `a` to `z`:
  - Check whether both lowercase and uppercase versions exist.
  - Verify that the last lowercase occurrence appears before the first uppercase occurrence.

If both conditions are satisfied, the letter is special.

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Example

### Input
```text
word = "aaAbcBC"
```

### Output
```text
3
```

### Explanation
Special letters are:
- a
- b
- c
