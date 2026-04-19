# 2. Add Two Numbers

## 🧩 Problem
Given two non-empty linked lists representing two non-negative integers, where digits are stored in reverse order, return their sum as a linked list.

## 💡 Approach
- Traverse both lists
- Add digits + carry
- Store result in new linked list

## ⏱ Complexity
- Time: O(max(n, m))
- Space: O(max(n, m))

## 📌 Example
Input:
l1 = [2,4,3]
l2 = [5,6,4]

Output:
[7,0,8]
