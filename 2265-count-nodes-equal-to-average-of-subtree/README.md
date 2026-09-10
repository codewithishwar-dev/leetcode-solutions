# 2265. Count Nodes Equal to Average of Subtree

**LeetCode:** 2265
**Difficulty:** Medium
**Topic:** Binary Tree, DFS, Postorder Traversal

## Problem

Given the root of a binary tree, return the number of nodes where the node's value is equal to the average of all values in its subtree.

The average is rounded down to the nearest integer.

## Approach

Use **Postorder DFS**.

For every node, calculate:

* Sum of values in its subtree
* Number of nodes in its subtree

Then check:

```text
node.val == sum / count
```

If true, increment the result.

### Why Postorder?

The parent node needs the `sum` and `count` from both its left and right subtrees.

Therefore, we process:

```text
Left → Right → Root
```

## Complexity

* **Time:** O(n)
* **Space:** O(h)

Where:

* `n` = number of nodes
* `h` = height of the tree

## Example

```text
Input:
[4,8,5,0,1,null,6]

Output:
5
```

## Key Learning

This problem demonstrates how a recursive DFS can return multiple pieces of information from each subtree.

For each node:

```text
subtree sum   = node.val + left.sum + right.sum
subtree count = 1 + left.count + right.count
```
