import java.util.*;

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Total path length must be even.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Maximum possible balance is m + n - 1.
        int maxBalance = m + n;

        // dp[j] contains all possible balances for the current cell.
        BitSet[] dp = new BitSet[n];

        for (int j = 0; j < n; j++) {
            dp[j] = new BitSet(maxBalance);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                BitSet current = new BitSet(maxBalance);

                if (i == 0 && j == 0) {
                    // The path must start with '('.
                    if (grid[i][j] == '(') {
                        current.set(1);
                    }
                } else {
                    // Get states from the cell above.
                    if (i > 0) {
                        current.or(dp[j]);
                    }

                    // Get states from the cell on the left.
                    if (j > 0) {
                        current.or(dp[j - 1]);
                    }

                    BitSet next = new BitSet(maxBalance);

                    // Apply current character.
                    for (int balance = current.nextSetBit(0);
                         balance >= 0;
                         balance = current.nextSetBit(balance + 1)) {

                        int newBalance;

                        if (grid[i][j] == '(') {
                            newBalance = balance + 1;
                        } else {
                            newBalance = balance - 1;
                        }

                        // A valid parentheses string can never
                        // have a negative balance.
                        if (newBalance >= 0) {
                            next.set(newBalance);
                        }
                    }

                    current = next;
                }

                dp[j] = current;
            }
        }

        // Valid path must finish with balance 0.
        return dp[n - 1].get(0);
    }
}
