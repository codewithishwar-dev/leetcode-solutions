# 2130. Maximum Twin Sum of a Linked List

**Difficulty:** Medium

## Problem Statement

In a linked list of size `n`, where `n` is even, the `i-th` node is the twin of the `(n-1-i)-th` node.

The twin sum is defined as the sum of a node and its twin.

Return the maximum twin sum of the linked list.

## Example

### Example 1

Input:
[5,4,2,1]

Output:
6

Explanation:
- 5 + 1 = 6
- 4 + 2 = 6

Maximum twin sum = 6

### Example 2

Input:
[4,2,2,3]

Output:
7

Explanation:
- 4 + 3 = 7
- 2 + 2 = 4

Maximum twin sum = 7

## Approach

### Optimal Approach (Reverse Second Half)

1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Traverse both halves simultaneously.
4. Calculate twin sums and track the maximum.

### Why it works

After reversing the second half, each node in the first half aligns directly with its twin node.

For example:

Original:

5 -> 4 -> 2 -> 1

After reversing second half:

First Half:
5 -> 4

Second Half:
1 -> 2

Twin sums:

5 + 1 = 6

4 + 2 = 6

Maximum = 6

## Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(1)

## Key Concepts

- Fast & Slow Pointers
- Linked List Reversal
- Two-Pointer Traversal
