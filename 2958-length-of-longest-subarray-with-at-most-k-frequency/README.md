# 2958. Length of Longest Subarray With at Most K Frequency

**Difficulty:** Medium  
**Topics:** Array, Hash Table, Sliding Window

## Problem Statement

Given an integer array `nums` and an integer `k`, return the length of the longest contiguous subarray such that the frequency of every element in the subarray is at most `k`.

---

## Approach

This problem can be solved efficiently using the **Sliding Window** technique along with a **HashMap** to maintain the frequency of elements inside the current window.

### Algorithm

1. Initialize two pointers:
   - `left` → Start of the sliding window.
   - `right` → End of the sliding window.

2. Use a `HashMap` to store the frequency of each element in the current window.

3. Expand the window by moving the `right` pointer:
   - Increment the frequency of `nums[right]`.

4. If the frequency of `nums[right]` becomes greater than `k`, the window becomes invalid.
   - Shrink the window from the left.
   - Decrease the frequency of `nums[left]`.
   - Move `left` forward until the frequency of `nums[right]` becomes at most `k`.

5. Update the maximum window length after every valid window.

---

## Dry Run

### Example

```text
nums = [1,2,3,1,2,3,1,2]
k = 2
```

| Right | Element | Window | Action | Max Length |
|------:|---------|--------|--------|-----------:|
|0|1|[1]|Valid|1|
|1|2|[1,2]|Valid|2|
|2|3|[1,2,3]|Valid|3|
|3|1|[1,2,3,1]|Valid|4|
|4|2|[1,2,3,1,2]|Valid|5|
|5|3|[1,2,3,1,2,3]|Valid|6|
|6|1|Frequency of 1 becomes 3 → Shrink window|6|
|7|2|Frequency of 2 becomes 3 → Shrink window|6|

**Answer:** `6`

---

## Java Solution

```java
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

---

## Python Solution

```python
from collections import defaultdict

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:

        freq = defaultdict(int)

        left = 0
        max_length = 0

        for right in range(len(nums)):
            freq[nums[right]] += 1

            while freq[nums[right]] > k:
                freq[nums[left]] -= 1
                left += 1

            max_length = max(max_length, right - left + 1)

        return max_length
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| **Time** | **O(n)** |
| **Space** | **O(n)** |

- Each element enters the sliding window once.
- Each element leaves the sliding window at most once.
- Therefore, both pointers traverse the array only once.

---

## Key Insight

Notice that while expanding the window, **only the frequency of `nums[right]` increases**.

If the window becomes invalid, it is because the newly added element exceeded the allowed frequency.

Therefore, we only need to shrink the window until:

```text
frequency(nums[right]) <= k
```

At that point, every element in the current window satisfies the condition.

---

## Interview Explanation

> I use a sliding window and a hash map to track the frequency of elements in the current window. As I expand the right pointer, I update the frequency of the current element. If its frequency exceeds `k`, I shrink the window from the left until the window becomes valid again. During each valid window, I update the maximum length. Since each element is added and removed from the window at most once, the overall time complexity is **O(n)** with **O(n)** extra space.

---

## Patterns Used

- Sliding Window
- HashMap / Frequency Counting
- Two Pointers

---

## Similar Problems

- 3. Longest Substring Without Repeating Characters
- 904. Fruit Into Baskets
- 1004. Max Consecutive Ones III
- 1493. Longest Subarray of 1's After Deleting One Element
- 1695. Maximum Erasure Value
