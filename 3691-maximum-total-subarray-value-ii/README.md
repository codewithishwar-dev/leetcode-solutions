# 3691. Maximum Total Subarray Value II

## Problem Statement

You are given an integer array `nums` of length `n` and an integer `k`.

You must select exactly `k` distinct subarrays. The value of a subarray `nums[l..r]` is defined as:

```text
max(nums[l..r]) - min(nums[l..r])
```

Return the maximum possible total value obtained by selecting exactly `k` distinct subarrays.

---

## Example 1

### Input

```text
nums = [1,3,2], k = 2
```

### Output

```text
4
```

### Explanation

Selected subarrays:

```text
[1,3]   -> 3 - 1 = 2
[1,3,2] -> 3 - 1 = 2
```

Total:

```text
2 + 2 = 4
```

---

## Example 2

### Input

```text
nums = [4,2,5,1], k = 3
```

### Output

```text
12
```

### Explanation

Selected subarrays:

```text
[4,2,5,1] -> 5 - 1 = 4
[2,5,1]   -> 5 - 1 = 4
[5,1]     -> 5 - 1 = 4
```

Total:

```text
4 + 4 + 4 = 12
```

---

## Approach

For a fixed starting index `l`, define:

```text
value(l, r) = max(nums[l..r]) - min(nums[l..r])
```

Using Sparse Tables, we can answer range maximum and range minimum queries in `O(1)` time.

### Key Observations

* For each starting index `l`, the largest candidate subarray starts with `(l, n - 1)`.
* A max heap is used to always retrieve the current highest-valued subarray.
* After selecting `(l, r)`, the next candidate from the same starting position is `(l, r - 1)`.
* Repeat this process exactly `k` times.

---

## Algorithm

1. Build Sparse Tables for:

   * Range Maximum Query (RMQ)
   * Range Minimum Query (RMQ)

2. Insert `(l, n - 1)` for every starting index into a max heap.

3. While `k > 0`:

   * Extract the subarray with the maximum value.
   * Add its value to the answer.
   * Insert `(l, r - 1)` if `r > l`.

4. Return the accumulated answer.

---

## Complexity Analysis

### Time Complexity

```text
O(n log n + k log n)
```

* Sparse Table Construction: `O(n log n)`
* Heap Operations: `O(k log n)`
* RMQ Query: `O(1)`

### Space Complexity

```text
O(n log n)
```

Used by Sparse Tables and Priority Queue.

---

## Topics

* Array
* Heap (Priority Queue)
* Sparse Table
* Range Query
* Top K Elements

---

## Key Learnings

* Sparse Tables enable constant-time range maximum and minimum queries.
* Priority Queues are useful for Top-K enumeration problems.
* Instead of generating all subarrays, generate only the most promising candidates.
* Combining RMQ with a Max Heap allows handling large constraints efficiently.
