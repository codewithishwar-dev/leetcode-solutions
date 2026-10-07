# 301. Remove Invalid Parentheses

**Difficulty:** Hard  
**LeetCode:** https://leetcode.com/problems/remove-invalid-parentheses/

## Problem

Given a string `s` that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of **unique valid strings** after the minimum number of removals.

The answer can be returned in any order.

## Examples

### Example 1

```text
Input:  s = "()())()"

Output:
["(())()", "()()()"]
```

### Example 2

```text
Input:  s = "(a)())()"

Output:
["(a())()", "(a)()()"]
```

### Example 3

```text
Input:  s = ")("

Output:
[""]
```

## Approach

### BFS — Breadth-First Search

We use **BFS** because the problem asks for the **minimum number of removals**.

Each BFS level represents removing one additional parenthesis.

For example:

```text
Level 0 → remove 0 parentheses
Level 1 → remove 1 parenthesis
Level 2 → remove 2 parentheses
...
```

As soon as we find valid strings at a level, we know that the minimum number of removals has been found.

We don't generate any deeper levels.

### Algorithm

1. Add the original string to a BFS queue.
2. Use a `HashSet` to avoid processing duplicate strings.
3. For every string:
   - Check whether it is valid.
   - If valid, add it to the result.
4. If a valid string has been found at the current level, don't generate more strings.
5. Otherwise, remove one parenthesis at every possible position.
6. Add every new unique string to the queue.
7. Return the collected valid strings.

## Valid Parentheses Check

Maintain a `balance` counter.

```text
'(' → balance++
')' → balance--
```

A string is valid when:

```text
balance never becomes negative
AND
balance == 0 at the end
```

For example:

```text
(()())

( → 1
( → 2
) → 1
( → 2
) → 1
) → 0

Valid
```

## Java Solution

```java
import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // Do not generate strings with more removals
            // once valid strings are found.
            if (found) {
                continue;
            }

            for (int i = 0; i < current.length(); i++) {

                // Only remove parentheses
                if (current.charAt(i) != '(' &&
                    current.charAt(i) != ')') {
                    continue;
                }

                String next =
                    current.substring(0, i) +
                    current.substring(i + 1);

                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}
```

## Complexity

Let `n` be the length of the string.

### Time

```text
O(2^n × n)
```

In the worst case, there can be exponentially many unique strings, and checking each string takes `O(n)` time.

### Space

```text
O(2^n × n)
```

The queue and visited set can contain exponentially many strings.

## Key DSA Pattern

```text
BFS
├── Minimum number of removals
├── Level-by-level exploration
├── HashSet for duplicate states
└── Early termination after first valid level
```

## Related Problems

- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
- [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
- [856. Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)
- [921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
- [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)

## Key Takeaway

> **When a problem asks for the minimum number of modifications and each modification has equal cost, BFS is often a strong candidate.**
