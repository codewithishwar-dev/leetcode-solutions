# 3550. Smallest Index With Digit Sum Equal to Index

**Difficulty:** Easy

## Problem

You are given an integer array `nums`.

Return the **smallest index** `i` such that the sum of the digits of `nums[i]` is equal to `i`.

If no such index exists, return `-1`.

## Examples

### Example 1

```text
Input: nums = [1,3,2]
Output: 2
```

Explanation:

```text
nums[2] = 2
Digit sum = 2
Index = 2
```

Therefore, the answer is `2`.

### Example 2

```text
Input: nums = [1,10,11]
Output: 1
```

Explanation:

```text
Index 1 → nums[1] = 10
Digit sum = 1 + 0 = 1

Index 2 → nums[2] = 11
Digit sum = 1 + 1 = 2
```

The smallest valid index is `1`.

### Example 3

```text
Input: nums = [1,2,3]
Output: -1
```

No index satisfies the condition.

## Approach

Iterate through the array from left to right.

For every index `i`:

1. Calculate the sum of digits of `nums[i]`.
2. Compare the digit sum with `i`.
3. If they are equal, return `i`.
4. If no index satisfies the condition, return `-1`.

Because we iterate from the smallest index to the largest, the first matching index is automatically the smallest.

## Java Solution

```java
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitSum = 0;

            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}
```

## Complexity

* **Time Complexity:** `O(n × d)`

  * `n` = number of elements
  * `d` = number of digits in an element
* **Space Complexity:** `O(1)`

## Key Takeaway

When a problem asks for the **smallest index** satisfying a condition, iterating from left to right often allows us to return immediately when the first valid index is found.

**Ishwar Chandra Tiwari | CodeWithIshwar**
