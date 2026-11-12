
# LeetCode 3105 - Longest Strictly Increasing or Strictly Decreasing Subarray

## Problem
Given an integer array `nums`, return the length of the longest subarray that is either strictly increasing or strictly decreasing.

## Approach: Greedy / Single Pass

Maintain three variables:
- `increasing`: Current strictly increasing subarray length.
- `decreasing`: Current strictly decreasing subarray length.
- `maxLength`: Maximum length found so far.

### Algorithm
1. Initialize all counters to 1.
2. Traverse the array from index 1.
3. If the current element is greater than the previous element:
   - Increment increasing.
   - Reset decreasing to 1.
4. If the current element is smaller:
   - Increment decreasing.
   - Reset increasing to 1.
5. If elements are equal, reset both counters to 1.
6. Update the maximum length.
7. Return maxLength.

## Java Solution

See [solution.java](solution.java).

## Example 1

**Input:**
```text
nums = [1,4,3,3,2]
```

**Output:**
```text
2
```

## Example 2

**Input:**
```text
nums = [3,3,3,3]
```

**Output:**
```text
1
```

## Example 3

**Input:**
```text
nums = [3,2,1]
```

**Output:**
```text
3
```

## Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(n) | Single traversal |
| Space | O(1) | Constant extra space |

## Key Concepts
- Arrays
- Greedy
- Single Pass
- Monotonic Subarrays

## Difficulty
Easy

## Language
Java

---

**Created for CodeWithIshwar**

Consistency in problem-solving builds strong engineering fundamentals.
