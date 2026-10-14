# 3727. Maximum Alternating Sum of Squares

- **Platform:** LeetCode
- **Problem Number:** 3727
- **Difficulty:** Medium
- **Topic:** Greedy, Sorting, Arrays
- **Language:** Java

## Problem Statement

You are given an integer array `nums`. You can rearrange its elements in any order.

The alternating score is calculated as:

`arr[0]² - arr[1]² + arr[2]² - arr[3]² + ...`

Return the maximum possible alternating score after rearranging the elements.

## Approach: Greedy + Sorting

1. Square every element and store the results in a `long` array.
2. Sort the squared values in ascending order.
3. Assign the largest `ceil(n / 2)` squared values to positive positions.
4. Assign the remaining squared values to negative positions.
5. Calculate and return the maximum score.

### Java Solution

See [`Solution.java`](Solution.java).

## Example

**Input**
```text
nums = [1, 2, 3]
```

**Optimal arrangement**
```text
[2, 1, 3]
```

**Calculation**
```text
2² - 1² + 3²
= 4 - 1 + 9
= 12
```

**Output**
```text
12
```

## Complexity Analysis

- **Time Complexity:** `O(n log n)` — sorting the squared values.
- **Space Complexity:** `O(n)` — storing the squared values.

## Key Learning

For alternating-sum maximization problems, identify which positions contribute positively and which contribute negatively. Greedy allocation of the largest values to positive positions produces the maximum score.

---

**Maintained by:** CodeWithIshwar | Ishwar Chandra Tiwari

*Learn. Solve. Share. Repeat.*
