# 3903. Smallest Stable Index I

**Difficulty:** Easy

## Problem

You are given an integer array `nums` and an integer `k`.

For each index `i`, define its **instability score** as:

```text
max(nums[0..i]) - min(nums[i..n-1])
```

An index is considered **stable** if its instability score is less than or equal to `k`.

Return the **smallest stable index**. If no stable index exists, return `-1`.

## Examples

### Example 1

```text
Input:
nums = [5,0,1,4]
k = 3

Output:
3
```

At index `3`:

```text
max([5,0,1,4]) = 5
min([4]) = 4

5 - 4 = 1 <= 3
```

Therefore, the smallest stable index is `3`.

### Example 2

```text
Input:
nums = [3,2,1]
k = 1

Output:
-1
```

For every index, the instability score is `2`, which is greater than `1`.

### Example 3

```text
Input:
nums = [0]
k = 0

Output:
0
```

The instability score is:

```text
0 - 0 = 0
```

So index `0` is stable.

## Approach

We need two values for every index:

1. Maximum value from index `0` to `i`
2. Minimum value from index `i` to `n - 1`

### Step 1: Suffix Minimum

Create an array `suffixMin` where:

```text
suffixMin[i] = min(nums[i], nums[i+1], ..., nums[n-1])
```

Build it from right to left.

### Step 2: Prefix Maximum

Traverse the array from left to right while maintaining:

```text
prefixMax = maximum value from nums[0] to nums[i]
```

For each index:

```text
instability = prefixMax - suffixMin[i]
```

If:

```text
instability <= k
```

we immediately return `i`.

Because we scan from left to right, this is guaranteed to be the smallest stable index.

## Complexity

* **Time:** `O(n)`
* **Space:** `O(n)`

## Java Solution

```java
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
```

## Key Pattern

This problem is a good example of the:

**Prefix Maximum + Suffix Minimum**

pattern.

Whenever a problem asks for:

```text
something from [0..i]
+
something from [i..n-1]
```

consider precomputing prefix/suffix information to avoid repeatedly scanning the array.

**CodeWithIshwar|Ishwar Chandra Tiwari**
