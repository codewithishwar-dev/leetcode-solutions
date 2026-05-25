# 1871. Jump Game VII

**Difficulty:** Medium

## Problem

You are given a 0-indexed binary string `s` and two integers `minJump` and `maxJump`.

Initially, you are standing at index `0` (which is guaranteed to be `'0'`).

You can jump from index `i` to index `j` if:

- `i + minJump <= j <= min(i + maxJump, s.length - 1)`
- `s[j] == '0'`

Return `true` if you can reach the last index, otherwise return `false`.

---

## Approach: Dynamic Programming + Sliding Window

For every position `i`, we need to determine whether there exists a reachable index within:

```text
[i - maxJump, i - minJump]
```

A naive approach scans the entire range for each position, resulting in **O(n²)** complexity.

To optimize:

- Maintain a sliding window count of reachable positions.
- Add positions entering the window.
- Remove positions leaving the window.
- If at least one reachable position exists in the window and `s[i] == '0'`, then `i` is reachable.

This allows us to determine reachability in constant time per index.

---

## Algorithm

1. Create a boolean array `dp`.
2. Mark `dp[0] = true`.
3. Maintain `reachableCount` representing reachable indices inside the current valid jump window.
4. For each position:
   - Add `dp[i - minJump]` when it enters the window.
   - Remove `dp[i - maxJump - 1]` when it leaves the window.
   - Mark current position reachable if:
     - `s[i] == '0'`
     - `reachableCount > 0`
5. Return `dp[n - 1]`.

---

## Java Solution

```java
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            if (i - minJump >= 0 && dp[i - minJump]) {
                reachableCount++;
            }

            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            dp[i] = s.charAt(i) == '0' && reachableCount > 0;
        }

        return dp[n - 1];
    }
}
```

---

## Complexity Analysis

### Time Complexity

```text
O(n)
```

Each index enters and leaves the sliding window exactly once.

### Space Complexity

```text
O(n)
```

For the DP array.

---

## Key Insight

Instead of checking every possible previous jump position for each index, maintain a running count of reachable indices in the valid jump range using a sliding window. This reduces the solution from **O(n²)** to **O(n)**.
