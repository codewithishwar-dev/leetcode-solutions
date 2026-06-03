# 3635. Earliest Finish Time for Land and Water Rides II

🔗 Problem: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/

## Difficulty
Medium

## Approach

We must complete exactly one land ride and one water ride in either order.

For a ride finishing at time `x`, the next ride can:

1. Start immediately if already open.
2. Wait until its opening time.

For a water ride with:
- opening time = `s`
- duration = `d`

Finish time becomes:

```text
max(s, x) + d
```

To efficiently find the minimum value for every possible `x`:

- Sort rides by opening time.
- Build:
  - Prefix minimum duration.
  - Suffix minimum `(startTime + duration)`.

This allows each query to be answered in `O(log n)` using binary search.

The solution evaluates:

- Land → Water
- Water → Land

and returns the minimum finish time.

---

## Complexity Analysis

### Time Complexity

```text
O((n + m) log(n + m))
```

### Space Complexity

```text
O(n + m)
```

---

## Java Solution

```java
class Solution {
    // Refer Solution.java
}
```

---

## Key Learnings

- Binary Search (Upper Bound)
- Prefix Minimum Array
- Suffix Minimum Array
- Offline Query Processing
- Optimizing min(max(a,b)+c) expressions

## Tags

Binary Search, Sorting, Prefix Minimum, Suffix Minimum, Arrays
