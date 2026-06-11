import java.util.*;

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

        int maxDepth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;

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

        return (int) modPow(2, maxDepth - 1);
    }

    private long modPow(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent >>= 1;
        }

        return result;
    }
}
