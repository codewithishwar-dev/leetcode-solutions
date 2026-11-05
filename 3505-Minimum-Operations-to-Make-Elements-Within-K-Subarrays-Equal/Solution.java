
import java.util.*;

class Solution {

    class FenwickTree {
        long[] tree;
        int n;

        FenwickTree(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void update(int index, long value) {
            while (index <= n) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long query(int index) {
            long sum = 0;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }

        // Find the smallest index whose prefix sum >= target
        int kth(long target) {
            int index = 0;

            for (int bit = Integer.highestOneBit(n);
                 bit > 0;
                 bit >>= 1) {

                int next = index + bit;

                if (next <= n && tree[next] < target) {
                    index = next;
                    target -= tree[next];
                }
            }

            return index + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] unique = Arrays.stream(sorted)
                .distinct()
                .toArray();

        int m = unique.length;

        FenwickTree countBIT = new FenwickTree(m);
        FenwickTree sumBIT = new FenwickTree(m);

        int[] compressed = new int[n];

        for (int i = 0; i < n; i++) {
            compressed[i] =
                    Arrays.binarySearch(unique, nums[i]) + 1;
        }

        long[] windowCost = new long[n - x + 1];

        // Calculate cost of every window of size x
        for (int i = 0; i < n; i++) {

            int idx = compressed[i];

            countBIT.update(idx, 1);
            sumBIT.update(idx, nums[i]);

            // Remove element outside the window
            if (i >= x) {
                int removeIdx = compressed[i - x];

                countBIT.update(removeIdx, -1);
                sumBIT.update(removeIdx, -nums[i - x]);
            }

            if (i >= x - 1) {

                // Median position (lower median)
                int medianIndex = countBIT.kth((x + 1L) / 2);

                long median = unique[medianIndex - 1];

                long leftCount =
                        countBIT.query(medianIndex);

                long leftSum =
                        sumBIT.query(medianIndex);

                long totalSum =
                        sumBIT.query(m);

                long totalCount = x;

                long rightCount = totalCount - leftCount;
                long rightSum = totalSum - leftSum;

                long leftCost =
                        median * leftCount - leftSum;

                long rightCost =
                        rightSum - median * rightCount;

                windowCost[i - x + 1] =
                        leftCost + rightCost;
            }
        }

        // DP: Select k non-overlapping windows
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        Arrays.fill(prev, 0);

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                curr[i] = curr[i - 1];

                // Option 2: Select a window ending at i - 1
                if (i >= x && prev[i - x] != INF) {

                    long cost =
                            prev[i - x] + windowCost[i - x];

                    curr[i] = Math.min(curr[i], cost);
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
