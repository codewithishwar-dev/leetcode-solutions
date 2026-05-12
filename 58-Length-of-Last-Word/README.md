# 58. Length of Last Word

## Problem
Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

## Example

Input:
"Hello World"

Output:
5

## Approach
- Traverse the string from the end.
- Skip trailing spaces.
- Count characters until a space is found.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)
