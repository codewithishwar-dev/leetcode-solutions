# 32. Longest Valid Parentheses

**Difficulty:** Hard
**Problem:** [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

## Problem

Given a string containing only `'('` and `')'`, return the length of the longest valid (well-formed) parentheses substring.

### Example 1

```text
Input: s = "(()"
Output: 2
```

Explanation:

```text
Longest valid substring = "()"
```

### Example 2

```text
Input: s = ")()())"
Output: 4
```

Explanation:

```text
Longest valid substring = "()()"
```

### Example 3

```text
Input: s = ""
Output: 0
```

## Approach

Use a stack to store the indices of unmatched parentheses.

Initially, push `-1` as a boundary index.

### Algorithm

1. Push `-1` into the stack.
2. Traverse the string from left to right.
3. If the current character is `'('`, push its index.
4. If the current character is `')'`:

   * Pop the top index.
   * If the stack becomes empty, push the current index as the new boundary.
   * Otherwise, calculate the length using:

```text
currentIndex - stack.peek()
```

5. Keep track of the maximum length.

## Why `-1`?

The `-1` acts as a boundary before the beginning of the string.

For example:

```text
s = "()"
```

When we reach index `1`:

```text
1 - (-1) = 2
```

Therefore, the valid substring length is correctly calculated as `2`.

## Complexity

* **Time:** O(n)
* **Space:** O(n)

## Key Takeaway

The important idea is to store **indices rather than parentheses themselves**.

The stack helps identify the boundary of the current valid substring, allowing us to calculate its length in O(1).

## Java Solution

```java
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
```

## Related Pattern

**Pattern:** Stack / Parentheses Matching / Index Tracking

**Useful for:**

* Valid Parentheses
* Longest Valid Parentheses
* Remove Invalid Parentheses
* Parentheses-related parsing problems

**Ishwar Chandra Tiwari | CodeWithIshwar**
