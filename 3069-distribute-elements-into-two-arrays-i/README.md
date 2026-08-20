# 3069. Distribute Elements Into Two Arrays I

[![LeetCode](https://img.shields.io/badge/LeetCode-3069-orange?style=flat-square\&logo=leetcode)](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green?style=flat-square)](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)
[![Java](https://img.shields.io/badge/Java-Solution-orange?style=flat-square\&logo=openjdk)](./Solution.java)
[![Python](https://img.shields.io/badge/Python-Solution-blue?style=flat-square\&logo=python)](./solution.py)

> **LeetCode Problem 3069 — Distribute Elements Into Two Arrays I**

---

## 📌 Problem Statement

You are given a **1-indexed array** of **distinct integers** `nums` of length `n`.

You need to distribute all elements of `nums` between two arrays, `arr1` and `arr2`, using the following rules:

1. In the first operation, append `nums[1]` to `arr1`.
2. In the second operation, append `nums[2]` to `arr2`.
3. For every subsequent operation `i`:

   * If the last element of `arr1` is **greater than** the last element of `arr2`, append `nums[i]` to `arr1`.
   * Otherwise, append `nums[i]` to `arr2`.
4. The final `result` array is formed by concatenating `arr1` and `arr2`.

Return the resulting array.

---

## 🧾 Examples

### Example 1

**Input:**

```text
nums = [2,1,3]
```

**Output:**

```text
[2,3,1]
```

**Explanation:**

After the first two operations:

```text
arr1 = [2]
arr2 = [1]
```

For the third element:

```text
arr1.last = 2
arr2.last = 1
```

Since:

```text
2 > 1
```

`3` is appended to `arr1`.

```text
arr1 = [2,3]
arr2 = [1]
```

Finally:

```text
result = arr1 + arr2
       = [2,3] + [1]
       = [2,3,1]
```

---

### Example 2

**Input:**

```text
nums = [5,4,3,8]
```

**Output:**

```text
[5,3,4,8]
```

**Explanation:**

Initially:

```text
arr1 = [5]
arr2 = [4]
```

For `3`:

```text
5 > 4
```

Therefore, `3` is appended to `arr1`.

```text
arr1 = [5,3]
arr2 = [4]
```

For `8`:

```text
3 > 4
```

is false.

Therefore, `8` is appended to `arr2`.

```text
arr1 = [5,3]
arr2 = [4,8]
```

Finally:

```text
result = [5,3] + [4,8]
       = [5,3,4,8]
```

---

# 💡 Approach

This problem is a straightforward **simulation problem**.

There is no need for sorting, hashing, dynamic programming, or any advanced data structure.

We simply follow the rules described in the problem.

### Step 1: Initialize the two arrays

The first element always goes into `arr1`:

```text
arr1 = [nums[0]]
```

The second element always goes into `arr2`:

```text
arr2 = [nums[1]]
```

### Step 2: Process the remaining elements

Start from index `2`.

For every element:

```text
if last(arr1) > last(arr2):
    add element to arr1
else:
    add element to arr2
```

### Step 3: Build the result

Once all elements have been distributed:

```text
result = arr1 + arr2
```

Return `result`.

---

# 🔍 Algorithm

```text
1. Create two empty arrays arr1 and arr2.

2. Add nums[0] to arr1.

3. Add nums[1] to arr2.

4. For every element from nums[2] to nums[n - 1]:
      a. Compare the last element of arr1 and arr2.
      b. If arr1.last > arr2.last:
            Add the current element to arr1.
         Otherwise:
            Add the current element to arr2.

5. Concatenate arr1 and arr2.

6. Return the concatenated array.
```

---

# 🧠 Dry Run

Consider:

```text
nums = [5,4,3,8,2]
```

### Initial state

```text
arr1 = [5]
arr2 = [4]
```

### Process `3`

Compare:

```text
5 > 4
```

True.

```text
arr1 = [5,3]
arr2 = [4]
```

### Process `8`

Compare the last elements:

```text
3 > 4
```

False.

```text
arr1 = [5,3]
arr2 = [4,8]
```

### Process `2`

Compare:

```text
3 > 8
```

False.

```text
arr1 = [5,3]
arr2 = [4,8,2]
```

### Final result

```text
result = arr1 + arr2

       = [5,3] + [4,8,2]

       = [5,3,4,8,2]
```

---

# 💻 Java Solution

```java
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int size1 = 0;
        int size2 = 0;

        // First element goes to arr1
        arr1[size1++] = nums[0];

        // Second element goes to arr2
        arr2[size2++] = nums[1];

        // Distribute remaining elements
        for (int i = 2; i < n; i++) {
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }

        // Build the final result
        int[] result = new int[n];
        int index = 0;

        for (int i = 0; i < size1; i++) {
            result[index++] = arr1[i];
        }

        for (int i = 0; i < size2; i++) {
            result[index++] = arr2[i];
        }

        return result;
    }
}
```

---

# 🐍 Python Solution

```python
class Solution:
    def resultArray(self, nums):
        arr1 = [nums[0]]
        arr2 = [nums[1]]

        for i in range(2, len(nums)):
            if arr1[-1] > arr2[-1]:
                arr1.append(nums[i])
            else:
                arr2.append(nums[i])

        return arr1 + arr2
```

---

# ⏱️ Complexity Analysis

Let `n` be the length of `nums`.

## Time Complexity

```text
O(n)
```

Each element is processed exactly once.

The final concatenation also takes `O(n)` time.

Therefore, the overall complexity remains:

```text
O(n)
```

## Space Complexity

```text
O(n)
```

We maintain two arrays containing all elements of `nums`, plus the resulting array.

Therefore:

```text
Space = O(n)
```

---

# 🎯 Why This Approach Works

At every step, the problem specifies exactly where the current element should go.

The only information required to make the decision is:

```text
last element of arr1
last element of arr2
```

Therefore, we don't need to examine the entire arrays.

By maintaining the two arrays and checking their last elements, we can simulate the process directly.

---

# 🧩 DSA Pattern

This problem demonstrates the following concepts:

* Array Traversal
* Simulation
* Two Arrays
* Greedy Decision
* Sequential Processing

### Primary Pattern

> **Simulation**

The best solution is often to directly implement the rules given in the problem.

---

# ⚠️ Common Mistakes

### 1. Starting from the wrong index

The first two elements are handled separately.

```text
nums[0] → arr1
nums[1] → arr2
```

Therefore, the loop should start from:

```text
i = 2
```

---

### 2. Comparing the wrong elements

The comparison must be between the **last elements**:

```text
arr1.last > arr2.last
```

Not:

```text
arr1[0] > arr2[0]
```

and not the maximum elements of the arrays.

---

### 3. Forgetting the `else` condition

The rule is:

```text
if arr1.last > arr2.last:
    arr1
else:
    arr2
```

When `arr1.last` is not greater than `arr2.last`, the element must go to `arr2`.

---

### 4. Returning the arrays in the wrong order

The final result must be:

```text
arr1 + arr2
```

not:

```text
arr2 + arr1
```

---

# 📚 Alternative Python Implementation

Python makes the implementation particularly concise:

```python
class Solution:
    def resultArray(self, nums):
        arr1 = [nums[0]]
        arr2 = [nums[1]]

        for num in nums[2:]:
            if arr1[-1] > arr2[-1]:
                arr1.append(num)
            else:
                arr2.append(num)

        return arr1 + arr2
```

This implementation follows the problem statement almost directly.

---

# 🆚 Java vs Python

| Aspect               | Java             | Python         |
| -------------------- | ---------------- | -------------- |
| Array initialization | Manual           | Built-in lists |
| Append               | Index management | `append()`     |
| Last element         | `arr[size - 1]`  | `arr[-1]`      |
| Result construction  | Manual copy      | `arr1 + arr2`  |
| Readability          | More verbose     | More concise   |
| Time Complexity      | `O(n)`           | `O(n)`         |
| Space Complexity     | `O(n)`           | `O(n)`         |

---

# 🧪 Edge Cases

### Minimum input

```text
nums = [1,2,3]
```

The first element goes to `arr1`, the second to `arr2`, and only one comparison is required.

### Increasing sequence

```text
nums = [1,2,3,4,5]
```

Because the latest elements change after every operation, the distribution must still be simulated rather than assumed.

### Decreasing sequence

```text
nums = [5,4,3,2,1]
```

The destination can switch between the arrays depending on their latest elements.

### Alternating decisions

The current last elements determine every decision, so the same array may receive several consecutive elements or the destination may alternate.

---

# 📈 Constraints

According to the problem:

```text
3 <= n <= 50
1 <= nums[i] <= 100
```

Additional condition:

```text
All elements in nums are distinct.
```

Because `n` is very small, an `O(n)` simulation is more than sufficient.

---

# 🔗 Related Concepts

If you are practicing DSA patterns, this problem is useful for understanding:

* Simulation problems
* Greedy decisions
* Array manipulation
* Maintaining state
* Sequential processing
* Two-pointer-like state tracking

---

# 📂 Repository Structure

```text
3069-distribute-elements-into-two-arrays-i/
│
├── README.md
├── Solution.java
└── solution.py
```

---

# 🔗 Useful Links

* [LeetCode Problem](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)
* [LeetCode Solutions](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/solutions/)

---

# 📝 Key Takeaway

The key lesson from this problem is:

> **When a problem gives you a sequence of explicit operations, first consider simulating those operations directly.**

Here, every decision depends only on the most recently inserted elements of the two arrays, allowing us to solve the problem efficiently in `O(n)` time.

---

## ⭐ Difficulty

**Easy**

## 🏷️ Topics

* Array
* Simulation
* Greedy
* Data Structures

---

**Problem:** LeetCode 3069
**Title:** Distribute Elements Into Two Arrays I
**Difficulty:** Easy
**Languages:** Java, Python
