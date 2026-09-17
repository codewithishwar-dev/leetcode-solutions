# 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

**Difficulty:** Medium
**LeetCode:** https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

---

## Problem

You are given an array of positive integers `arr` and an integer `target`.

Find two **non-overlapping subarrays** such that the sum of each subarray is equal to `target`.

Return the **minimum sum of their lengths**.

If it is impossible to find two such subarrays, return `-1`.

---

## Examples

### Example 1

```text
Input:
arr = [3,2,2,4,3]
target = 3

Output:
2
```

Explanation:

The two valid subarrays are:

```text
[3] and [3]
```

Their total length is:

```text
1 + 1 = 2
```

---

### Example 2

```text
Input:
arr = [7,3,4,7]
target = 7

Output:
2
```

Explanation:

Valid subarrays include:

```text
[7]       → length 1
[3,4]     → length 2
[7]       → length 1
```

The first and last subarrays are non-overlapping:

```text
[7] and [7]
```

Total length:

```text
1 + 1 = 2
```

---

### Example 3

```text
Input:
arr = [4,3,2,6,2,3,4]
target = 6

Output:
-1
```

Only one subarray has a sum equal to `6`, so two non-overlapping subarrays cannot be formed.

---

## Approach

Since all elements in `arr` are **positive**, we can use a **Sliding Window** to find subarrays whose sum equals `target`.

We also maintain a `best[]` array.

```text
best[i] = minimum length of a valid target-sum subarray
          found from index 0 to i
```

Whenever we find a valid subarray from `left` to `right`:

```text
length = right - left + 1
```

We check whether there is a previously found valid subarray completely before `left`.

```text
best[left - 1]
```

If it exists:

```text
totalLength = length + best[left - 1]
```

Then update the answer:

```text
answer = min(answer, totalLength)
```

This guarantees that the two subarrays do not overlap.

---

## Algorithm

1. Initialize a sliding window with `left = 0`.
2. Expand the window by moving `right`.
3. Add `arr[right]` to the current `sum`.
4. While `sum > target`, move `left` forward.
5. If `sum == target`:

   * Calculate the current subarray length.
   * Check `best[left - 1]` for a previous non-overlapping subarray.
   * Update the minimum answer.
   * Update `best[right]`.
6. If no pair of subarrays is found, return `-1`.

---

## Java Solution

```java
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];
        int INF = Integer.MAX_VALUE;

        java.util.Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer,
                        length + best[left - 1]
                    );
                }

                best[right] = Math.min(
                    right > 0 ? best[right - 1] : INF,
                    length
                );
            } else {
                best[right] = right > 0
                    ? best[right - 1]
                    : INF;
            }
        }

        return answer == INF ? -1 : answer;
    }
}
```

---

## Complexity Analysis

Let `n` be the length of the array.

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(n)` |

### Why `O(n)` time?

The `right` pointer moves from left to right once, and the `left` pointer also moves forward only.

Therefore, each element is processed a constant number of times.

---

## Key Insight

The main idea is to combine:

**Sliding Window**

→ Find every subarray with sum equal to `target`.

**DP / Prefix Minimum**

→ Remember the shortest valid subarray found before the current subarray.

Together, they allow us to find the minimum total length of two non-overlapping target-sum subarrays in **O(n)** time.
