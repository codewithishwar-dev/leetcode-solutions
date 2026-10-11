# 2778. Sum of Squares of Special Elements

**Difficulty:** Easy  
**Topics:** Array, Math  
**Language:** Java  
**LeetCode:** [Sum of Squares of Special Elements](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

## Problem Statement

You are given a 1-indexed integer array `nums` of length `n`.

An element `nums[i]` is called **special** if its index `i` divides `n`, meaning `n % i == 0`.

Return the sum of the squares of all special elements.

## Approach: Array Traversal

1. Calculate the length of the array, `n`.
2. Iterate through the indices from `1` to `n`.
3. Check whether `n % i == 0`.
4. If the condition is true, add the square of `nums[i - 1]` to the sum.
5. Return the final sum.

**Note:** The problem uses 1-based indexing, while Java arrays use 0-based indexing. Therefore, access each element using `nums[i - 1]`.

## Java Solution

```java
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }
}
```

## Example 1

**Input**
```text
nums = [1, 2, 3, 4]
```

**Output**
```text
21
```

**Explanation**

The array length is `4`. The special indices are `1`, `2`, and `4`.

Sum of squares = `1² + 2² + 4² = 1 + 4 + 16 = 21`.

## Example 2

**Input**
```text
nums = [2, 7, 1, 19, 18, 3]
```

**Output**
```text
63
```

**Explanation**

The array length is `6`. The special indices are `1`, `2`, `3`, and `6`.

Sum of squares = `2² + 7² + 1² + 3² = 4 + 49 + 1 + 9 = 63`.

## Complexity Analysis

- **Time Complexity:** `O(n)` — each index is checked once.
- **Space Complexity:** `O(1)` — only a constant amount of extra space is used.

## Key Takeaway

An index is special when it is a divisor of the array length. Checking divisibility with the modulo operator (`%`) provides a simple and efficient solution.

---

**Part of my LeetCode problem-solving journey.**

Building consistency, one problem at a time.

Follow **CodeWithIshwar** for more DSA solutions, Java practice, and software engineering notes.
