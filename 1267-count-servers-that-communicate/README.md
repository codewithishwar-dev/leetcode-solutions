
# 1267. Count Servers that Communicate

**Difficulty:** Medium

**Topics:** Array, Matrix

**Platform:** LeetCode

## Problem Statement

Given an m x n binary matrix `grid`, where 1
represents a server and 0 represents an empty cell,
return the number of servers that can communicate
with at least one other server.

Two servers can communicate if they share the
same row or column.

## Approach: Row and Column Counting

1. Create two arrays to store server counts
   for each row and column.
2. Traverse the matrix and calculate both counts.
3. Traverse the matrix again.
4. Count a server if its row or column contains
   more than one server.

## Complexity Analysis

- Time Complexity: O(m * n)
- Space Complexity: O(m + n)

## Key Learning

Use frequency counting to optimize matrix traversal.
Instead of checking every server against every other
server, precompute row and column counts.

## Example

Input:
grid = [[1,0],[1,1]]

Output:
3
