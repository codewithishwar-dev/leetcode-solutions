# 3300. Minimum Element After Replacement With Digit Sum

## Problem

Given an integer array `nums`.

Replace each element in `nums` with the sum of its digits and return the minimum element after all replacements.

### Example 1

```text
Input: nums = [10,12,13,14]
Output: 1
```

Explanation:

```text
10 → 1
12 → 3
13 → 4
14 → 5
```

Minimum element = `1`

### Example 2

```text
Input: nums = [1,2,3,4]
Output: 1
```

### Example 3

```text
Input: nums = [999,19,199]
Output: 10
```

Explanation:

```text
999 → 27
19 → 10
199 → 19
```

Minimum element = `10`

---

## Approach

For each number:

1. Extract its digits using `% 10`.
2. Calculate the sum of digits.
3. Keep track of the minimum digit sum encountered.
4. Return the minimum value.

---

## Solution

```java
class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = 0;

            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

            min = Math.min(min, digitSum);
        }

        return min;
    }
}
```

---

## Complexity Analysis

### Time Complexity

```text
O(n × d)
```

- `n` = number of elements in `nums`
- `d` = number of digits in each number

Since `nums[i] ≤ 10^4`, `d` is at most 5, making the solution effectively **O(n)**.

### Space Complexity

```text
O(1)
```

Only a few extra variables are used.
