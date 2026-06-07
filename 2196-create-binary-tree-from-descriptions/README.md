# 2196. Create Binary Tree From Descriptions

## Problem Link
https://leetcode.com/problems/create-binary-tree-from-descriptions/

## Difficulty
Medium

## Approach

Use:

- HashMap<Integer, TreeNode> to create and store nodes.
- HashSet<Integer> to track all child nodes.
- Connect parent and child nodes according to the `isLeft` flag.
- The root is the node that never appears as a child.

## Algorithm

1. Iterate through descriptions.
2. Create parent and child nodes if they do not exist.
3. Attach child to parent (left or right).
4. Store child values in a set.
5. Find the parent value that is not present in the child set.
6. Return that node as the root.

## Complexity Analysis

### Time Complexity
O(n)

### Space Complexity
O(n)

## Java Solution

```java
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodes.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodes.get(parentVal);
            TreeNode child = nodes.get(childVal);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                return nodes.get(desc[0]);
            }
        }

        return null;
    }
}
