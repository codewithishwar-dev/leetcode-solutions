# 1190. Reverse Substrings Between Each Pair of Parentheses

**Difficulty:** Medium

**LeetCode:** https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

## Problem

You are given a string `s` consisting of lowercase English letters and parentheses.

Reverse the strings inside each pair of matching parentheses, starting from the innermost pair.

The final result should **not contain any parentheses**.

## Examples

### Example 1

**Input:**

```text
(abcd)
```

**Output:**

```text
dcba
```

### Example 2

**Input:**

```text
(u(love)i)
```

**Output:**

```text
iloveu
```

**Explanation:**

First, reverse `"love"`:

```text
love → evol
```

Then reverse the entire substring:

```text
uevoli → iloveu
```

### Example 3

**Input:**

```text
(ed(et(oc))el)
```

**Output:**

```text
leetcode
```

## Approach

We use a **Stack** to handle nested parentheses.

### Algorithm

1. Create a stack of `StringBuilder` objects.
2. Iterate through every character in the string.
3. If the character is `(`:

   * Push the current `StringBuilder` onto the stack.
   * Start a new `StringBuilder`.
4. If the character is `)`:

   * Reverse the current `StringBuilder`.
   * Pop the previous `StringBuilder` from the stack.
   * Append the reversed substring to the previous string.
5. If the character is a lowercase letter:

   * Append it to the current `StringBuilder`.
6. Return the final string.

## Example Walkthrough

For:

```text
(u(love)i)
```

The processing is:

```text
(u(love)i)
     ↓
   love
     ↓
   evol
     ↓
  (uevoli)
     ↓
  iloveu
```

Final result:

```text
iloveu
```

## Java Solution

```java
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();

            } else if (ch == ')') {
                current.reverse();

                StringBuilder previous = stack.pop();
                previous.append(current);

                current = previous;

            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
```

## Complexity

Let `n` be the length of the input string.

* **Time Complexity:** `O(n²)` in the worst case due to repeated string reversals.
* **Space Complexity:** `O(n)` for the stack and intermediate strings.

## Key Concept

**Stack + String Reversal**

This problem is a good example of using a stack to process **nested structures** such as parentheses.
