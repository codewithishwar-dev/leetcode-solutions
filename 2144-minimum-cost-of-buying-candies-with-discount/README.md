# 2144. Minimum Cost of Buying Candies With Discount

## Problem
For every two candies purchased, a third candy can be taken for free if its cost is less than or equal to the cheaper of the two purchased candies.

Return the minimum cost required to buy all candies.

## Approach
Use a greedy strategy:

1. Sort the candy costs.
2. Traverse from the most expensive candy.
3. For every group of three candies:
   - Pay for the first two.
   - Skip the third (free).

This maximizes the value of the free candies and minimizes the total cost.

## Complexity
- Time: O(n log n)
- Space: O(1)

## Java Solution

```java
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int count = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            count++;

            if (count % 3 == 0) {
                continue;
            }

            total += cost[i];
        }

        return total;
    }
}
