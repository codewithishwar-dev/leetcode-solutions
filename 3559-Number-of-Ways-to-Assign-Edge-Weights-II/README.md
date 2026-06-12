# 3559. Number of Ways to Assign Edge Weights II

## Difficulty

Hard

## Tags

Tree, LCA, Binary Lifting, DFS, Graph, Math, Combinatorics

---

## Problem Summary

Given a rooted tree, each edge can be assigned a weight of either **1** or **2**.

For every query `(u, v)`, consider only the edges on the path between `u` and `v`.

Return the number of ways to assign weights to the edges on that path such that the total path cost is **odd**.

Since the answer can be very large, return it modulo `10^9 + 7`.

---

## Key Observation

For a path containing `L` edges:

* Each edge has 2 possible assignments (`1` or `2`)
* Total assignments = `2^L`

Since:

* Weight `1` is odd
* Weight `2` is even

The total path cost is odd if and only if the number of edges assigned weight `1` is odd.

For any non-empty path:

* Half of all assignments produce an odd sum.
* Half produce an even sum.

Therefore:

```
Answer = 2^(L - 1)
```

where `L` is the number of edges on the path.

Special case:

```
L = 0
Answer = 0
```

because a node-to-itself path has cost `0` (even).

---

## Mathematical Proof

Let a path contain `L` edges.

Each edge contributes either:

```
1 (odd)
or
2 (even)
```

Only parity matters.

Represent each edge as:

```
1 -> odd contribution
0 -> even contribution
```

The path cost is odd when the parity sum is odd.

Among all binary strings of length `L`:

```
Total strings = 2^L
```

Exactly half have odd parity and half have even parity.

Hence:

```
Odd-cost assignments
= 2^L / 2
= 2^(L-1)
```

for all `L > 0`.

---

## Reducing the Problem

The counting part is now solved.

The problem becomes:

> Find the number of edges between nodes `u` and `v`.

Let:

```
L = distance(u, v)
```

Then:

```
Answer = 0                  if L = 0
Answer = 2^(L-1) mod MOD    otherwise
```

---

## Finding Path Length Efficiently

Constraints:

* n ≤ 100000
* queries ≤ 100000

A DFS per query would be too slow.

We need:

```
O(log n)
```

per query.

This suggests using:

### Lowest Common Ancestor (LCA)

For nodes `u` and `v`:

```
w = LCA(u, v)
```

The path length is:

```
distance(u, v)
=
depth[u]
+
depth[v]
-
2 * depth[w]
```

---

## Binary Lifting

To answer LCA queries efficiently:

```
up[node][j]
```

stores the `2^j`-th ancestor of a node.

Examples:

```
up[node][0] = parent
up[node][1] = 2nd ancestor
up[node][2] = 4th ancestor
up[node][3] = 8th ancestor
```

Using Binary Lifting:

* Preprocessing: `O(n log n)`
* LCA Query: `O(log n)`

---

## Algorithm

1. Build the tree using an adjacency list.
2. Run DFS from root node `1`.
3. Compute:

   * depth of every node
   * immediate parent of every node
4. Build the Binary Lifting table.
5. Precompute powers of two modulo `1e9 + 7`.
6. For each query:

   * Find `LCA(u, v)`
   * Compute path length
   * If length is `0`, return `0`
   * Otherwise return `2^(length-1)`

---

## Correctness Proof

For every query:

Let:

```
L = number of edges on the path
```

From the parity argument:

```
Number of valid assignments
=
2^(L-1)
```

for `L > 0`.

Using LCA:

```
L
=
depth[u]
+
depth[v]
-
2 * depth[LCA(u,v)]
```

which exactly equals the number of edges on the path.

Therefore the algorithm computes the correct path length and applies the proven counting formula.

Hence the algorithm always returns the correct answer.

---

## Complexity Analysis

### Preprocessing

Building Tree:

```
O(n)
```

DFS:

```
O(n)
```

Binary Lifting Table:

```
O(n log n)
```

### Per Query

LCA:

```
O(log n)
```

Distance Calculation:

```
O(1)
```

### Overall

```
Time Complexity:
O((n + q) log n)
```

```
Space Complexity:
O(n log n)
```

---

## Java Solution

See `Solution.java`.

---

## Author

### Code With Ishwar

**Ishwar Chandra Tiwari**

Backend Engineer | Java | System Design | DSA

⭐ If you found this solution helpful, consider starring the repository.
