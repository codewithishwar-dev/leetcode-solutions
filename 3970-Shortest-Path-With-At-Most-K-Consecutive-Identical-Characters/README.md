
# 3970. Shortest Path With at Most K Consecutive Identical Characters

**Difficulty:** Medium

**Topics:** Graph, Dijkstra's Algorithm, Priority Queue

**Pattern:** Modified Dijkstra | State Expansion

## Problem

Find the minimum total edge weight from node 0 to
node n - 1 such that the concatenated node labels
contain at most k consecutive identical characters.

Return -1 if no valid path exists.

## Approach: Dijkstra + State Expansion

A normal Dijkstra algorithm tracks the shortest
distance to each node.

However, this problem requires tracking an additional
state: the number of consecutive identical characters.

We maintain:

`dist[node][count]`

Where:
- `node` represents the current node.
- `count` represents consecutive occurrences of the
  current character.

### State Transition

1. If the next node has the same character, increment count.
2. Otherwise, reset count to 1.
3. If count exceeds k, skip that transition.
4. Update the distance if a shorter path is found.

### Complexity Analysis

Let V be the number of vertices, E the number of
edges, and K the maximum consecutive count.

- **Time:** O((V*K + E*K) * log(V*K))
- **Space:** O(V*K + E)

## Key Learnings

- Modified Dijkstra's Algorithm
- State Expansion
- Priority Queue
- Shortest Path in Directed Weighted Graphs

## Related Concepts

- Dijkstra's Algorithm
- Bellman-Ford Algorithm
- BFS vs Dijkstra
- Multi-State Shortest Path Problems
