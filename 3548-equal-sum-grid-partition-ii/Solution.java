import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid) {
            for (int v : row) total += v;
        }

        // -------- HORIZONTAL CUT --------
        long topSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                topSum += grid[i][j];
            }

            long bottomSum = total - topSum;

            if (topSum == bottomSum) return true;

            long diff = Math.abs(topSum - bottomSum);

            if (topSum > bottomSum) {
                if (canRemove(grid, 0, 0, i, n - 1, diff)) return true;
            } else {
                if (canRemove(grid, i + 1, 0, m - 1, n - 1, diff)) return true;
            }
        }

        // -------- VERTICAL CUT --------
        long leftSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                leftSum += grid[i][j];
            }

            long rightSum = total - leftSum;

            if (leftSum == rightSum) return true;

            long diff = Math.abs(leftSum - rightSum);

            if (leftSum > rightSum) {
                if (canRemove(grid, 0, 0, m - 1, j, diff)) return true;
            } else {
                if (canRemove(grid, 0, j + 1, m - 1, n - 1, diff)) return true;
            }
        }

        return false;
    }

    private boolean canRemove(int[][] grid,
                              int r1, int c1, int r2, int c2,
                              long diff) {

        if (diff > 100000) return false;
        int val = (int) diff;

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // 2D block → safe
        if (rows > 1 && cols > 1) {
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (grid[i][j] == val) return true;
                }
            }
            return false;
        }

        // single row → edges only
        if (rows == 1) {
            return grid[r1][c1] == val || grid[r1][c2] == val;
        }

        // single column → edges only
        if (cols == 1) {
            return grid[r1][c1] == val || grid[r2][c1] == val;
        }

        return false;
    }
}
