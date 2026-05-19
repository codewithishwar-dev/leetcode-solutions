# 2540. Minimum Common Value

## Problem

Given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return `-1`.

## Approach

Since both arrays are already sorted, we can use the **Two Pointer** technique.

* Start pointers at the beginning of both arrays.
* If elements are equal, return the value.
* Move the pointer pointing to the smaller element.
* Continue until one array ends.

## Complexity

* **Time Complexity:** `O(n + m)`
* **Space Complexity:** `O(1)`

## Java Solution

```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }

            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}
```
