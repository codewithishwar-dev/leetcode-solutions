# 3524. Find X Value of Array I

**Difficulty:** Medium

## Problem

You are given an array of positive integers `nums` and a positive integer `k`.

You can remove a prefix and a suffix from `nums`, as long as the remaining array is non-empty.

After the operation, the remaining elements form a **contiguous subarray**.

For every `x` from `0` to `k - 1`, return the number of ways to perform the operation such that the product of the remaining elements has a remainder of `x` when divided by `k`.

## Approach

The important observation is:

> Removing a prefix and suffix leaves a non-empty contiguous subarray.

Therefore, the problem is equivalent to counting all contiguous subarrays according to the remainder of their product modulo `k`.

We use dynamic programming.

### DP Definition

```text
dp[r] = number of subarrays ending at the previous index
       whose product % k == r
```

For every current number `num`:

1. Start a new subarray containing only `num`.
2. Extend every previous subarray with `num`.
3. Calculate the new remainder using:

```text
(new remainder) = (old remainder × (num % k)) % k
```

The counts are then added to the final answer.

## Example

### Input

```text
nums = [1, 2, 3, 4, 5]
k = 3
```

### Output

```text
[9, 2, 4]
```

## Complexity

Let `n` be the length of `nums`.

* **Time:** `O(n × k)`
* **Space:** `O(k)`

Since `k <= 5`, this is effectively `O(n)` time and `O(1)` extra space.

## Java Solution

```java
class Solution {

    public long[] resultArray(int[] nums, int k) {
        long[] dp = new long[k];
        long[] result = new long[k];

        for (int num : nums) {
            int value = num % k;

            long[] newDp = new long[k];

            // Start a new subarray with the current element
            newDp[value]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (r * value) % k;
                    newDp[newRemainder] += dp[r];
                }
            }

            // Add subarrays ending at the current index
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}
```

## Key Takeaway

Instead of generating every possible subarray, maintain the number of subarrays ending at the current position for each possible remainder.

Because `k <= 5`, we only need a very small DP array.
