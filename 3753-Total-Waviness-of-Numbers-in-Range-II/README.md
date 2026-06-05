# 3753. Total Waviness of Numbers in Range II

**Difficulty:** Hard

## Problem

You are given two integers `num1` and `num2` representing an inclusive range `[num1, num2]`.

The waviness of a number is defined as the total count of its peaks and valleys:

- A digit is a **peak** if it is strictly greater than both of its immediate neighbors.
- A digit is a **valley** if it is strictly less than both of its immediate neighbors.
- The first and last digits cannot be peaks or valleys.
- Any number with fewer than 3 digits has a waviness of `0`.

Return the total sum of waviness for all numbers in the range `[num1, num2]`.

---

## Examples

### Example 1

```text
Input: num1 = 120, num2 = 130
Output: 3
```

### Example 2

```text
Input: num1 = 198, num2 = 202
Output: 3
```

### Example 3

```text
Input: num1 = 4848, num2 = 4848
Output: 2
```

---

## Approach

Since `num2` can be as large as `10^15`, iterating through every number is impossible.

The solution uses **Digit DP**.

### Key Idea

While constructing a number digit by digit:

- Maintain the last two digits seen.
- When a new digit is added, determine whether the previous digit becomes:
  - a Peak
  - a Valley
- Accumulate waviness contributions during DP transitions.

To compute the answer for a range:

```text
Answer = F(num2) - F(num1 - 1)
```

where `F(x)` returns the total waviness of all numbers in `[1, x]`.

### DP State

```text
(position,
 tight,
 lengthState,
 secondLastDigit,
 lastDigit)
```

Where:

- `position` → current digit index
- `tight` → whether current prefix matches limit
- `lengthState`
  - 0 = no non-leading digit yet
  - 1 = exactly one digit formed
  - 2 = at least two digits formed
- `secondLastDigit`
- `lastDigit`

Each state stores:

```text
(countOfNumbers, totalWaviness)
```

---

## Complexity Analysis

### Time Complexity

```text
O(16 × 2 × 3 × 11 × 11 × 10)
```

Approximately:

```text
O(10^5)
```

### Space Complexity

```text
O(16 × 2 × 3 × 11 × 11)
```

Approximately:

```text
O(10^4)
```

---

## Tags

- Digit DP
- Dynamic Programming
- Hard
- Number Theory
