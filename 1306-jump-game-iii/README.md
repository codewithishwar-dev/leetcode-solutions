# 1306. Jump Game III

## Problem Statement

Given an array of non-negative integers `arr`, you are initially positioned at `start` index of the array.

When you are at index `i`, you can jump to:

* `i + arr[i]`
* `i - arr[i]`

Return `true` if you can reach any index with value `0`, otherwise return `false`.

---

# Example

## Example 1

```text
Input:
arr = [4,2,3,0,3,1,2]
start = 5

Output:
true
```

Explanation:

One possible path:

```text
5 -> 4 -> 1 -> 3
```

At index `3`, value is `0`.

---

# Intuition

This problem can be visualized as a **graph traversal** problem.

Each index acts like a node.

From index `i`, we can move to:

```text
i + arr[i]
i - arr[i]
```

Since we can revisit indexes and create cycles, we must track visited indexes.

We can solve this using:

* DFS (Depth First Search)
* BFS (Breadth First Search)

---

# DFS Approach

## Algorithm

1. Start DFS from `start`
2. If index goes out of bounds → return `false`
3. If index already visited → return `false`
4. If current value is `0` → return `true`
5. Mark current index as visited
6. Explore forward and backward jumps

---

# Java Solution (DFS)

```java
class Solution {

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {

        // Out of bounds
        if (index < 0 || index >= arr.length) {
            return false;
        }

        // Already visited
        if (visited[index]) {
            return false;
        }

        // Found zero
        if (arr[index] == 0) {
            return true;
        }

        // Mark visited
        visited[index] = true;

        int forward = index + arr[index];
        int backward = index - arr[index];

        return dfs(arr, forward, visited)
                || dfs(arr, backward, visited);
    }
}
```

---

# Dry Run

```text
arr = [4,2,3,0,3,1,2]
start = 5
```

### Step 1

```text
Index = 5
arr[5] = 1
```

Possible jumps:

```text
5 + 1 = 6
5 - 1 = 4
```

---

### Step 2

Move to index `4`

```text
arr[4] = 3
```

Possible jumps:

```text
4 + 3 = 7 (invalid)
4 - 3 = 1
```

---

### Step 3

Move to index `1`

```text
arr[1] = 2
```

Possible jumps:

```text
1 + 2 = 3
1 - 2 = -1 (invalid)
```

---

### Step 4

Move to index `3`

```text
arr[3] = 0
```

Return `true`.

---

# Time Complexity

```text
O(n)
```

Each index is visited at most once.

---

# Space Complexity

```text
O(n)
```

Used for:

* visited array
* recursion stack

---

# Key Interview Insight

This is a classic **Graph Traversal** problem hidden inside an array problem.

Important concepts:

* DFS/BFS
* Cycle detection
* Visited array
* Graph modeling

---

# Related Problems

* Jump Game
* Jump Game II
* Number of Islands
* Clone Graph
* Word Ladder
