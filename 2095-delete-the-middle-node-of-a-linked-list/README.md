# 2095. Delete the Middle Node of a Linked List

## Problem Statement

Given the head of a linked list, delete the middle node and return the head of the modified linked list.

The middle node of a linked list of size `n` is the `⌊n / 2⌋th` node from the start using 0-based indexing.

### Example 1

Input:
```
head = [1,3,4,7,1,2,6]
```

Output:
```
[1,3,4,1,2,6]
```

### Example 2

Input:
```
head = [1,2,3,4]
```

Output:
```
[1,2,4]
```

### Example 3

Input:
```
head = [2,1]
```

Output:
```
[2]
```

---

## Approach: Fast & Slow Pointer

We use two pointers:

- `slow` moves one step at a time.
- `fast` moves two steps at a time.
- `prev` keeps track of the node before `slow`.

When `fast` reaches the end of the list:

- `slow` points to the middle node.
- Remove the middle node by setting:

```java
prev.next = slow.next;
```

### Algorithm

1. If the list contains only one node, return `null`.
2. Initialize `slow`, `fast`, and `prev`.
3. Move:
   - `slow` by one node.
   - `fast` by two nodes.
4. Once traversal ends, delete the node pointed to by `slow`.
5. Return the head.

---

## Complexity Analysis

### Time Complexity

```
O(n)
```

We traverse the linked list only once.

### Space Complexity

```
O(1)
```

No extra space is used.

---

## Java Solution

```java
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
```

---

## Key Learning

- Fast and Slow Pointer is a common pattern for linked list problems.
- It helps find the middle node in a single traversal.
- Space-efficient solution with O(1) extra memory.

---

**LeetCode:** 2095 - Delete the Middle Node of a Linked List  
**Difficulty:** Medium  
**Topics:** Linked List, Two Pointers
