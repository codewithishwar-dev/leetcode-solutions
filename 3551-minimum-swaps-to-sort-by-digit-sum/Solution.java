
import java.util.Arrays;

class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store each number and its digit sum
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitSum(nums[i]);
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Map each number to its target position
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = arr[i][0];
        }

        // Map each original number to its current index
        java.util.Map<Integer, Integer> indexMap =
                new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        // Build the permutation of target positions
        int[] permutation = new int[n];

        for (int i = 0; i < n; i++) {
            permutation[i] = indexMap.get(target[i]);
        }

        // Count cycles to find minimum swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || permutation[i] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = permutation[j];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
