# 3699. Number of ZigZag Arrays I

## Problem
Given three integers `n`, `l`, and `r`, count the number of ZigZag arrays of length `n`.

A ZigZag array satisfies:
- Each element lies in `[l, r]`
- No two adjacent elements are equal
- No three consecutive elements are strictly increasing
- No three consecutive elements are strictly decreasing

Return the count modulo `10^9 + 7`.

## Approach

Let `m = r - l + 1`.

Track two states:

- `up[v]`: Arrays ending at value `v` where the last comparison is increasing.
- `down[v]`: Arrays ending at value `v` where the last comparison is decreasing.

For every new element:

- `newUp[x] = Σ down[y]` for all `y < x`
- `newDown[x] = Σ up[y]` for all `y > x`

Use prefix sums to compute transitions efficiently.

## Complexity

- Time: `O(n × m)`
- Space: `O(m)`

where `m = r - l + 1`.
