# 3700. Number of ZigZag Arrays II

## Problem Link
https://leetcode.com/problems/number-of-zigzag-arrays-ii/

## Approach

Let `m = r - l + 1`.

A ZigZag array must satisfy:

1. Adjacent elements are different.
2. No three consecutive elements are strictly increasing.
3. No three consecutive elements are strictly decreasing.

This implies the comparison signs between adjacent elements must alternate:

+ - + - ...
or
- + - + ...

### DP State

Let:

- `U(v)` = arrays ending at value `v` where the last move was up.
- `D(v)` = arrays ending at value `v` where the last move was down.

Using symmetry, the transitions can be represented as matrix multiplication.

### Matrix Exponentiation

Construct an `m × m` matrix `A`:

A[v][w] = 1 if v + w > m + 1
A[v][w] = 0 otherwise

Then:

F(n) = A^(n-2) × F(2)

Since `n` can be as large as `10^9`, fast matrix exponentiation is used.

## Complexity

- Time: O(m³ log n)
- Space: O(m²)

where `m = r - l + 1 ≤ 75`.
