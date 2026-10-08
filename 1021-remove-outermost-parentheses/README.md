# 1021. Remove Outermost Parentheses

🔗 [LeetCode — Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

**Difficulty:** Easy

---

## 🧩 Problem

A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings.

A valid parentheses string is **primitive** if it is non-empty and cannot be split into two non-empty valid parentheses strings.

Given a valid parentheses string `s`, return the string after removing the **outermost parentheses of every primitive string** in its primitive decomposition.

---

## 📝 Examples

### Example 1

**Input:**

```text
s = "(()())(())"
```

**Output:**

```text
"()()()"
```

**Explanation:**

The primitive decomposition is:

```text
"(()())" + "(())"
```

After removing the outermost parentheses:

```text
"()()" + "()"
```

Result:

```text
"()()()"
```

---

### Example 2

**Input:**

```text
s = "(()())(())(()(()))"
```

**Output:**

```text
"()()()()(())"
```

---

### Example 3

**Input:**

```text
s = "()()"
```

**Output:**

```text
""
```

The primitive decomposition is:

```text
"()" + "()"
```

Removing the outermost parentheses from each primitive gives:

```text
"" + ""
```

---

## 💡 Approach

We can solve this problem using a **balance counter** instead of a stack.

The `balance` variable represents the current nesting depth.

### For `(`

If:

```text
balance > 0
```

the opening parenthesis is inside a primitive string, so we add it to the result.

Then increase the balance:

```text
balance++
```

### For `)`

First decrease the balance:

```text
balance--
```

If:

```text
balance > 0
```

the closing parenthesis is not the outermost closing parenthesis, so we add it to the result.

---

## 🔍 Dry Run

For:

```text
s = "(()())"
```

| Character | Balance Before | Action | Balance After |
|---|---:|---|---:|
| `(` | 0 | Skip | 1 |
| `(` | 1 | Add | 2 |
| `)` | 2 | Add | 1 |
| `(` | 1 | Add | 2 |
| `)` | 2 | Add | 1 |
| `)` | 1 | Skip | 0 |

Result:

```text
"()()"
```

The first `(` and final `)` are the outermost parentheses and are removed.

---

## 💻 Java Solution

```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (balance > 0) {
                    result.append(ch);
                }
                balance++;
            } else {
                balance--;

                if (balance > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
```

---

## ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the string exactly once.

### Space Complexity

```text
O(n)
```

The `StringBuilder` stores the resulting string.

---

## 🧠 Key Pattern

**Pattern:** Parentheses / Balance Counter

The important idea is that we don't need a stack because we only need to know the **current nesting depth**.

```text
balance == 0
    ↓
Primitive boundary / outermost level

balance > 0
    ↓
Inside a primitive → keep the parenthesis
```

---

## 🎯 What I Learned

- How to identify primitive parentheses strings.
- How to track nesting depth using a counter.
- How to remove outermost parentheses without using a stack.
- How a balance counter can simplify parentheses problems.
- How to solve the problem in `O(n)` time.

---

## 🔗 Related Problems

- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
- [856. Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)
- [921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
- [1021. Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

---

⭐ **Part of my LeetCode & DSA practice journey with CodeWithIshwar.**

#LeetCode #DSA #Java #ProblemSolving #Algorithms #CodingInterview
