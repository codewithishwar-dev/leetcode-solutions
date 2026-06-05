class Solution {

    private char[] digits;
    private Node[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) {
            return 0;
        }

        digits = String.valueOf(n).toCharArray();
        memo = new Node[digits.length][2][3][11][11];

        return dfs(0, 1, 0, 10, 10).sum;
    }

    private Node dfs(int pos,
                     int tight,
                     int lenState,
                     int secondLast,
                     int last) {

        if (pos == digits.length) {
            return new Node(1, 0);
        }

        if (memo[pos][tight][lenState][secondLast][last] != null) {
            return memo[pos][tight][lenState][secondLast][last];
        }

        int limit = (tight == 1) ? digits[pos] - '0' : 9;

        long count = 0;
        long sum = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (lenState == 0) {

                if (d == 0) {
                    Node child = dfs(pos + 1, nextTight, 0, 10, 10);

                    count += child.count;
                    sum += child.sum;
                } else {
                    Node child = dfs(pos + 1, nextTight, 1, 10, d);

                    count += child.count;
                    sum += child.sum;
                }

            } else if (lenState == 1) {

                Node child = dfs(pos + 1, nextTight, 2, last, d);

                count += child.count;
                sum += child.sum;

            } else {

                long contribution = isPeakOrValley(secondLast, last, d) ? 1 : 0;

                Node child = dfs(pos + 1, nextTight, 2, last, d);

                count += child.count;
                sum += child.sum + contribution * child.count;
            }
        }

        return memo[pos][tight][lenState][secondLast][last]
                = new Node(count, sum);
    }

    private boolean isPeakOrValley(int left, int middle, int right) {
        return (middle > left && middle > right)
                || (middle < left && middle < right);
    }

    private static class Node {
        long count;
        long sum;

        Node(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }
}
