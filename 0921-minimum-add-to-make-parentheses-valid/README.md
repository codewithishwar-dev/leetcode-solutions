# 921. Minimum Add to Make Parentheses Valid

**Difficulty:** Medium  
**Topics:** String, Stack, Greedy

## Problem

Given a parentheses string `s`, return the minimum number of parentheses that must be inserted to make the string valid.

In one move, you can insert either `(` or `)` at any position.

### Example 1

```text
Input:  s = "())"
Output: 1
```

### Example 2

```text
Input:  s = "((("
Output: 3
```

## Approach

We can solve this problem using a **Greedy approach** with `O(1)` extra space.

Maintain:

- `open` → number of unmatched opening parentheses `(`
- `additions` → number of `(` that need to be inserted

For every character:

1. If the character is `(`, increment `open`.
2. If the character is `)`:
   - If `open > 0`, match it with an existing `(`.
   - Otherwise, there is no matching `(`, so we need to insert one.

After processing the entire string, any remaining unmatched `(` requires a corresponding `)`.

Therefore:

```text
answer = additions + open
```

## Java Solution

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int additions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    additions++;
                }
            }
        }

        return additions + open;
    }
}
```

## Dry Run

For:

```text
s = "()))"
```

| Character | Open | Additions | Action |
|-----------|-----:|----------:|--------|
| `(` | 1 | 0 | Store opening parenthesis |
| `)` | 0 | 0 | Match with `(` |
| `)` | 0 | 1 | Insert `(` |
| `)` | 0 | 2 | Insert `(` |

Result:

```text
2
```

## Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

## Key Insight

Every unmatched `)` requires an inserted `(`.

Every unmatched `(` remaining at the end requires an inserted `)`.

So the minimum number of insertions is:

```text
unmatched ')' + unmatched '('
```

## Related Problems

- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
- [856. Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)
- [1190. Reverse Substrings Between Each Pair of Parentheses](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)

---

**LeetCode:** https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

**Repository:** CodeWithIshwar
