# 2812. Find the Safest Path in a Grid

**Difficulty:** Medium

## Problem

You are given an `n x n` grid where:

- `1` represents a thief.
- `0` represents an empty cell.

You start from `(0,0)` and need to reach `(n-1,n-1)`.

The **safeness factor** of a path is the minimum Manhattan distance between any cell on the path and the nearest thief.

Return the maximum possible safeness factor among all valid paths.

---

## Example

### Input

```text
grid =
[
 [0,0,1],
 [0,0,0],
 [0,0,0]
]
```

### Output

```text
2
```

---

# Approach

The solution consists of two major steps.

## Step 1 – Multi-Source BFS

Instead of running BFS from every thief individually, insert all thief cells into the queue initially.

Perform BFS once to compute the minimum distance from every cell to its nearest thief.

Example:

Original Grid

```text
0 0 1
0 0 0
0 0 0
```

Distance Matrix

```text
2 1 0
3 2 1
4 3 2
```

This preprocessing runs in **O(n²)** time.

---

## Step 2 – Binary Search on the Answer

Suppose we want to know whether a path exists whose safeness factor is at least **k**.

Only cells satisfying

```text
distance >= k
```

are allowed.

Run a BFS from `(0,0)`.

- If the destination is reachable, then `k` is feasible.
- Otherwise, it is not.

Since the answer is monotonic, binary search can be applied.

---

# Algorithm

1. Run Multi-Source BFS from every thief.
2. Compute minimum distance of every cell to the nearest thief.
3. Binary search the safeness factor.
4. For every candidate value:
   - Run BFS using only cells with distance ≥ candidate.
5. Return the largest feasible value.

---

# Complexity Analysis

### Multi-Source BFS

```text
Time : O(n²)
Space: O(n²)
```

### Binary Search

Each BFS takes

```text
O(n²)
```

Binary search performs at most

```text
log(maxDistance)
```

iterations.

### Overall

```text
Time : O(n² log n)
Space: O(n²)
```

---

# Key Concepts

- Multi-Source BFS
- Binary Search on Answer
- Graph Traversal
- BFS
- Manhattan Distance
