# 856. Score of Parentheses

## Problem

Given a balanced parentheses string `s`, return the score of the string.

The score follows these rules:

- `()` has score `1`.
- `AB` has score `A + B`, where `A` and `B` are balanced parentheses strings.
- `(A)` has score `2 * A`.

## Approach

Use a stack to maintain the score at each level of nested parentheses.

When we encounter:

- `(` → Push a new score level with `0`.
- `)` → Calculate the score of the current level:
  - If the inner score is `0`, it represents `()`, so the score is `1`.
  - Otherwise, the score is `2 * innerScore`.
  - Add this score to the parent level.

## Example

Input:

```text
s = "(()())"
