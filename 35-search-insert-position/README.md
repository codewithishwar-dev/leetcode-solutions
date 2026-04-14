# 🔍 Search Insert Position

> 📌 Part of #codewithishwar DSA Series

---

## 🧩 Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found.  
If not, return the index where it would be inserted in order.

⚡ Must run in **O(log n)** time.

---

## 🚀 Approach

We use **Binary Search**:

1. Initialize `left = 0`, `right = n - 1`
2. Find middle index
3. Compare target with middle element:
   - If equal → return index
   - If smaller → search left half
   - If greater → search right half
4. If not found → return `left` (insert position)

---

## 🔍 Example
Input: nums = [1,3,5,6], target = 2
Output: 1

---

## 🧠 Key Insight

After binary search ends,  
👉 `left` always points to the correct insertion index.

---

## ⏱ Complexity

- Time: O(log n)
- Space: O(1)

---

## 💻 Code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}

🏷 Tags
Binary Search
Array
Easy

