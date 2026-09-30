# 2267. Check if There Is a Valid Parentheses String Path

**LeetCode:** https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/

**Difficulty:** Hard

**Topics:** Dynamic Programming, Grid, BitSet, State DP

---

## Problem

You are given an `m x n` matrix containing only `'('` and `')'`.

Starting from the top-left cell `(0, 0)`, you must reach the bottom-right cell `(m - 1, n - 1)`.

At every step, you can move only:

* Right
* Down

The characters visited along the path form a parentheses string.

Return `true` if there exists a path that forms a **valid parentheses string**. Otherwise, return `false`.

---

## Example 1

### Input

```text
grid = [
    ["(", "(", "("],
    [")", "(", ")"],
    ["(", "(", ")"],
    ["(", "(", ")"]
]
```

### Output

```text
true
```

### Explanation

There are multiple possible paths that form valid parentheses strings, such as:

```text
()(())
```

or

```text
((()))
```

---

## Example 2

### Input

```text
grid = [
    [")", ")"],
    ["(", "("]
]
```

### Output

```text
false
```

### Explanation

The possible paths produce:

```text
))(
```

and

```text
)((
```

Neither is a valid parentheses string.

---

## Approach

We use **Dynamic Programming with the current parenthesis balance**.

For a parentheses string:

* `'('` increases the balance by `1`
* `')'` decreases the balance by `1`

A valid parentheses string must satisfy:

```text
balance >= 0
```

at every position and:

```text
balance == 0
```

at the end.

### DP State

For every cell `(i, j)`, we maintain all possible balances that can reach that cell.

We use:

```java
BitSet
```

to efficiently store the possible balance values.

For each cell, the possible states can come from:

```text
        top
         ↓
left → current
```

After combining the states from the top and left cells, we apply the current character.

### Transition

If the current character is `'('`:

```text
newBalance = balance + 1
```

If the current character is `')'`:

```text
newBalance = balance - 1
```

We discard any state where:

```text
newBalance < 0
```

because a valid parentheses string can never have a negative balance.

---

## Important Optimization

The total path length is:

```text
m + n - 1
```

Every valid parentheses string must have an even number of characters.

Therefore, if:

```text
(m + n - 1) % 2 != 0
```

we can immediately return `false`.

---

## Java Solution

```java
import java.util.*;

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Total path length must be even.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Maximum possible balance.
        int maxBalance = m + n;

        // dp[j] stores all possible balances for the current cell.
        BitSet[] dp = new BitSet[n];

        for (int j = 0; j < n; j++) {
            dp[j] = new BitSet(maxBalance);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                BitSet current = new BitSet(maxBalance);

                // Starting cell.
                if (i == 0 && j == 0) {
                    if (grid[i][j] == '(') {
                        current.set(1);
                    }
                } else {

                    // From top.
                    if (i > 0) {
                        current.or(dp[j]);
                    }

                    // From left.
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

                        // Balance cannot become negative.
                        if (newBalance >= 0) {
                            next.set(newBalance);
                        }
                    }

                    current = next;
                }

                dp[j] = current;
            }
        }

        // A valid parentheses string must end with balance 0.
        return dp[n - 1].get(0);
    }
}
```

---

## Complexity

Let:

```text
m = number of rows
n = number of columns
```

The maximum possible balance is `O(m + n)`.

### Time Complexity

```text
O(m × n × (m + n))
```

### Space Complexity

```text
O(n × (m + n))
```

---

## Key Takeaway

This problem is a good example of **state-based Grid DP**.

Instead of storing only whether a cell is reachable, we store:

```text
cell + possible balance
```

The important state is:

```text
(i, j, balance)
```

and the transition depends on whether the current grid cell contains `'('` or `')'`.

This pattern is useful for problems where a grid path must satisfy a running constraint such as:

* Parentheses balance
* Running sum
* Minimum/maximum resource
* Budget constraint
* Inventory/resource tracking
* Path-dependent state

**Ishwar Chandra Tiwari | CodeWithIshwar**
