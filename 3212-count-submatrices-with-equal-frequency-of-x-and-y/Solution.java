class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] prefixX = new int[m][n];
        int[][] prefixY = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int x = (grid[i][j] == 'X') ? 1 : 0;
                int y = (grid[i][j] == 'Y') ? 1 : 0;

                prefixX[i][j] = x;
                prefixY[i][j] = y;

                if (i > 0) {
                    prefixX[i][j] += prefixX[i - 1][j];
                    prefixY[i][j] += prefixY[i - 1][j];
                }
                if (j > 0) {
                    prefixX[i][j] += prefixX[i][j - 1];
                    prefixY[i][j] += prefixY[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixX[i][j] -= prefixX[i - 1][j - 1];
                    prefixY[i][j] -= prefixY[i - 1][j - 1];
                }

                if (prefixX[i][j] == prefixY[i][j] && prefixX[i][j] > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
