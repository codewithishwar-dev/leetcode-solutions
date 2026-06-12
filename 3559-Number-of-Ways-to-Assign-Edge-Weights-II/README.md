# 3559. Number of Ways to Assign Edge Weights II

## Problem Link

https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/

## Difficulty

Hard

## Approach

For a path containing `L` edges:

* Each edge can be assigned either weight `1` or `2`.
* Total assignments = `2^L`.

The path cost is odd if and only if the number of edges assigned weight `1` is odd.

For any `L > 0`:

* Exactly half of all assignments produce an odd sum.
* Therefore, the number of valid assignments is:

`2^(L-1)`

For `L = 0`:

* The path contains no edges.
* Cost = 0 (even).
* Answer = 0.

Thus, the problem reduces to finding the number of edges on the path between two nodes.

### Path Length

Let:

* `depth[u]` = depth of node `u`
* `depth[v]` = depth of node `v`
* `lca(u, v)` = Lowest Common Ancestor

Then:

L = depth[u] + depth[v] - 2 × depth[lca(u, v)]

If:

* `L == 0` → answer = `0`
* Otherwise → answer = `2^(L-1) mod (10^9 + 7)`

### Data Structures Used

* Adjacency List
* Binary Lifting
* Depth Array
* Precomputed Powers of Two

### Algorithm

1. Build the tree.
2. Run DFS from root node `1`.
3. Compute depths and immediate parents.
4. Build Binary Lifting table.
5. Precompute powers of 2 modulo `1e9+7`.
6. For each query:

   * Find LCA.
   * Compute path length.
   * Return `0` if path length is `0`.
   * Otherwise return `2^(pathLength-1)`.

### Complexity Analysis

#### Time Complexity

* DFS: `O(n)`
* Binary Lifting Table: `O(n log n)`
* Each Query: `O(log n)`

Total:

`O((n + q) log n)`

#### Space Complexity

`O(n log n)`

---

## Key Insight

For a path with `L` edges, exactly half of the `2^L` possible assignments produce an odd path cost.

Therefore:

* `0` when `L = 0`
* `2^(L-1)` when `L > 0`

This transforms the problem into a simple LCA + distance query problem.

---

### Author

**Code With Ishwar**

**Ishwar Chandra Tiwari**
