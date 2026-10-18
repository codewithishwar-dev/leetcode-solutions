# 1569. Number of Ways to Reorder Array to Get Same BST

**LeetCode Problem:** [1569. Number of Ways to Reorder Array to Get Same BST](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/)  
**Difficulty:** Hard  
**Topics:** Binary Search Tree, Recursion, Combinatorics, Dynamic Programming  
**Language:** Java

## Problem Statement

Given an array `nums` representing a permutation of integers from `1` to `n`, construct a Binary Search Tree (BST) by inserting the elements in the given order.

Return the number of different reorderings of `nums` that produce the same BST as the original array, excluding the original ordering.

Since the answer can be large, return it modulo `10^9 + 7`.

## Approach

The solution uses recursion and combinatorics.

1. **Choose the root:** The first element of the array becomes the BST root.
2. **Partition elements:** Divide the remaining elements into left and right subtrees based on the root value.
3. **Count subtree reorderings:** Recursively calculate the number of valid reorderings for each subtree.
4. **Calculate interleavings:** Use binomial coefficients to count the ways to interleave the left and right subtree elements while preserving their relative order.
5. **Exclude the original ordering:** Subtract one from the final result.

## Formula

Let:
- `L` = number of nodes in the left subtree.
- `R` = number of nodes in the right subtree.
- `leftWays` = valid reorderings of the left subtree.
- `rightWays` = valid reorderings of the right subtree.

The total number of reorderings is:

`ways = C(L + R, L) * leftWays * rightWays`

The final answer is:

`(ways - 1 + MOD) % MOD`

where `MOD = 1_000_000_007`.

## Example

**Input**
```text
nums = [2, 1, 3]
```

**Output**
```text
1
```

**Explanation**

Both `[2, 1, 3]` and `[2, 3, 1]` construct the same BST. Since the original ordering is excluded, the answer is `1`.

## Complexity Analysis

- **Time Complexity:** `O(n²)` in the worst case.
- **Space Complexity:** `O(n²)` for the binomial coefficient table.

## Key Learnings

- Constructing a BST through insertion order.
- Applying recursion to divide a problem into subtrees.
- Using binomial coefficients to count valid interleavings.
- Applying modular arithmetic to avoid integer overflow.

## Related Concepts

- Binary Search Trees
- Pascal's Triangle
- Combinatorics
- Recursive Tree Algorithms
- Dynamic Programming

---

**Repository:** [CodeWithIshwar-dev](https://github.com/CodeWithIshwar-dev)

*Code is what we write. Thinking is what we build.*
