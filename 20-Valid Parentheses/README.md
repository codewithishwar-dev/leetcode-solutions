# Valid Parentheses

🔗 Problem Link: https://leetcode.com/problems/valid-parentheses/

## Difficulty

Easy

---

# Problem Statement

Given a string `s` containing just the characters:

```
( ) { } [ ]
```

Determine if the input string is valid.

A string is valid if:

* Open brackets must be closed by the same type.
* Open brackets must be closed in the correct order.
* Every closing bracket must have a corresponding opening bracket.

---

# Examples

### Example 1

Input

```
s = "()"
```

Output

```
true
```

### Example 2

Input

```
s = "()[]{}"
```

Output

```
true
```

### Example 3

Input

```
s = "(]"
```

Output

```
false
```

---

# Constraints

* `1 <= s.length <= 10^4`
* `s` consists of parentheses only `()[]{}`

---

# Approach

To validate the parentheses structure, we use a **Stack**.

### Key Idea

Whenever we encounter an **opening bracket**, we push it into the stack.

When we encounter a **closing bracket**, we check if the top of the stack contains the corresponding opening bracket.

If it does not match, the string is invalid.

---

# Algorithm

1. Create an empty stack.
2. Iterate through each character in the string.
3. If it is an opening bracket → push to stack.
4. If it is a closing bracket:

   * Check if stack is empty → return false.
   * Pop the top element.
   * Verify the pair matches.
5. After processing all characters, the stack should be empty.

---

# Time Complexity

```
O(n)
```

We traverse the string once.

---

# Space Complexity

```
O(n)
```

Stack may store all opening brackets in the worst case.

---

# Java Solution

```java
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {

                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
```

---

# Author

**Ishwar Chandra Tiwari**
Founder — CodeWithIshwar

GitHub: https://github.com/codewithishwar-dev
