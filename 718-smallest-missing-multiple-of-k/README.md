# 718. Smallest Missing Multiple of K

[LeetCode Problem](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

**Difficulty:** Easy
**Topics:** Array, Hash Table, Simulation

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return the **smallest positive multiple** of `k` that is missing from `nums`.

A multiple of `k` is any positive integer that is divisible by `k`.

---

## Examples

### Example 1

**Input:**

```text
nums = [8, 2, 3, 4, 6]
k = 2
```

**Output:**

```text
10
```

**Explanation:**

The positive multiples of `2` are:

```text
2, 4, 6, 8, 10, 12, ...
```

`2`, `4`, `6`, and `8` are present in `nums`.

`10` is the first multiple of `2` that is missing.

Therefore, the answer is:

```text
10
```

---

### Example 2

**Input:**

```text
nums = [1, 4, 7, 10, 15]
k = 5
```

**Output:**

```text
5
```

**Explanation:**

The positive multiples of `5` are:

```text
5, 10, 15, 20, ...
```

`5` is not present in `nums`.

Therefore, the answer is:

```text
5
```

---

## Constraints

```text
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100
```

---

# Approach

The key observation is that the answer must be a **positive multiple of `k`**.

Therefore, there is no need to check every positive integer.

We only need to check:

```text
k, 2k, 3k, 4k, 5k, ...
```

For example, if:

```text
k = 3
```

the only possible answers are:

```text
3, 6, 9, 12, 15, ...
```

We can store all values from `nums` in a `HashSet`.

Then:

1. Start with `multiple = k`.
2. Check whether `multiple` exists in the set.
3. If it exists, move to the next multiple using `multiple += k`.
4. The first multiple that does not exist is the answer.

---

# Algorithm

```text
Create a set containing all elements of nums.

multiple = k

while multiple exists in the set:
    multiple = multiple + k

return multiple
```

---

# Step-by-Step Example

Consider:

```text
nums = [8, 2, 3, 4, 6]
k = 2
```

### Step 1: Create the Set

```text
{2, 3, 4, 6, 8}
```

### Step 2: Start with `k`

```text
multiple = 2
```

Check:

```text
2 → present
```

Move to the next multiple:

```text
multiple = 4
```

### Step 3

```text
4 → present
```

Move to:

```text
multiple = 6
```

### Step 4

```text
6 → present
```

Move to:

```text
multiple = 8
```

### Step 5

```text
8 → present
```

Move to:

```text
multiple = 10
```

### Step 6

```text
10 → missing
```

So:

```text
answer = 10
```

---

# Java Solution

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            present.add(num);
        }

        int multiple = k;

        while (present.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}
```

---

# Python Solution

```python
class Solution:
    def missingMultiple(self, nums, k):
        present = set(nums)

        multiple = k

        while multiple in present:
            multiple += k

        return multiple
```

---

# Complexity Analysis

Let `n` be the length of `nums`.

### Time Complexity

Creating the `HashSet` takes:

```text
O(n)
```

We then check multiples of `k` until we find a missing one.

If the answer is `m`, the number of multiples checked is approximately:

```text
m / k
```

Therefore:

```text
O(n + m/k)
```

Given the constraints, this is very efficient.

---

### Space Complexity

The `HashSet` stores the elements of `nums`.

```text
O(n)
```

---

# Why HashSet?

The main operation we need is:

> Does this number exist in `nums`?

Searching directly in an array would require `O(n)` time for each multiple.

A `HashSet` provides average `O(1)` membership checking.

Therefore, this approach avoids repeatedly scanning the entire array.

---

# Why Not Sort the Array?

We could sort `nums` and search for the required multiples.

However, sorting is unnecessary because we do not care about the order of the elements.

We only need to know whether a particular value exists.

A `HashSet` is therefore a natural choice.

---

# Alternative Approach: Boolean Array

Because the constraints guarantee:

```text
1 <= nums[i] <= 100
```

we can also use a boolean array.

```java
class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];

        for (int num : nums) {
            present[num] = true;
        }

        int multiple = k;

        while (multiple <= 100 && present[multiple]) {
            multiple += k;
        }

        return multiple;
    }
}
```

This approach uses constant auxiliary space because the array size is fixed.

---

# Edge Cases

## 1. `k` itself is missing

```text
nums = [1, 3, 7]
k = 2
```

The first positive multiple of `2` is `2`.

Since `2` is missing:

```text
answer = 2
```

---

## 2. Multiple consecutive values are present

```text
nums = [2, 4, 6, 8]
k = 2
```

Check:

```text
2  → present
4  → present
6  → present
8  → present
10 → missing
```

Therefore:

```text
answer = 10
```

---

## 3. Non-multiples are present

```text
nums = [1, 4, 7, 10, 15]
k = 5
```

Only multiples of `5` matter:

```text
5, 10, 15, 20, ...
```

The values `1`, `4`, and `7` do not affect the result.

Since `5` is missing:

```text
answer = 5
```

---

## 4. Answer Greater Than 100

The elements of `nums` are at most `100`, but the answer can be greater than `100`.

For example, if every even number up to `100` is present:

```text
2, 4, 6, ..., 100
```

with:

```text
k = 2
```

the next multiple is:

```text
102
```

Therefore:

```text
answer = 102
```

---

# Key Insight

The most important idea in this problem is:

> **Generate only candidates that can possibly be the answer.**

Since the answer must be divisible by `k`, we can ignore all other numbers.

For example, when:

```text
k = 4
```

we only check:

```text
4 → 8 → 12 → 16 → 20 → ...
```

rather than checking:

```text
1, 2, 3, 4, 5, 6, ...
```

This reduces unnecessary work and makes the solution very simple.

---

# Pattern

### Primary Pattern

**HashSet + Simulation**

### Secondary Pattern

**Generate Valid Candidates**

### Concepts Used

* Arrays
* HashSet
* Set Membership
* Simulation
* Multiples
* Iterative Search
* Constraint Analysis

---

# Common Mistake

A common mistake is to search for the smallest missing **integer** instead of the smallest missing **multiple of `k`**.

For example:

```text
nums = [1, 2, 3, 4, 6]
k = 2
```

The smallest missing positive integer is:

```text
5
```

But `5` is not a multiple of `2`.

The multiples of `2` are:

```text
2, 4, 6, 8, ...
```

So the correct answer is:

```text
8
```

Always remember that only multiples of `k` are valid candidates.

---

# Takeaway

This problem demonstrates a useful competitive programming technique:

```text
Don't search the entire answer space.
Generate only valid candidates.
```

The solution can be summarized as:

```text
Store all numbers
      ↓
Start at k
      ↓
Check k, 2k, 3k, ...
      ↓
Stop at the first missing value
```

---

# Complexity Summary

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------: | ---------------: |
| HashSet       |    `O(n + m/k)` |           `O(n)` |
| Boolean Array |    `O(n + m/k)` |           `O(1)` |

Where `m` is the first missing multiple.

---

# Repository Structure

```text
718-smallest-missing-multiple-of-k/
│
├── README.md
├── Solution.java
└── Solution.py
```

---

# Files

### Java

`Solution.java`

Contains the Java implementation using a `HashSet`.

### Python

`Solution.py`

Contains the Python implementation using a built-in `set`.

### Documentation

`README.md`

Contains:

* Problem statement
* Examples
* Constraints
* Approach
* Algorithm
* Dry run
* Java solution
* Python solution
* Complexity analysis
* Edge cases
* Key insight
* Common mistakes
* Pattern

---

# LeetCode

[718. Smallest Missing Multiple of K](https://leetcode.com/problems/smallest-missing-multiple-of-k/)
