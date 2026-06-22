# 1189. Maximum Number of Balloons

## Problem Statement

Given a string `text`, return the maximum number of instances of the word `"balloon"` that can be formed using the characters of `text`.

Each character in `text` can be used at most once.

### Example 1

Input:
text = "nlaebolko"

Output:
1

### Example 2

Input:
text = "loonbalxballpoon"

Output:
2

### Example 3

Input:
text = "leetcode"

Output:
0

## Approach

The word `"balloon"` requires:

- b → 1
- a → 1
- l → 2
- o → 2
- n → 1

Steps:

1. Count the frequency of each character in the input string.
2. Since `l` and `o` appear twice in `"balloon"`, divide their frequencies by 2.
3. The maximum number of balloons that can be formed is the minimum count among all required characters.

## Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(1)

## Tags

String, Hash Table, Counting
