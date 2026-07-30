# 3014. Minimum Number of Pushes to Type Word I

**Difficulty:** Easy  
**Topic:** Greedy, Math, String

## Problem

You are given a string `word` containing distinct lowercase English letters.

A telephone keypad has 8 usable keys, numbered from `2` to `9`. We can remap letters to these keys in any way.

If a letter is placed:

- First on a key → 1 push
- Second on a key → 2 pushes
- Third on a key → 3 pushes
- Fourth on a key → 4 pushes

The goal is to find the minimum number of pushes required to type `word`.

## Approach

There are 8 available keys (`2` to `9`).

To minimize the number of pushes:

- First 8 letters require 1 push each.
- Next 8 letters require 2 pushes each.
- Next 8 letters require 3 pushes each.
- Remaining letters require 4 pushes each.

For a character at index `i`, the number of pushes required is:

```text
(i / 8) + 1
