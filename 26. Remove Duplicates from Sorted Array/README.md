# 🚀 CodeWithIshwar - LeetCode Solutions

Consistent problem solving. Clean code. Real understanding.
Follow the journey ⭐

---

# 26. Remove Duplicates from Sorted Array

🔗 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

---

## 🧠 Problem Summary

Given a sorted array `nums`, remove the duplicates **in-place** such that each element appears only once.

Return the number of unique elements `k`.

* Modify the array in-place
* Use O(1) extra space
* First `k` elements should contain unique values

---

## 💡 Approach: Two Pointers

Since the array is sorted, duplicates are adjacent.

We use:

* `i` → tracks unique elements
* `j` → scans the array

### Steps:

1. Initialize `i = 0`
2. Loop `j` from `1` to `n-1`
3. If `nums[j] != nums[i]`

   * Increment `i`
   * Update `nums[i] = nums[j]`
4. Return `i + 1`

---

## 📊 Example

### Input

```
[1,1,2]
```

### Output

```
2
```

### Modified Array

```
[1,2,_]
```

---

## ⏱️ Complexity

* Time Complexity: **O(n)**
* Space Complexity: **O(1)**

---

## 🚀 Code (Java)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```

---

## 🔥 Key Learnings

* Two Pointer Technique
* In-place array modification
* Foundation for advanced problems

---

## ✍️ Author

**Ishwar Chandra Tiwari**
🚀 CodeWithIshwar

---

## ⭐ Support

If this helped you, consider giving this repo a ⭐
