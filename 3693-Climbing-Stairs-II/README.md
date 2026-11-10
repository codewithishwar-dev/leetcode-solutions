# 3693. Climbing Stairs II

**Difficulty:** Medium  
**Topics:** Dynamic Programming, Array  
**Language:** Java

## Problem Statement

You are climbing a staircase with `n + 1` steps, numbered from `0` to `n`.

You are given a 1-indexed integer array `costs`, where `costs[i]` represents the cost of landing on step `i`.

From step `i`, you can jump to step `i + 1`, `i + 2`, or `i + 3`.

The cost of jumping from step `i` to step `j` is:

`costs[j] + (j - i)²`

You start at step `0` with an initial cost of `0`.

Return the minimum total cost to reach step `n`.

## Approach: Dynamic Programming (Bottom-Up)

Define:

`dp[i]` = Minimum cost required to reach step `i`.

### Transition

For every step `i`, consider jumps of length 1, 2, and 3.

```text
dp[i] = min(
    dp[i - 1] + costs[i - 1] + 1,
    dp[i - 2] + costs[i - 1] + 4,
    dp[i - 3] + costs[i - 1] + 9
)
```

Only consider valid previous steps.

### Java Solution

```java
class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        java.util.Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= 3; j++) {

                if (i - j >= 0) {

                    int jumpCost = costs[i - 1] + j * j;

                    dp[i] = Math.min(
                        dp[i],
                        dp[i - j] + jumpCost
                    );
                }
            }
        }

        return dp[n];
    }
}
```

## Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(n) |
| Space | O(n) |

Each step checks at most three previous states.

## Example

**Input:**
```java
n = 4;
costs = new int[]{1, 2, 3, 4};
```

**Output:**
```text
13
```

**Optimal Path:**

`0 → 1 → 2 → 4`

Total cost = `2 + 3 + 8 = 13`

## Key Learnings

- Bottom-Up Dynamic Programming
- State Transition Optimization
- Minimum Cost Path
- Variable Jump Length

---

**Pattern:** Dynamic Programming – Minimum Cost

**#CodeWithIshwar #LeetCode #Java #DynamicProgramming #DSA #ProblemSolving**
