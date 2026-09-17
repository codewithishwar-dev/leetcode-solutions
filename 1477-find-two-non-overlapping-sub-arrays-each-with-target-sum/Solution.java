class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];
        int INF = Integer.MAX_VALUE;

        java.util.Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer,
                        length + best[left - 1]
                    );
                }

                best[right] = Math.min(
                    right > 0 ? best[right - 1] : INF,
                    length
                );
            } else {
                best[right] = right > 0
                    ? best[right - 1]
                    : INF;
            }
        }

        return answer == INF ? -1 : answer;
    }
}
