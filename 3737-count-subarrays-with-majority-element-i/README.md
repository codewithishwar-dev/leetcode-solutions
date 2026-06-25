# 3737. Count Subarrays With Majority Element I

> **LeetCode 3737 | Medium | Java**

## Problem Statement

Given an integer array `nums` and an integer `target`, return the number of subarrays in which `target` is the **majority element**.

A majority element is an element that appears **strictly more than half** the number of times in a subarray.

---

## Example

### Input

```text
nums = [1,2,2,3]
target = 2
```

### Output

```text
5
```

### Explanation

The valid subarrays are:

```text
[2]
[2]
[2,2]
[1,2,2]
[2,2,3]
```

---

## Intuition

Checking every subarray and counting the occurrences of `target` would require **O(n²)** subarrays, making the solution inefficient.

Instead, transform the problem:

* `target` → **+1**
* every other element → **-1**

For any subarray,

```text
sum = (#target) - (#other elements)
```

If `target` is the majority element,

```text
#target > length / 2
```

which simplifies to

```text
#target - #others > 0
```

Therefore, we only need to count subarrays whose transformed sum is **greater than zero**.

---

## Approach

1. Transform the array:

   * `target → +1`
   * `others → -1`
2. Build the prefix sum array.
3. For every prefix sum, count how many previous prefix sums are **smaller**.
4. Since prefix sums can be negative, apply **Coordinate Compression**.
5. Use a **Fenwick Tree (Binary Indexed Tree)** to efficiently count previous prefix sums.

---

## Algorithm

1. Convert each number into `+1` or `-1`.
2. Compute prefix sums.
3. Coordinate compress all prefix sums.
4. Traverse the prefix array:

   * Query the Fenwick Tree for the number of smaller prefix sums.
   * Add the result to the answer.
   * Insert the current prefix sum into the Fenwick Tree.

---

## Correctness

Let

```text
prefix[i]
```

represent the transformed prefix sum.

For any subarray `(l...r)`,

```text
sum = prefix[r + 1] - prefix[l]
```

The transformed subarray sum must satisfy

```text
sum > 0
```

which is equivalent to

```text
prefix[r + 1] > prefix[l]
```

The Fenwick Tree maintains frequencies of previous prefix sums, allowing us to efficiently count all prefix sums that are smaller than the current one.

Thus, every valid subarray is counted exactly once.

---

## Complexity Analysis

| Complexity | Value          |
| ---------- | -------------- |
| Time       | **O(n log n)** |
| Space      | **O(n)**       |

---

## Data Structures Used

* Prefix Sum
* Coordinate Compression
* Fenwick Tree (Binary Indexed Tree)
* HashMap

---

## Key Takeaways

* Convert majority conditions into mathematical inequalities.
* Transform the array using `+1` and `-1`.
* Use Prefix Sum to convert subarray problems into prefix comparisons.
* Coordinate Compression handles negative prefix sums.
* Fenwick Tree efficiently answers prefix frequency queries in **O(log n)**.

---

## Solution

```java
// See Solution.java
```
