# Container With Most Water

## Problem
Given an array `height[]`, where each element represents the height of a vertical line, find two lines that together with the x-axis form a container such that the container stores the maximum amount of water.

## Approach: Two Pointer

- Start with two pointers:
  - Left at beginning
  - Right at end
- Calculate area:
  width = right - left  
  height = min(height[left], height[right])
- Move the pointer with smaller height
- Keep track of maximum area

## Code
See `Solution.java`

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

## Example
Input:
[1,8,6,2,5,4,8,3,7]

Output:
49
