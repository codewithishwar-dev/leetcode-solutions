import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        // If array has only one element
        if (n == 1) {
            return 0;
        }

        // Store value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // BFS Queue
        Queue<Integer> queue = new LinkedList<>();

        // Visited array
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int current = queue.poll();

                // Reached last index
                if (current == n - 1) {
                    return steps;
                }

                // Jump to current - 1
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }

                // Jump to current + 1
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }

                // Jump to all indices having same value
                if (map.containsKey(arr[current])) {

                    for (int next : map.get(arr[current])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    // Optimization to avoid revisiting same value group
                    map.remove(arr[current]);
                }
            }

            steps++;
        }

        return -1;
    }
}
