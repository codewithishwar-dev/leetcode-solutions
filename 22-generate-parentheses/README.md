# 22. Generate Parentheses

## Problem Statement

Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

### Example 1

Input:
```text
n = 3
```

Output:
```text
["((()))","(()())","(())()","()(())","()()()"]
```

### Example 2

Input:
```text
n = 1
```

Output:
```text
["()"]
```

---

# Approach - Backtracking

We build the parentheses string step by step.

## Rules

- Add `"("` if opening brackets are still available.
- Add `")"` only if it keeps the string valid.
- A valid string can never have more closing brackets than opening brackets.

---

# Java Solution

```java
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result,
                           String current,
                           int open,
                           int close,
                           int n) {

        // Base case
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add closing bracket
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
```

---

# Complexity Analysis

## Time Complexity

```text
O(4^n / √n)
```

(Catalan Number)

## Space Complexity

```text
O(n)
```

Recursive stack space.

---

# Key Learning

The important condition is:

```java
close < open
```

This ensures the parentheses combination always remains valid.

---

# Topics

- Backtracking
- Recursion
- DFS
- Strings
