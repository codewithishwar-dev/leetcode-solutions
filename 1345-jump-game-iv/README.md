# 1345. Jump Game IV

## Problem

Given an array of integers `arr`, you are initially positioned at the first index of the array.

In one step you can jump from index `i` to:

* `i + 1`
* `i - 1`
* Any index `j` where `arr[i] == arr[j]` and `i != j`

Return the minimum number of steps required to reach the last index.

---

## Approach

This problem is solved efficiently using **Breadth First Search (BFS)**.

### Key Idea

Treat every index as a graph node.

From each index, we can move to:

* left neighbor
* right neighbor
* all indices having the same value

Since BFS explores level by level, the first time we reach the last index gives the minimum number of jumps.

---

## Optimization

A hashmap stores:

```java
value -> list of indices
```

After processing all indices of a value once, we remove that value from the map:

```java
map.remove(arr[current]);
```

This prevents revisiting the same group repeatedly and avoids TLE.

---

## Time Complexity

```text
O(n)
```

## Space Complexity

```text
O(n)
```

---

## Java Solution

```java
import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int current = queue.poll();

                if (current == n - 1) {
                    return steps;
                }

                // left jump
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }

                // right jump
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }

                // same value jumps
                if (map.containsKey(arr[current])) {

                    for (int next : map.get(arr[current])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    map.remove(arr[current]);
                }
            }

            steps++;
        }

        return -1;
    }
}
```

---

## Learning

* BFS for shortest path problems
* Graph traversal in arrays
* HashMap optimization
* Avoiding repeated processing
* Queue-based level traversal
