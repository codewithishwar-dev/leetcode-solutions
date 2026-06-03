import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        // Land -> Water
        ans = Math.min(ans,
                solveDirection(
                        landStartTime,
                        landDuration,
                        waterStartTime,
                        waterDuration));

        // Water -> Land
        ans = Math.min(ans,
                solveDirection(
                        waterStartTime,
                        waterDuration,
                        landStartTime,
                        landDuration));

        return (int) ans;
    }

    private long solveDirection(int[] firstStart, int[] firstDuration,
                                int[] secondStart, int[] secondDuration) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDuration = new long[m];
        long[] suffixMinStartPlusDuration = new long[m + 1];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDuration[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                    Math.min(prefixMinDuration[i - 1], rides[i][1]);
        }

        suffixMinStartPlusDuration[m] = Long.MAX_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            long val = (long) rides[i][0] + rides[i][1];
            suffixMinStartPlusDuration[i] =
                    Math.min(val, suffixMinStartPlusDuration[i + 1]);
        }

        long answer = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst =
                    (long) firstStart[i] + firstDuration[i];

            int idx = upperBound(starts, (int) finishFirst);

            long best = Long.MAX_VALUE;

            // second ride already open
            if (idx > 0) {
                best = Math.min(
                        best,
                        finishFirst + prefixMinDuration[idx - 1]
                );
            }

            // second ride opens later
            if (idx < m) {
                best = Math.min(
                        best,
                        suffixMinStartPlusDuration[idx]
                );
            }

            answer = Math.min(answer, best);
        }

        return answer;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
