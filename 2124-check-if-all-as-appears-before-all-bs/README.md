# 2124. Check if All A's Appears Before All B's

**Difficulty:** Easy  
**Topics:** String  
**LeetCode:** [Check if All A's Appears Before All B's](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/)

## Problem Statement

Given a string `s` consisting only of characters `'a'` and `'b'`, return `true` if every `'a'` appears before every `'b'`. Otherwise, return `false`.

## Approach 1: String Contains

### Intuition

The only invalid pattern is `"ba"`.

If a `'b'` appears before an `'a'`, the required ordering is violated.

Therefore:
- If the string contains `"ba"`, return `false`.
- Otherwise, return `true`.

### Java Solution

```java
class Solution {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
```

## Approach 2: Single Pass

### Intuition

Traverse the string while maintaining a boolean variable `foundB`.

1. If the current character is `'b'`, mark `foundB = true`.
2. If the current character is `'a'` and `foundB` is already true, return `false`.
3. If the traversal completes, return `true`.

### Java Solution

```java
class Solution {
    public boolean checkString(String s) {
        boolean foundB = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                foundB = true;
            } else if (foundB) {
                return false;
            }
        }

        return true;
    }
}
```

## Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(n) | Single traversal of the string |
| Space | O(1) | Constant extra space for the single-pass approach |

## Example Walkthrough

**Example 1**

```text
Input: s = "aaabbb"
Output: true
```

All `'a'` characters appear before `'b'`.

**Example 2**

```text
Input: s = "abab"
Output: false
```

An `'a'` appears after a `'b'`, violating the ordering.

**Example 3**

```text
Input: s = "bbb"
Output: true
```

There are no `'a'` characters, so the condition is satisfied.

## Key Learning

- String traversal
- Character ordering
- Early termination
- Identifying invalid adjacent patterns

**Key Observation:** A string is valid if and only if it does not contain the substring `"ba"`.

---

**Ishwar Chandra Tiwari | CodeWithIshwar**

Consistency. Patterns. Real Engineering Thinking.
