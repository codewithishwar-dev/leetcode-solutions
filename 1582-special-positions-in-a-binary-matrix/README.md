# 1582. Special Positions in a Binary Matrix

**Difficulty:** Easy  
**Topic:** Matrix, Array

## Problem

Given an `m x n` binary matrix `mat`, return the number of special positions.

A position `(i, j)` is special if:

- `mat[i][j] == 1`
- All other elements in row `i` are `0`
- All other elements in column `j` are `0`

## Example

Input:

    mat = [[1,0,0],
           [0,0,1],
           [1,0,0]]

Output:

    1

## Approach

A position containing `1` is special when:

1. Its row contains exactly one `1`.
2. Its column contains exactly one `1`.

First, count the number of `1`s in every row and column.

Then traverse the matrix again. For every `1`, check:

    row_count[i] == 1 && col_count[j] == 1

If both conditions are true, it is a special position.

## Complexity

- Time Complexity: `O(m * n)`
- Space Complexity: `O(m + n)`
