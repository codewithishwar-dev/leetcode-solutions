# 3558. Number of Ways to Assign Edge Weights I

## Problem Link

https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/

## Difficulty

Medium

## Tags

Tree, BFS, Graph, Math, Modular Arithmetic

---

## Problem Summary

Given a rooted tree with root node `1`, every edge can be assigned a weight of either `1` or `2`.

Choose any node at the maximum depth and consider only the path from node `1` to that node.

Return the number of ways to assign edge weights so that the total cost of the path is odd.

Since the answer can be large, return it modulo `10^9 + 7`.

---

## Intuition

The path from the root to a deepest node contains `L` edges, where `L` is the maximum depth of the tree.

Each edge can be assigned:

* Weight `1` (odd)
* Weight `2` (even)

The total path cost is odd if and only if the number of edges assigned weight `1` is odd.

For a path of length `L`:

* Total assignments = `2^L`
* Exactly half of the assignments produce an odd sum.
* Exactly half produce an even sum.

Therefore:

Answer = `2^(L - 1)`

So the only thing we need to compute is the maximum depth of the tree.

---

## Approach

1. Build the adjacency list.
2. Perform BFS from node `1`.
3. Determine the maximum depth of the tree.
4. Let the maximum depth be `L`.
5. Return:

   `2^(L - 1) mod (10^9 + 7)`

using fast modular exponentiation.

---

## Correctness Proof

Let the path length be `L`.

There are exactly `2^L` possible assignments because each edge independently chooses between `1` and `2`.

Consider any assignment and flip the weight of the first edge:

* `1 → 2`
* `2 → 1`

This changes the parity of the total path cost.

Thus every odd-sum assignment is paired with exactly one even-sum assignment.

Therefore:

* Odd assignments = Even assignments
* Total assignments = `2^L`

Hence:

`Odd assignments = 2^L / 2 = 2^(L - 1)`

Therefore the algorithm returns the correct answer.

---

## Complexity Analysis

### Time Complexity

* Building graph: `O(n)`
* BFS traversal: `O(n)`
* Fast exponentiation: `O(log n)`

Total: `O(n)`

### Space Complexity

* Adjacency list: `O(n)`
* Queue and visited array: `O(n)`

Total: `O(n)`

---

## Java Solution

```java
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int next : graph[node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}
```

---

## 👨‍💻 Author

### CodeWithIshwar | Ishwar Chandra Tiwari

Backend Engineer | Java | Spring Boot | Drupal | System Design | DSA

* GitHub: https://github.com/codewithishwar
* LinkedIn: https://www.linkedin.com/in/ishwar-chandra-tiwari-51610b26
* YouTube: https://www.youtube.com/@codewithishwar
* X: https://x.com/codewithishwar
* Website: https://codewithishwar.com

---

⭐ If this solution helped you, consider starring the repository and following **CodeWithIshwar** for more content on:

* Data Structures & Algorithms
* LeetCode Solutions
* Low-Level Design (LLD)
* High-Level Design (HLD)
* System Design
* Java & Spring Boot
* Backend Engineering
* Software Architecture

### Keep Learning. Keep Building. 🚀

**CodeWithIshwar** | **Ishwar Chandra Tiwari**

