class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m = len(grid)
        n = len(grid[0])

        # Path length must be even
        if (m + n - 1) % 2 != 0:
            return False

        # dp[j] = set of possible balances at current row, column j
        dp = [set() for _ in range(n)]

        for i in range(m):
            for j in range(n):
                current = set()

                value = 1 if grid[i][j] == '(' else -1

                # Starting cell
                if i == 0 and j == 0:
                    if value == 1:
                        current.add(1)
                else:
                    # From top
                    if i > 0:
                        current.update(dp[j])

                    # From left
                    if j > 0:
                        current.update(dp[j - 1])

                    # Apply current parenthesis
                    new_balances = set()

                    for balance in current:
                        new_balance = balance + value

                        # Balance can never become negative
                        if new_balance >= 0:
                            new_balances.add(new_balance)

                    current = new_balances

                dp[j] = current

        return 0 in dp[n - 1]
