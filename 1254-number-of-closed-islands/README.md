# 1254. Number of Closed Islands

**Difficulty:** Medium  
**Topics:** Array, Depth-First Search (DFS), Breadth-First Search (BFS), Matrix, Union Find  
**Platform:** [LeetCode](https://leetcode.com/problems/number-of-closed-islands/)

## Problem Statement

Given a 2D grid consisting of `0s` (land) and `1s` (water), return the number of closed islands.

An island is a group of connected land cells (`0s`) connected in four directions: up, down, left, and right.

A closed island is completely surrounded by water and does not touch the grid boundary.

## Approach: Boundary DFS

1. Traverse all boundary cells and perform DFS on land cells (`0`) to mark boundary-connected land as water (`1`).
2. Traverse the remaining inner cells.
3. Whenever an unvisited land cell is found, increment the island count and perform DFS to mark the entire island as visited.
4. Return the total count.

### Java Solution

See [`Solution.java`](Solution.java).

## Complexity Analysis

- **Time Complexity:** `O(m × n)` — each cell is processed at most a constant number of times.
- **Space Complexity:** `O(m × n)` — in the worst case, recursive DFS can use stack space proportional to the number of cells.

Where `m` is the number of rows and `n` is the number of columns.

## Key Takeaway

**Eliminate boundary-connected land first, then count the remaining connected components.**

This technique is useful for grid traversal, connected components, and DFS-based interview problems.

## Related Concepts

- Number of Islands
- Flood Fill
- Surrounded Regions
- Graph Traversal (DFS/BFS)
