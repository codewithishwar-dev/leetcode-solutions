# 3020. Find the Maximum Number of Elements in Subset

**Difficulty:** Medium

## Problem

Given an array of positive integers `nums`, select the largest subset that can be arranged in the following form:

[x, x², x⁴, ..., xᵏ, xᵏ⁻¹, ..., x⁴, x², x]

where `k` is any non-negative power of 2.

Return the maximum possible size of such a subset.

---

## Intuition

A valid sequence is symmetric.

- Every element except the middle (peak) must appear **twice**.
- The peak appears **once**.
- Each next value is the square of the previous value.

For example:

```
2 → 4 → 16
```

requires the frequencies:

```
2 : 2
4 : 2
16 : 1
```

which forms:

```
[2, 4, 16, 4, 2]
```

---

## Approach

1. Count the frequency of every number.
2. Handle `1` separately because:

```
1² = 1
```

A valid sequence using only `1`s must have an **odd** length.

3. For every distinct value `x (≠ 1)`:

   - Continue while there are at least **2 copies**.
   - Move to `x²`.
   - When the chain stops:
     - If the current value exists, use it as the peak.
     - Otherwise, remove one element since a peak is missing.

4. Keep the maximum length.

---

## Algorithm

```
Count frequencies.

Handle value 1 separately.

For every distinct value:

    length = 0

    while frequency >= 2
        length += 2
        current = current²

    if current exists
        length++
    else
        length--

Return maximum length.
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

where `n` is the size of the input array.

---

## Java Solution

```java
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle value 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {
            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                if (cur > Long.MAX_VALUE / cur) break;
                cur *= cur;
            }

            if (freq.getOrDefault(cur, 0) >= 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
```

---

## Key Takeaways

- Use a frequency map to efficiently verify element availability.
- Every non-peak element requires **two occurrences**.
- The peak requires **one occurrence**.
- Handle the special case of `1` separately because repeated squaring never changes its value.
- Use `long` to safely compute squared values.

---

**Tags:** HashMap, Greedy, Math, Frequency Counting
